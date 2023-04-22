package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.bid.Category;
import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import com.ispan.CCCMaster.model.dao.ProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Service
public class ProductServiceImpl implements com.ispan.CCCMaster.service.ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public void createProduct(Product product, String categoryName) throws IOException {
        Category category = categoryDao.findCategoryByNameReturnCategory(categoryName);
        if(category!=null){
            product.setCategory(category);
        }else {
            Category newCategory=new Category();
            newCategory.setName(categoryName);
            product.setCategory(newCategory);
        }

        product.setImage(product.getImageFile().getBytes());
        productDao.save(product);
    }

    @Override
    public String convertToBase64(MultipartFile imageFile) throws IOException {
        byte[] bytes = imageFile.getBytes();
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }

    @Override
    public Page<Product> findByPage(Integer pageNumber) {
        Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "productId");
        Page<Product> page = productDao.findAll(pgb);
        return page;
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
            if(categoryDao.findCategoryByNameReturnCategory(categoryName)!=null){
                oldProduct.setCategory(categoryDao.findCategoryByNameReturnCategory(categoryName));
            }else {
                Category newCategory=new Category();
                newCategory.setName(categoryName);
                oldProduct.setCategory(newCategory);
            }
        }

    }
}
