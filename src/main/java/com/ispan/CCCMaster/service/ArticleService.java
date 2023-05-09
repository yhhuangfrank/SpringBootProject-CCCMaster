package com.ispan.CCCMaster.service;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.Forum.Article;

public interface ArticleService {
    void createArticle(Article article);

    Article findArticleById(Integer id);

    void deleteArticleById(Integer id);

    Page<Article> findByPage(Integer pageNumber);

    byte[] getArticleImageById(Integer articleId);


    @Transactional
    void updateById(Article input) throws IOException;
    Article getLatest();



}
