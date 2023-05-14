package com.ispan.CCCMaster.service;

public interface CommentService {
    boolean checkPaymentCompleted(String orderDetailId);

    boolean checkCommentExist(Integer orderDetailId);

    boolean createComment(Integer orderDetailId, String content, Integer rating);

    boolean updateComment(Integer orderDetailId, String content, Integer rating);
}
