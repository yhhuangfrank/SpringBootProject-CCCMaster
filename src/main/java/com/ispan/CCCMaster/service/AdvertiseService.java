package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.Advertise.Advertise;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.dto.AdvertiseRequest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

public interface AdvertiseService {
   void createAdvertise(AdvertiseRequest advertiseRequest);

   void createAdvertise(AdvertiseRequest advertiseRequest, Advertise advertise);

   Advertise findAdvertiseById(Integer id);

   List<Advertise> findAllAdvertise();

   void deleteAdvertiseById(Integer id);


}
