package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.product.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentDao extends JpaRepository<Comment, Integer> {
    @Query("select c from Comment c where c.orderDetail.pOrderDetail.productId=:productId")
    Page<Comment> findCommentByProductId(@Param("productId") Integer productId, Pageable pgb);
}
