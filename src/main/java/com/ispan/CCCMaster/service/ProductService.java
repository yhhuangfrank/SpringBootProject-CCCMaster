package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public interface ProductService {


    void createProduct(Product product, String categoryName) throws IOException;


    Page<Product> findByPage(Integer pageNumber);

//    Page<Product> findByPageSortByPrice(Integer pageNumber);

//    Page<Product> findByPageSearchByNameSortByPrice(Integer pageNumber, String productName);

    Page<Product> findByPageAjax(Integer pageNumber, String keyword, String sort,String catagoryName);


//    Page<Product> findByCriteria(Integer pageNumber, String keyword, String sort, String categoryName);

    Page<Product> findByCriteria(Integer pageNumber, String keyword, String sort, String categoryName);

    byte[] getProductImageById(Integer productId);

    void deleteProduct(Integer productId);

    Product findProductById(Integer productId);



    @Transactional
    void editProductById(Product product, String categoryName) throws IOException;



    void productViews(Integer id);
}
