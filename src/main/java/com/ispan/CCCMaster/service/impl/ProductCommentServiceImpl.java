package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.product.Comment;
import com.ispan.CCCMaster.model.dao.CommentDao;
import com.ispan.CCCMaster.service.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

@Service
public class ProductCommentServiceImpl implements ProductCommentService {
    @Autowired
    private CommentDao commentDao;
    @Override
    public Page<Comment> findCommentByProductId(Integer productId,Integer pageNumber) {
        Sort sort = JpaSort.unsafe(Sort.Direction.ASC, "orderDetail.orderBean.orderid");
        Pageable pgb = PageRequest.of(pageNumber - 1, 5, sort);
       Page<Comment>  page =commentDao.findCommentByProductId(productId,pgb);
        return page;
    }
}
