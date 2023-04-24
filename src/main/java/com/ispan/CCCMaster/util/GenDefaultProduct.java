package com.ispan.CCCMaster.util;

import com.github.javafaker.Faker;
import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import com.ispan.CCCMaster.model.dao.ProductDao;
import com.ispan.CCCMaster.service.ProductService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class GenDefaultProduct {
    @Autowired
    private ProductDao productDao;

    private List<Product> defaultProducts=new ArrayList<>();
    @PostConstruct
    public void genDefaultProducts(){
        long productNum=productDao.count();
        if(productNum>0) return;
        String [] imgUrl={"https://images.unsplash.com/photo-1598327105666-5b89351aff97?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=627&q=80","https://images.unsplash.com/photo-1561112078-7d24e04c3407?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1965&q=80"};
        String[] defaultProductNames={"手機","鍵盤"};
        String[] defaultCategoryNames = {"手機", "鍵盤"};
        Faker faker = new Faker();
        InputStream inputStream = null;
        for(int j=0;j<10;j++){
        for(int i =0;i<defaultProductNames.length;i++){
            try {
                URL url = new URL(imgUrl[i]);
                inputStream = url.openStream();
                byte[] img = IOUtils.toByteArray(inputStream);
                Product product=new Product();
                product.setProductName(defaultProductNames[i]);
                product.setImage(img);
                product.setActive(true);
                product.setInventory(faker.number().numberBetween(0,20));
                product.setPrice(faker.number().numberBetween(0,1000));
                product.setDescription(faker.lorem().paragraph(3));
                defaultProducts.add(product);
               // productService.createProduct(product,defaultCategoryNames[i]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        }
        productDao.saveAll(defaultProducts);
    }

}
