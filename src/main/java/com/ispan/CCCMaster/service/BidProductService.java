package com.ispan.CCCMaster.service;


import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.dto.BidProductRequest;

public interface BidProductService {

    BidProduct createBidProduct(BidProductRequest bidProductRequest);
}
