package com.ispan.CCCMaster.service;

public interface CrawlerService {
    void crawlerPchome(String keyword);

    String httpRequestGetJson(String url);

    int getTotalPage(String pchomeHttpRequest);
}
