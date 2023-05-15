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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
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

    @GetMapping("/articleDetail/{articledId}")//顯示單篇文章
    public String articleDetails(@PathVariable("articledId")Integer articledId, Model model){


        articleService.findArticleById(articledId);
        model.addAttribute("article", articleService.findArticleById(articledId));

        return "front/forum/articleDetail";
    }
    @GetMapping("/front/articles/createform")  //新增文章
    public String addArticle(Model model, ModelAndView modelAndView) {
        model.addAttribute("article", new Article());
        Article latest = articleService.getLatest();
        model.addAttribute("latest", latest);
        return "back/article/article-create";
    }

    @PostMapping("/front/articles/create")//送出新增文章
    public String createArticle(@ModelAttribute("article") Article article, Model model) throws IOException {
//        article.getContent();//測試
//        System.out.println(article.getContent());
        article.setImage(article.getImageFile().getBytes());
        articleService.createArticle(article);
        return "redirect:/admin/articles/showAllArticle";
    }


    @GetMapping("/response/ajax")
    public String ajaxPage() {
        return "front/forum/articleDetail";
    }

}
