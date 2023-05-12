package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.DealRecord;
import com.ispan.CCCMaster.model.bean.customer.Customer;

public interface DealRecordService {

    DealRecord createDealRecord (Integer bidProductId);

    DealRecord findByBidProduct(BidProduct bidProduct);
    
}
