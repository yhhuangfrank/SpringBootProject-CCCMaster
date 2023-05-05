package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.category.Category;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.bean.product.ProductImg;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import com.ispan.CCCMaster.model.dao.ProductDao;

import com.ispan.CCCMaster.model.dao.ProductImgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.criteria.Predicate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements com.ispan.CCCMaster.service.ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductImgDao productImgDao;


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
        for (MultipartFile imageFile : product.getImageFile()) {//次要圖片處理
            if (imageFile != null) {
                img = new ProductImg();
                img.setImage(imageFile.getBytes());
                img.setProduct(product);
                img.setMainImage(false);
                productImgs.add(img);
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
        Pageable pgb = PageRequest.of(pageNumber - 1, 9, direction, orderBy);

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


            if (categoryDao.findCategoryByName(categoryName) != null) {
                oldProduct.setCategory(categoryDao.findCategoryByName(categoryName));
            } else {
                Category newCategory = new Category();
                newCategory.setName(categoryName);
                oldProduct.setCategory(newCategory);
            }
            if (product.getMainImageFile() != null) {
                ProductImg oldProductMainImage = productImgDao.findMainImageByProductId(product.getProductId());
                oldProductMainImage.setImage(product.getMainImageFile().getBytes());
            }
            if (product.getImageFile() != null) {
                deleteOldProductImage(product);
                List<ProductImg> imageList= setOtherImageList(product.getImageFile());
                product.setProductImgs(imageList);
            }
        }
    }

    public void deleteOldProductImage(Product product) {
        List<Integer> oldImage = productImgDao.findNotMainImageByProductId(product.getProductId());
        for (Integer imageId : oldImage) {
            productImgDao.deleteById(imageId);
        }
    }

    public List<ProductImg> setOtherImageList(MultipartFile[] files) {
        List<ProductImg> imageList = new ArrayList<>();
        ProductImg image = new ProductImg();
        for (MultipartFile file : files) {
            try {
                image.setImage(file.getBytes());
                imageList.add(image);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return imageList;
    }


    @Transactional
    @Override// 計算瀏覽人次
    public void productViews(Integer id) {
        Product product = findProductById(id);
        product.setProductViews(product.getProductViews() + 1);
    }


}
