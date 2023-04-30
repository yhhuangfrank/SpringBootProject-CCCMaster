package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.product.Crawler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface CrawlerDao extends JpaRepository<Crawler, Integer> {
    @Query("SELECT MAX(c.crawlerDate) FROM Crawler c WHERE c.product.productId = :id")
     Date findLatestCrawlerDateByProductId(@Param("id") Integer id);
}
