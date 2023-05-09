package com.ispan.CCCMaster.service;

import org.springframework.data.domain.Page;

import com.ispan.CCCMaster.model.bean.product.Crawler;

public interface CrawlerService {


    void crawlerPchome(Integer id);

    String httpRequestGetJson(String url);

    int getTotalPage(String pchomeHttpRequest);

    boolean isScrapingExpired(Integer id);

    Page<Crawler> findCrawlerProductById(Integer pageNumber, Integer crawlerId);
}
