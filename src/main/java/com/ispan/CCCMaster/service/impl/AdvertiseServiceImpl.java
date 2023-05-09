package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.Advertise.Advertise;
import com.ispan.CCCMaster.model.dao.AdvertiseDao;
import com.ispan.CCCMaster.model.dao.ProductDao;
import com.ispan.CCCMaster.model.dto.AdvertiseRequest;
import com.ispan.CCCMaster.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

    @Autowired
    private AdvertiseDao advertiseDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public void createAdvertise(AdvertiseRequest advertiseRequest) {
        Advertise advertise = new Advertise();
        advertise.setStartTime(handleDate(advertiseRequest.getStartDateTime()));
        advertise.setEndTime(handleDate(advertiseRequest.getEndDateTime()));
        advertiseDao.save(advertise);

    }

    @Override
    public void createAdvertise(AdvertiseRequest advertiseRequest, Advertise advertise){


        if(!advertiseRequest.getStartDateTime().equals("")) {
            advertise.setStartTime(handleDate(advertiseRequest.getStartDateTime()));
        }
        if(!advertiseRequest.getEndDateTime().equals("")) {
            advertise.setEndTime(handleDate(advertiseRequest.getEndDateTime()));
        }
        advertiseDao.save(advertise);
    }

    @Override
    public Advertise findAdvertiseById(Integer id) {
        Optional<Advertise> option = advertiseDao.findById(id);
        if(option.isPresent()) {
            return option.get();
        }
        throw new RuntimeException("沒有找到廣告");
    }

    @Override
    public List<Advertise> findAllAdvertise() {
        return advertiseDao.findAll();
    }

    @Override
    public void deleteAdvertiseById(Integer id) {
        advertiseDao.deleteById(id);
    }


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
}
