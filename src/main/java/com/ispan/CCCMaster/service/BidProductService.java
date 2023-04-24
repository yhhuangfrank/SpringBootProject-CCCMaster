package com.ispan.CCCMaster.service;


import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.dto.BidProductRequest;

import java.util.List;

public interface BidProductService {

    void createBidProduct(BidProductRequest bidProductRequest);

    List<BidProduct> findAllBidProducts();

    BidProduct findBidProductById(Integer id);

    void updateBidProduct(Integer id, BidProductRequest bidProductRequest);

    void deleteBidProduct(Integer id);
}
