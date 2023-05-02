package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.bean.product.ProductImg;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

public interface ProductService {


    void createProduct(Product product, String categoryName) throws IOException;


    Page<Product> findByPage(Integer pageNumber);



    Page<Product> findByCriteria(Integer pageNumber, String keyword, String sort, String categoryName);


    void deleteProduct(Integer productId);

    Product findProductById(Integer productId);



    @Transactional
    void editProductById(Product product, String categoryName) throws IOException;



    void productViews(Integer id);
}
