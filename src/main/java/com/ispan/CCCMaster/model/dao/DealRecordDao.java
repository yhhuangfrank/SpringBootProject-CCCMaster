package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.bid.DealRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRecordDao extends JpaRepository<DealRecord, Integer> {
}
