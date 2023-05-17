package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.Forum.Article;
import com.ispan.CCCMaster.model.bean.Forum.Response;
import com.ispan.CCCMaster.model.bean.product.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResponseDao extends JpaRepository<Response, Integer> {
    Response findFirstByOrderByAddedDesc();

//    @Query("select c from Comment c where c.orderDetail.id=:orderDetailId")
//Comment findByOdId(@Param("orderDetailId")Integer orderDetailId);

    @Query("select r from Response r WHERE r.article.articleId = :articleId")
    Page<Response> findAllByArticleId(@Param("articleId") Integer articleId, Pageable pageable);
}
