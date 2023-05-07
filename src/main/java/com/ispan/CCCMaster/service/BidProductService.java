package com.ispan.CCCMaster.service;


import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.dto.BidProductQueryParams;
import com.ispan.CCCMaster.model.dto.BidProductRequest;
import com.ispan.CCCMaster.model.dto.BidRecordRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BidProductService {

    void createBidProduct(Integer customerId, BidProductRequest bidProductRequest);

    List<BidProduct> findAllBidProducts();

    BidProduct findBidProductById(Integer id);

    Page<BidProduct> findBidProducts(BidProductQueryParams bidProductQueryParams);

    void updateBidProduct(Integer id, BidProductRequest bidProductRequest);

    void updateBidProduct(BidProduct bidProduct);

    BidProduct updateBidPrice(Integer id, BidRecordRequest bidRecordRequest);

    void deleteBidProduct(Integer id);
}
