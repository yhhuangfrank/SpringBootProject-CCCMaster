package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.Forum.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article, Integer> {
    Article findFirstByOrderByAddedDesc();
}
