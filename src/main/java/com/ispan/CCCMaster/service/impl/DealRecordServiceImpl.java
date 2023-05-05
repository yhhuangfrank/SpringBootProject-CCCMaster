package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.BidRecord;
import com.ispan.CCCMaster.model.bean.bid.DealRecord;
import com.ispan.CCCMaster.model.customexception.ApiErrorException;
import com.ispan.CCCMaster.model.dao.BidProductDao;
import com.ispan.CCCMaster.model.dao.BidRecordDao;
import com.ispan.CCCMaster.model.dao.DealRecordDao;
import com.ispan.CCCMaster.service.DealRecordService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DealRecordServiceImpl implements DealRecordService {

    private BidProductDao bidProductDao;

    private BidRecordDao bidRecordDao;

    private DealRecordDao dealRecordDao;

    public DealRecordServiceImpl(BidProductDao bidProductDao,
                                 BidRecordDao bidRecordDao,
                                 DealRecordDao dealRecordDao) {
        this.bidProductDao = bidProductDao;
        this.bidRecordDao = bidRecordDao;
        this.dealRecordDao = dealRecordDao;
    }

    @Override
    public void createDealRecord(Integer bidProductId) {

        BidProduct foundBidProduct = bidProductDao.findById(bidProductId).orElse(null);

        if (foundBidProduct == null) throw new ApiErrorException(404, "查無商品，參數有誤!");

        // 設定查詢特定商品最後下訂的紀錄
        Specification<BidRecord> spec = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("bidProduct"), foundBidProduct);
        Pageable pgb = PageRequest.of(0, 1, Sort.Direction.DESC, "createdAt");

        BidRecord foundBidRecord = bidRecordDao.findAll(spec, pgb).getContent().get(0);

        DealRecord dealRecord = new DealRecord();
        dealRecord.setBidProduct(foundBidProduct);
        dealRecord.setCustomer(foundBidRecord.getCustomer());
        dealRecord.setDealPrice(foundBidRecord.getBidPrice());

        dealRecordDao.save(dealRecord);
    }
}
