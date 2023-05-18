package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BidProductDao extends JpaRepository<BidProduct, Integer>, JpaSpecificationExecutor<BidProduct> {

    @Query("FROM BidProduct b WHERE b.customer = :customer AND b.isDeleted = false")
    List<BidProduct> findByCustomer (@Param("customer") Customer customer);

    @Query("FROM BidProduct b WHERE b.isDeleted = false")
    List<BidProduct> findAllNotDeleted();
}
