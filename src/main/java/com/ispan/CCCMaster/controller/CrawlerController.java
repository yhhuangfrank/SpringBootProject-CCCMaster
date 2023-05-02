package com.ispan.CCCMaster.controller;


import com.ispan.CCCMaster.model.bean.product.Crawler;
import com.ispan.CCCMaster.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CrawlerController {
    @Autowired
    private CrawlerService crawlerService;

    @GetMapping("/front/product/crawler/{id}")//爬蟲程式
    public String crawlerOneProduct(@PathVariable("id") Integer id) {
//        System.out.println("enter crawlerOneProduct");
//        System.out.println(id);
        crawlerService.crawlerPchome(id);
        return "redirect:/admin/products/showAllProduct";
    }

    @ResponseBody
    @GetMapping("/front/product/details/crawler")//爬蟲json資料
    public Page<Crawler> getProductCrawlerPrice(@RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(name = "productId") Integer productId) {
        Page<Crawler> page= crawlerService.findCrawlerProductById(pageNum,productId);
        return page;
    }
}
