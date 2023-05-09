package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ispan.CCCMaster.model.bean.bid.BidRecord;

public interface BidRecordDao extends JpaRepository<BidRecord, Integer>, JpaSpecificationExecutor<BidRecord> {
}
