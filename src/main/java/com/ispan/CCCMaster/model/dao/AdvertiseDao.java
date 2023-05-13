package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.Advertise.Advertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AdvertiseDao extends JpaRepository<Advertise, Integer> {

    Advertise findFirstByOrderByStartTimeDesc();

    //假設參加拍賣會，拍賣期間為5/1 10:00~5/5 10:00，如果今天是5/4 09:00則可參與拍賣，如果今天是5/5 10:01則不可參與拍賣
    //Date now = new Date();於controller中取得現在時間，在Dao中Query語法比較開始與結束時間
    @Query("SELECT a FROM Advertise a WHERE a.startTime <= :now AND a.endTime >= :now")
    List<Advertise> findActiveAds(@Param("now") Date now);

}