package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.Advertise.Advertise;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.dto.AdvertiseRequest;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface AdvertiseService {
   void createAdvertise(AdvertiseRequest advertiseRequest);

   //原code
//   void createAdvertise(AdvertiseRequest advertiseRequest, Advertise advertise);
    //原code

    //多對多測試
    void createAdvertiseTest(AdvertiseRequest advertiseRequest, Integer productId);
    //多對多測試

   Advertise findAdvertiseById(Integer id);


   Page<Advertise> findByPage(Integer pageNumber);

    Page<Product> addProductToAdvertise(Integer pageNumber);

    Page<Product> addProductToAdvertise(Advertise advertise, Integer productId, Integer pageNumber);


    void deleteAdvertiseById(Integer id);

    void updateAdvertiseById(Advertise advertise);

    void updateAdvertiseById(Integer id, AdvertiseRequest advertiseRequest);

    void createProductToAdvertise(AdvertiseRequest advertiseRequest, Integer productId);






    Advertise getLatestAdvertise();

//    Page<Product> addProductToAdvertise(Integer pageNumber);


    List<Advertise> advertiseByTime(Date nowDate);
}
