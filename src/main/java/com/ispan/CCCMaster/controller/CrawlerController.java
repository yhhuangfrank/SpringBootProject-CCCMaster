package com.ispan.CCCMaster.controller;


import com.ispan.CCCMaster.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CrawlerController {
    @Autowired
    private CrawlerService crawlerService;
    @GetMapping("/admin/crawler/{id}")//爬蟲
    public String crawlerOneProduct(@PathVariable("id")Integer id){
        System.out.println("enter crawlerOneProduct");
        System.out.println(id);
        crawlerService.crawlerPchome(id);
        return "redirect:/admin/products/showAllProduct";
    }
}
