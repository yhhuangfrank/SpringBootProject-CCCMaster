package com.ispan.CCCMaster.controller;


import com.ispan.CCCMaster.model.bean.Forum.Article;
import com.ispan.CCCMaster.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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



    @GetMapping(value = "/article/image/{articleId}") //顯示討論版圖片
    public ResponseEntity<byte[]> getImage(@PathVariable("articleId") Integer articleId) {
        byte[] image = articleService.getArticleImageById(articleId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    @GetMapping("/articleDetail/{id}")//顯示單篇文章
    public String articleDetails(@PathVariable("id")Integer id, Model model){
        articleService.findArticleById(id);
        model.addAttribute("article", articleService.findArticleById(id));
        return "front/forum/articleDetail";
    }
}
