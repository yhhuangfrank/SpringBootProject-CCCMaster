package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.BidProductComment;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.customexception.ApiErrorException;
import com.ispan.CCCMaster.model.dao.BidProductCommentDao;
import com.ispan.CCCMaster.model.dao.BidProductDao;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.model.dto.BidProductCommentRequest;
import com.ispan.CCCMaster.service.BidProductCommentService;
import org.springframework.stereotype.Service;

@Service
public class BidProductCommentServiceServiceImpl implements BidProductCommentService {

    private final BidProductCommentDao bidProductCommentDao;

    private final BidProductDao bidProductDao;

    private final CustomerDao customerDao;

    public BidProductCommentServiceServiceImpl(BidProductCommentDao bidProductCommentDao,
                                               BidProductDao bidProductDao,
                                               CustomerDao customerDao) {
        this.bidProductCommentDao = bidProductCommentDao;
        this.bidProductDao = bidProductDao;
        this.customerDao = customerDao;
    }

    @Override
    public BidProductComment createComment(Integer id, BidProductCommentRequest bidProductCommentRequest) {

        BidProduct foundBidProduct = bidProductDao.findById(id).orElseThrow(() -> new ApiErrorException(404, "查無商品，參數有誤!"));
        Customer foundCustomer = customerDao.findById(bidProductCommentRequest.getCustomerId()).orElseThrow(() ->
                new ApiErrorException(404, "查無使用者，參數有誤!"));

        BidProductComment bidProductComment = new BidProductComment();
        bidProductComment.setContent(bidProductCommentRequest.getComment());
        bidProductComment.setCustomer(foundCustomer);
        bidProductComment.setBidProduct(foundBidProduct);

        return bidProductCommentDao.save(bidProductComment);
    }
}
