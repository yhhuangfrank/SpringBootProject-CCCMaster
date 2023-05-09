package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.product.Comment;
import org.springframework.data.domain.Page;

public interface ProductCommentService {
    Page<Comment> findCommentByProductId(Integer productId,Integer pageNumber);
}
