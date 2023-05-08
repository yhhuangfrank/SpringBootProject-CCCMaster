package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.bid.BidProductComment;
import com.ispan.CCCMaster.model.dto.BidProductCommentQueryParams;
import com.ispan.CCCMaster.model.dto.BidProductCommentRequest;
import org.springframework.data.domain.Page;

public interface BidProductCommentService {

    BidProductComment createComment(Integer id, BidProductCommentRequest bidProductCommentRequest);

    Page<BidProductComment> getAllComments(BidProductCommentQueryParams params);

}
