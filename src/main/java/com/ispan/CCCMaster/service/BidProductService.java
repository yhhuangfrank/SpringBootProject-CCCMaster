package com.ispan.CCCMaster.service;


import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.dto.BidProductRequest;

import java.util.List;

public interface BidProductService {

    BidProduct createBidProduct(BidProductRequest bidProductRequest);

    List<BidProduct> findAllBidProducts();

    BidProduct findBidProductById(Integer id);

    void updateBidProduct(Integer id, BidProductRequest bidProductRequest);
}
