package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.bean.product.Comment;
import com.ispan.CCCMaster.model.dao.CommentDao;
import com.ispan.CCCMaster.model.dao.OrderDao;
import com.ispan.CCCMaster.model.dao.OrderDetailDao;
import com.ispan.CCCMaster.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public boolean checkPaymentCompleted(String orderId) {
        Optional<OrderBean> optional = orderDao.findById(orderId);
        if (optional.isPresent()) {
            OrderBean order=optional.get();
            if (order.getPaymentcondition().equals("已付款")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkCommentExist(Integer orderDetailId) {
        Comment comment = commentDao.findByOdId(orderDetailId);
        if (comment != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean createComment(Integer orderDetailId, String content, Integer rating){
        Comment comment=new Comment();
        Optional<OrderDetailBean> optional=orderDetailDao.findById(orderDetailId);
        if(optional.isPresent()){
            comment.setOrderDetail(optional.get());
            comment.setCustomerComment(content);
            comment.setRating(rating);
            commentDao.save(comment);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateComment(Integer orderDetailId, String content, Integer rating){
        Comment comment=commentDao.findByOdId(orderDetailId);
        if(comment!=null){
            comment.setCustomerComment(content);
            comment.setRating(rating);
            commentDao.save(comment);
            return true;
        }else {
            return false;
        }


    }
}
