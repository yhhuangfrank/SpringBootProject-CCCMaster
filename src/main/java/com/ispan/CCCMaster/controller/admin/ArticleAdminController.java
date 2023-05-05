package com.ispan.CCCMaster.controller.admin;

import com.ispan.CCCMaster.model.bean.Forum.Article;
import com.ispan.CCCMaster.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ArticleAdminController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles/createform")  //新增文章
    public String addArticle(Model model, ModelAndView modelAndView) {
        model.addAttribute("article", new Article());
//        Article latest = articleService.getLatest();
//        model.addAttribute("latest", latest);
        return "back/article/article-create";
    }

    @PostMapping("/articles/create")//送出新增文章
    public String createArticle(@ModelAttribute("article") Article article, Model model) {
        article.getContent();
        System.out.println(article.getContent());
//        articleService.createArticle(article);
        return "redirect:/articles/showAllArticle";
    }

    @GetMapping("/articles/showAllArticle") //顯示所有文章
    public String showAllArticle(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
        Page<Article> page = articleService.findByPage(pageNumber);
        model.addAttribute("page", page);
        Article latest = articleService.getLatest();
        model.addAttribute("latest", latest);
        return "back/article/showArticle";
    }

    @GetMapping("/articles/editPage") //編輯文章
    public String editPage(@RequestParam("id") Integer articleId, Model model) {
        model.addAttribute("article", articleService.findArticleById(articleId));
        return "back/article/editArticle";
    }

    @GetMapping("/articles/delete") //刪除文章
    public String putEditedArticle(@ModelAttribute("article") Article article) throws IOException {
        articleService.updateById(article);
        return "redirect:/articles/showAllArticle";
    }








}
