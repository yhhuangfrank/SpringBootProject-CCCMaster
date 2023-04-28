package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.bid.Category;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import com.ispan.CCCMaster.model.dao.ProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.Predicate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements com.ispan.CCCMaster.service.ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public void createProduct(Product product, String categoryName) throws IOException {
        Category category = categoryDao.findCategoryByName(categoryName);
        if (category != null) {
            product.setCategory(category);
        } else {
            Category newCategory = new Category();
            newCategory.setName(categoryName);
            product.setCategory(newCategory);
        }
        if (product.getImageFile() != null) {
            product.setImage(product.getImageFile().getBytes());
        }

        productDao.save(product);
    }


    @Override
    public Page<Product> findByPage(Integer pageNumber) {
        Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "productId");
        Page<Product> page = productDao.findAll(pgb);
        return page;
    }

//    @Override
//    public Page<Product> findByPageSortByPrice(Integer pageNumber) {
//        Pageable pgb = PageRequest.of(pageNumber - 1, 9, Sort.Direction.DESC, "price");
//        Page<Product> page = productDao.findAll(pgb);
//        return page;
//    }

//    @Override
//    public Page<Product> findByPageSearchByNameSortByPrice(Integer pageNumber, String productName) {
//        Pageable pgb = PageRequest.of(pageNumber - 1, 9, Sort.Direction.DESC, "price");
//        Page<Product> page = productDao.findByName(productName, pgb);
//        return page;
//    }

    @Override
    public Page<Product> findByPageAjax(Integer pageNumber, String keyword, String sort,String categoryName) {
        Pageable pgb = null;
        Page<Product> page;
        if (sort.equals("default")) {
            pgb = PageRequest.of(pageNumber - 1, 9, Sort.Direction.ASC, "productId");
        } else {
            String sortBy[] = sort.split("_");
            if (sortBy[1].equals("desc")) {
                pgb = PageRequest.of(pageNumber - 1, 9, Sort.Direction.DESC, sortBy[0]);
            } else if (sortBy[1].equals("asc")) {
                pgb = PageRequest.of(pageNumber - 1, 9, Sort.Direction.ASC, sortBy[0]);
            }
        }
        if (keyword.equals("")) {
            page = productDao.findByAllIsActive(pgb);

        } else {
            page = productDao.findByNameIsActive(keyword, pgb);
        }
        return page;

    }

    @Override
    public Page<Product> findByCriteria(Integer pageNumber, String keyword, String sort, String categoryName){
        // 判定搜尋方向
        System.out.println("enter findByCriteria");
        System.out.println("sort="+sort);
        System.out.println("categoryName="+categoryName);
        String sortBy[] = sort.split("_");
        String orderBy=sortBy[0]; //依甚麼排序
        Sort.Direction direction;

        //排序方式
        if(sortBy[1].equals("asc")){
            direction = Sort.Direction.ASC;
        }else {
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
            if(!keyword.equals("")){
               p = criteriaBuilder.like(root.get("productName"), "%"+keyword+"%");
                predicates.add(p);
            }

            // 將搜尋條件從 list 複製到一空 array
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };



        // 建立 Pageable 物件帶入傳遞參數
        Pageable pgb = PageRequest.of(pageNumber - 1, 9, direction, orderBy);

        return productDao.findAll(spec, pgb);
    }


    @Override
    public byte[] getProductImageById(Integer productId) {
        Optional<Product> option = productDao.findById(productId);
        if (option.isPresent()) {
            Product product = option.get();
            return product.getImage();
        } else return null;
    }

    @Override
    public void deleteProduct(Integer productId) {
        productDao.deleteById(productId);
    }

    @Override
    public Product findProductById(Integer productId) {
        Optional<Product> option = productDao.findById(productId);
        if (option.isEmpty()) {
            return null;
        } else return option.get();
    }

    @Override
    @Transactional
    public void editProductById(Product product, String categoryName) throws IOException {//也許可做更新失敗的判斷
        Optional<Product> option = productDao.findById(product.getProductId());
        if (option.isPresent()) {
            Product oldProduct = option.get();
            oldProduct.setProductName(product.getProductName());
            oldProduct.setPrice(product.getPrice());
            oldProduct.setInventory(product.getInventory());
            oldProduct.setActive(product.getActive());
            if (!product.getImageFile().isEmpty()) {//如果更新的圖片不為空
                oldProduct.setImage(product.getImageFile().getBytes());
            }
            if (categoryDao.findCategoryByName(categoryName) != null) {
                oldProduct.setCategory(categoryDao.findCategoryByName(categoryName));
            } else {
                Category newCategory = new Category();
                newCategory.setName(categoryName);
                oldProduct.setCategory(newCategory);
            }
        }
    }

    @Transactional
    @Override
    public void productViews(Integer id) {
        Product product = findProductById(id);
        product.setProductViews(product.getProductViews() + 1);
    }


}
