package com.ispan.CCCMaster.controller.admin;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ispan.CCCMaster.model.bean.Forum.Article;
import com.ispan.CCCMaster.service.ArticleService;

@Controller
public class ArticleAdminController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/admin/articles/createform")  //新增文章
    public String addArticle(Model model, ModelAndView modelAndView) {
        model.addAttribute("article", new Article());
        Article latest = articleService.getLatest();
        model.addAttribute("latest", latest);
        return "back/article/article-create";
    }

    @PostMapping("/admin/articles/create")//送出新增文章
    public String createArticle(@ModelAttribute("article") Article article, Model model) throws IOException{
//        article.getContent();//測試
//        System.out.println(article.getContent());
        article.setImage(article.getImageFile().getBytes());
        articleService.createArticle(article);
        return "redirect:/admin/articles/showAllArticle";
    }

    @GetMapping("/admin/articles/showAllArticle") //顯示所有文章
    public String showAllArticle(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
        Page<Article> page = articleService.findByPage(pageNumber);
        model.addAttribute("page", page);
        Article latest = articleService.getLatest();
        model.addAttribute("latest", latest);
        return "back/article/showArticle";
    }

    @GetMapping("/admin/articles/editPage") //編輯文章
    public String editPage(@RequestParam("id") Integer articleId, Model model) {
        Article articleById = articleService.findArticleById(articleId);

        model.addAttribute("article", articleById);
        return "back/article/editArticle";
    }

    @PutMapping("/admin/articles/edit") //送出編輯文章
    public String putEditedArticle(@ModelAttribute("article") Article article) throws IOException {
        article.setImage(article.getImageFile().getBytes());
        articleService.updateById(article);
        return "redirect:/articles/showAllArticle";
    }

    @DeleteMapping("/admin/articles/delete") //刪除文章
    public String putEditedArticle(@RequestParam("id")Integer id) throws IOException {
        articleService.deleteArticleById(id);
        return "redirect:/articles/showAllArticle";
    }









}
