package com.ispan.CCCMaster.controller;


import com.ispan.CCCMaster.model.bean.Forum.Article;
import com.ispan.CCCMaster.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")//顯示所有文章
    public String FrontArticleList(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model module){
        Page<Article> page = articleService.findByPage(pageNumber);
        module.addAttribute("page", page);
        Article latest = articleService.getLatest();
        module.addAttribute("latest", latest);
        return "front/forum/article";
    }
}
