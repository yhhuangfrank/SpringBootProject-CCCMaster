package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import com.ispan.CCCMaster.model.dao.ProductRepository;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public String convertToBase64(MultipartFile imageFile) throws IOException {
        byte[] bytes = imageFile.getBytes();
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }

    public Page<Product> findByPage(Integer pageNumber) {
        Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "productId");
        Page<Product> page = productRepository.findAll(pgb);
        return page;
    }

    public byte[] getProductImage(Integer productId) {
        Optional<Product> option=productRepository.findById(productId);
        if(option.isPresent()) {
            Product product = option.get();
            return product.getImage();
        }
        else return null;
    }


}
