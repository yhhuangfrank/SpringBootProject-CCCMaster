package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidProductDao extends JpaRepository<BidProduct, Integer> {

//    BidProduct createBidProduct();
}
