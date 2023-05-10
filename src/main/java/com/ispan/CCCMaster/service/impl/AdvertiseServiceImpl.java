package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.Advertise.Advertise;
import com.ispan.CCCMaster.model.dao.AdvertiseDao;
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
import java.util.Date;
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

    public Page<Advertise> findByPage(Integer pageNumber) {
        Pageable pgb = PageRequest.of(pageNumber - 1, 3, Sort.Direction.DESC, "startTime");
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
}
