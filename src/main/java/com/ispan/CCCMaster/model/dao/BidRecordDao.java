package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.bid.BidRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRecordDao extends JpaRepository<BidRecord, Integer> {
}
