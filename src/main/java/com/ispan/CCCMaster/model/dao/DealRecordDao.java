package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.DealRecord;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DealRecordDao extends JpaRepository<DealRecord, Integer> {
    @Query("FROM DealRecord WHERE bidProduct = :bidProduct AND customer = :customer")
    DealRecord findByBidProductAndCustomer(@Param("bidProduct") BidProduct bidProduct,
                                           @Param("customer") Customer customer);
}
