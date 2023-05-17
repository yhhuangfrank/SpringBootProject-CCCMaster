package com.ispan.CCCMaster.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ispan.CCCMaster.model.bean.category.Category;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.bean.product.ProductImg;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import com.ispan.CCCMaster.model.dao.ProductDao;

import com.ispan.CCCMaster.model.dao.ProductImgDao;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.criteria.Predicate;
import java.io.*;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class ProductServiceImpl implements com.ispan.CCCMaster.service.ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductImgDao productImgDao;


    @Value("${chatgptApiKey}")
    private String apiKey;

    private String API_URL = "https://api.openai.com/v1/chat/completions";


    @Override//建立產品
    public void createProduct(Product product, String categoryName) throws IOException {//
        List<ProductImg> productImgs = new ArrayList<>();
        ProductImg img = new ProductImg();
        Category category = categoryDao.findCategoryByName(categoryName);
        if (category != null) {//判斷是否已有該類別
            product.setCategory(category);
        } else {
            Category newCategory = new Category();
            newCategory.setName(categoryName);
            product.setCategory(newCategory);
        }
        if (product.getMainImageFile() != null) {//主要圖片處理
            img = new ProductImg();
            img.setImage(product.getMainImageFile().getBytes());
            img.setMainImage(true);
            img.setProduct(product);
            productImgs.add(img);
        }

        if(Arrays.stream(product.getImageFile()).anyMatch(file -> !file.isEmpty())){
            for (MultipartFile imageFile : product.getImageFile()) {//次要圖片處理
                if (imageFile != null) {
                    System.out.println("imageFile!=null");
                    img = new ProductImg();
                    img.setImage(imageFile.getBytes());
                    img.setProduct(product);
                    img.setMainImage(false);
                    productImgs.add(img);
                }
            }
        }

        product.setProductImgs(productImgs);
        productDao.save(product);
    }


    @Override//搜尋產品並分頁 後台使用中
    public Page<Product> findByPage(Integer pageNumber) {
        Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "productId");
        Page<Product> page = productDao.findAll(pgb);
        return page;
    }


    @Override //多條件搜尋 分頁 前台使用中
    public Page<Product> findByCriteria(Integer pageNumber, String keyword, String sort, String categoryName) {
        // 判定搜尋方向
        String sortBy[] = sort.split("_");
        String orderBy = sortBy[0]; //依甚麼排序
        Sort.Direction direction;

        //排序方式
        if (sortBy[1].equals("asc")) {
            direction = Sort.Direction.ASC;
        } else {
            direction = Sort.Direction.DESC;
        }

        Specification<Product> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            Predicate p;
            // 判定輸入值是否為空
            if (!categoryName.equals("全部")) {
                Category category = categoryDao.findCategoryByName(categoryName);
                // 查詢相對應種類
                p = criteriaBuilder.equal(root.get("category"), category);
                predicates.add(p);
            }
            if (!keyword.equals("")) {
                p = criteriaBuilder.like(root.get("productName"), "%" + keyword + "%");
                predicates.add(p);
            }

            // 將搜尋條件從 list 複製到一空 array
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };


        // 建立 Pageable 物件帶入傳遞參數
        Pageable pgb = PageRequest.of(pageNumber - 1, 3, direction, orderBy);

        return productDao.findAll(spec, pgb);
    }


    @Override//刪除產品
    public void deleteProduct(Integer productId) {
        productDao.deleteById(productId);
    }

    @Override//查詢產品 by id
    public Product findProductById(Integer productId) {
        Optional<Product> option = productDao.findById(productId);
        if (option.isEmpty()) {
            return null;
        } else return option.get();
    }

    @Override//修改產品 by id
    @Transactional
    public void editProductById(Product product, String categoryName) throws IOException {//也許可做更新失敗的判斷
        Optional<Product> option = productDao.findById(product.getProductId());
        List<ProductImg> productImgs = new ArrayList<>();
        ProductImg img = new ProductImg();
        if (option.isPresent()) {
            Product oldProduct = option.get();
            oldProduct.setProductName(product.getProductName());
            oldProduct.setPrice(product.getPrice());
            oldProduct.setInventory(product.getInventory());
            oldProduct.setActive(product.getActive());
            oldProduct.setDescription(product.getDescription());


            if (categoryDao.findCategoryByName(categoryName) != null) {
                oldProduct.setCategory(categoryDao.findCategoryByName(categoryName));
            } else {
                Category newCategory = new Category();
                newCategory.setName(categoryName);
                oldProduct.setCategory(newCategory);
            }
            updateProductImages(oldProduct, product.getMainImageFile(), product.getImageFile());
        }
    }

    @Override
    @Transactional
    public void updateProductImages(Product product, MultipartFile mainImageFile, MultipartFile[] imageFiles) throws IOException {
        if (mainImageFile != null && !mainImageFile.isEmpty()) {
            ProductImg mainImg = productImgDao.findByProductAndMainImage(product, true);
            if (mainImg != null) {
                mainImg.setImage(mainImageFile.getBytes());
                mainImg.setCreateDate(new Date());
            } else {
                ProductImg newMainImg = new ProductImg();
                newMainImg.setImage(mainImageFile.getBytes());
                newMainImg.setCreateDate(new Date());
                newMainImg.setMainImage(true);
                newMainImg.setProduct(product);
                productImgDao.save(newMainImg);
            }
        }

        if (imageFiles != null && Arrays.stream(imageFiles).anyMatch(file -> !file.isEmpty())) {
            System.out.println("enter delete image");
            List<ProductImg> imgs = productImgDao.findByProductAndMainImageFalse(product);
            for (ProductImg img : imgs) {
                productImgDao.delete(img);
            }

            for (MultipartFile file : imageFiles) {
                if (!file.isEmpty()) {
                    ProductImg newImg = new ProductImg();
                    newImg.setImage(file.getBytes());
                    newImg.setCreateDate(new Date());
                    newImg.setMainImage(false);
                    newImg.setProduct(product);
                    productImgDao.save(newImg);
                }
            }
        }
    }





    @Transactional
    @Override// 計算瀏覽人次
    public void productViews(Integer id) {
        Product product = findProductById(id);
        product.setProductViews(product.getProductViews() + 1);
    }

    @Override
    public String generateDescription(String productName, String features, String target) {
        String content = "有一個產品名稱叫做"+productName+"，產品特色是"+features+"，主打的客群是"+target+"，幫我產生這個產品的文案";
        String response = null;
        try {
            response = sendGPTRequest(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ChatGPT 產生的文案: " + response);
        return response;
    }


    private String sendGPTRequest(String content) throws IOException {
        String model = "gpt-3.5-turbo";
        JSONObject requestBody = new JSONObject();
        requestBody.put("model", model);
        requestBody.put("messages", new JSONArray().put(new JSONObject()
                .put("role", "user")
                .put("content", content)));
        requestBody.put("temperature",0.5);
        String requestBodyString = requestBody.toString();

        HttpPost request = new HttpPost(API_URL);
        StringEntity params = new StringEntity(requestBodyString, StandardCharsets.UTF_8);
        request.addHeader("Authorization", "Bearer " + apiKey);
        request.addHeader("content-type", "application/json");
        request.setEntity(params);

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpResponse response = httpClient.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());
           String responseContent=getContentFromJsonString(responseBody);
            return responseContent;
        }

    }

    public static String getContentFromJsonString(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonString);

            String content = rootNode
                    .get("choices")
                    .get(0)
                    .get("message")
                    .get("content")
                    .asText();

            return content;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
