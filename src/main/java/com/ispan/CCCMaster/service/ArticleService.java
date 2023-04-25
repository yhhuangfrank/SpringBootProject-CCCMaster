package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.Article;
import org.springframework.data.domain.Page;

import java.io.IOException;

public interface ArticleService {

    void createArticle(Article article);

    Page<Article> findByPage(Integer pageNumber);

    byte[] getArticleImageById(Integer articleId);

    void deleteArticle(Integer articleId);
    Article findArticleById(Integer articleId);

    void editArticleById(Article article) throws IOException;

}
