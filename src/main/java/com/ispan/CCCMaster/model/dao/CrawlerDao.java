package com.ispan.CCCMaster.model.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.product.Crawler;

public interface CrawlerDao extends JpaRepository<Crawler, Integer> {
    @Query("SELECT MAX(c.crawlerDate) FROM Crawler c WHERE c.product.productId = :id")
     Date findLatestCrawlerDateByProductId(@Param("id") Integer id);
    @Query("select c.crawlerProductName,c.price,c.crawlerDate from Crawler c Where c.product.productId= :id")
    Page<Crawler> findLatestCrawlerPageByProductId(@Param("id")Integer id, Pageable pageable);

}
