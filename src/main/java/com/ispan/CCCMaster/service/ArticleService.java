package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.Forum.Article;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

public interface ArticleService {
    void createArticle(Article article);

    Article findArticleById(Integer id);

//    List<Article> findArticleById(Integer articleId);

    void deleteArticleById(Integer id);

    Page<Article> findByPage(Integer pageNumber);

    byte[] getArticleImageById(Integer articleId);


    @Transactional
    void updateById(Article input) throws IOException;
    Article getLatest();



}
