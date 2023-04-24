package com.ispan.CCCMaster.service;

public interface CrawlerService {


    void crawlerPchome(Integer id);

    String httpRequestGetJson(String url);

    int getTotalPage(String pchomeHttpRequest);

    boolean isScrapingExpired(Integer id);
}
