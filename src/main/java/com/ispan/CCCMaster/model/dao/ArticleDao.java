package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.Forum.Article;

public interface ArticleDao extends JpaRepository<Article, Integer> {
    Article findFirstByOrderByAddedDesc();
}
