package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {


    void createProduct(Product product, String categoryName) throws IOException;

    String convertToBase64(MultipartFile imageFile) throws IOException;

    Page<Product> findByPage(Integer pageNumber);

    Page<Product> findByPageSortByPrice(Integer pageNumber);

    Page<Product> findByPageSearchByNameSortByPrice(Integer pageNumber, String productName);

    byte[] getProductImageById(Integer productId);

    void deleteProduct(Integer productId);

    Product findProductById(Integer productId);



    @Transactional
    void editProductById(Product product, String categoryName) throws IOException;



    void productViews(Integer id);
}
