package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.Forum.Article;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public interface ArticleService {
    void creatArticle(Article article);
    Article findArticleById(Integer id);
    void deleteArticleById(Integer id);
    Page<Article> findByPage(Integer pageNumber);
    byte[] getArticleImageById(Integer articleId);

    @Transactional
    void updateById(Article input) throws IOException;
    Article getLatest();
}
