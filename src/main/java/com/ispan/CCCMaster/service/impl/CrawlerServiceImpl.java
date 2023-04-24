package com.ispan.CCCMaster.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ispan.CCCMaster.model.bean.weihsiang.Crawler;
import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import com.ispan.CCCMaster.model.dao.CrawlerDao;
import com.ispan.CCCMaster.service.CrawlerService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrawlerServiceImpl implements CrawlerService {
@Autowired
    private CrawlerDao crawlerDao;
@Autowired
private ProductServiceImpl productService;
    @Override
    public   void crawlerPchome(Integer id) {
        String pchomeHttpRequest = "https://ecshweb.pchome.com.tw/search/v3.3/all/results?";
        String sort = "sale/dc";
        String url;
        Product product=productService.findProductById(id);
        String keyword=product.getProductName();
        keyword=keyword.replace(" ","%20");//把keyword中的空白字元換成 uri的空白字元編碼%20
        System.out.println("keyword:"+keyword);
        List<Crawler> crawlers=new ArrayList<>();
        url = pchomeHttpRequest + "q=" + keyword;
        int totalPage = getTotalPage(url);
        for (int page = 1; page <= totalPage; page++) {
            url = pchomeHttpRequest + "q=" + keyword+"&page=" + page + "&sort=" + sort;
            System.out.println(url);
            String content = httpRequestGetJson(url);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode prods;
            try {
                JsonNode node = mapper.readTree(content);
                prods = node.get("prods");
                for (JsonNode prod : prods) {
                    Crawler crawler=new Crawler();
                    int price = prod.get("price").asInt();
                    String name = prod.get("name").asText();
                    crawler.setPrice(price);
                    crawler.setProduct(product);
                    crawler.setCrawlerProductName(name);
                    crawlers.add(crawler);
                }
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        crawlerDao.saveAll(crawlers);
    }

    @Override
    public String httpRequestGetJson(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String content = null;
        try {
            HttpGet request = new HttpGet(url);
            response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            return content;
        } catch (Exception e) {
            e.printStackTrace();
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return content;
    }



    @Override
    public int getTotalPage(String pchomeHttpRequest) {
        String content = httpRequestGetJson(pchomeHttpRequest);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = null;
        int totalPage = 0;
        try {
            node = mapper.readTree(content);
            totalPage = node.get("totalPage").asInt();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return totalPage;
    }
}

