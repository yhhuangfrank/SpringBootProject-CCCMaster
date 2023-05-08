package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.bid.BidProductComment;
import com.ispan.CCCMaster.model.dto.BidProductCommentRequest;

public interface BidProductCommentService {

    BidProductComment createComment(Integer id, BidProductCommentRequest bidProductCommentRequest);

}
