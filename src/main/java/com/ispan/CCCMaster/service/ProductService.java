package com.ispan.CCCMaster.service;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ispan.CCCMaster.model.bean.product.Product;

public interface ProductService {


    void createProduct(Product product, String categoryName) throws IOException;


    Page<Product> findByPage(Integer pageNumber);



    Page<Product> findByCriteria(Integer pageNumber, String keyword, String sort, String categoryName);


    void deleteProduct(Integer productId);

    Product findProductById(Integer productId);



    @Transactional
    void editProductById(Product product, String categoryName) throws IOException;



    void productViews(Integer id);

    void updateProductImages(Product product, MultipartFile mainImageFile, MultipartFile[] imageFiles) throws IOException;



    String generateDescription(String productName, String features, String target);
}
