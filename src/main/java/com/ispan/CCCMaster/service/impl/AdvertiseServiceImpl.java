package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.Advertise.Advertise;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.dao.AdvertiseDao;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import com.ispan.CCCMaster.model.dao.ProductDao;
import com.ispan.CCCMaster.model.dto.AdvertiseRequest;
import com.ispan.CCCMaster.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

    @Autowired
    private AdvertiseDao advertiseDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public void createAdvertise(AdvertiseRequest advertiseRequest) {
        Advertise advertise = new Advertise();
        advertise.setStartTime(handleDate(advertiseRequest.getStartDateTime()));
        advertise.setEndTime(handleDate(advertiseRequest.getEndDateTime()));
        advertiseDao.save(advertise);

    }

// 原code
//    @Override
//    public void createAdvertise(AdvertiseRequest advertiseRequest, Advertise advertise){
//
//
//
//        if(!advertiseRequest.getStartDateTime().equals("")) {
//            advertise.setStartTime(handleDate(advertiseRequest.getStartDateTime()));
//        }
//        if(!advertiseRequest.getEndDateTime().equals("")) {
//            advertise.setEndTime(handleDate(advertiseRequest.getEndDateTime()));
//        }
//        advertiseDao.save(advertise);
//    }

    // 原code

    //多對多測試
    @Override
    public void createAdvertiseTest(AdvertiseRequest advertiseRequest,Integer productId){

        Advertise advertise = new Advertise();
        Set<Product> productsSet = new HashSet<>();
        productsSet.add(productDao.findById(productId).orElse(null));

        advertise.setProducts(productsSet);

        if(!advertiseRequest.getStartDateTime().equals("")) {
            advertise.setStartTime(handleDate(advertiseRequest.getStartDateTime()));
        }
        if(!advertiseRequest.getEndDateTime().equals("")) {
            advertise.setEndTime(handleDate(advertiseRequest.getEndDateTime()));
        }
        advertiseDao.save(advertise);
    }
    //多對多測試

    @Override
    public Advertise findAdvertiseById(Integer id) {
        Optional<Advertise> option = advertiseDao.findById(id);
        if(option.isPresent()) {
            return option.get();
        }
        throw new RuntimeException("沒有找到廣告");
    }

    public Page<Advertise> findByPage(Integer pageNumber) {
        Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "startTime");
        Page<Advertise> page = advertiseDao.findAll(pgb);
        return page;
    }



    @Override
    public void deleteAdvertiseById(Integer id) {
        advertiseDao.deleteById(id);
    }


    @Override
    @Transactional
    public void updateAdvertiseById(Advertise advertise){
        advertiseDao.save(advertise);
    }


    @Override
    @Transactional
    public void updateAdvertiseById(Integer id,AdvertiseRequest advertiseRequest){
        Advertise foundadvertise = advertiseDao.findById(id).orElse(null);
        if(foundadvertise == null){
            throw new RuntimeException("沒有找到廣告");
        }
        foundadvertise.setStartTime(handleDate(advertiseRequest.getStartDateTime()));
        foundadvertise.setEndTime(handleDate(advertiseRequest.getEndDateTime()));

        if(!advertiseRequest.getStartDateTime().equals("")) {
            foundadvertise.setStartTime(handleDate(advertiseRequest.getStartDateTime()));
        }
        if(!advertiseRequest.getEndDateTime().equals("")) {
            foundadvertise.setEndTime(handleDate(advertiseRequest.getEndDateTime()));
        }
        advertiseDao.save(foundadvertise);
    }

//    @Override
//    @Transactional
//    public void updateAdvertiseById(Advertise input){
//        Optional<Advertise> option = advertiseDao.findById(input.getAdvertiseId());
//
//        if(option.isPresent()) {
//            Advertise oldadvertise = option.get();
//            oldadvertise.setStartTime(input.getStartTime());
//            oldadvertise.setEndTime(input.getEndTime());
//            advertiseDao.save(oldadvertise);
//        }else
//            throw new RuntimeException("沒有找到廣告");
//    }


    private Date handleDate(String dateString) {
        Date date;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期轉換過程發生錯誤!");
        }

        return date;

    }

    @Override
    public Advertise getLatestAdvertise() {
        return advertiseDao.findFirstByOrderByStartTimeDesc();
    }

    @Override
    public Page<Product> addProductToAdvertise(Integer pageNumber) {
        return null;
    }


    @Override//搜尋產品並分頁 後台
    public Page<Product> addProductToAdvertise(Advertise advertise, Integer productId, Integer pageNumber) {
        Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "productId");
        Page<Product> page = productDao.findAll(pgb);


        Set<Product> productsSet = new HashSet<>();
        productsSet.add(productDao.findById(productId).orElse(null));
        return page;
    }

    @Override
    public void createProductToAdvertise(AdvertiseRequest advertiseRequest, Integer productId) {
        Advertise advertise = new Advertise();
        Set<Product> productsSet = new HashSet<>();
        productsSet.add(productDao.findById(productId).orElse(null));

        advertise.setProducts(productsSet);
        advertiseDao.save(advertise);
    }

    @Override
    public List<Advertise> advertiseByTime(Date nowDate) {

        List<Advertise> activeAds = advertiseDao.findActiveAds(nowDate);


        return activeAds;

    }

}
