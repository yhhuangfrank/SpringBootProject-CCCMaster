package com.ispan.CCCMaster.api;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.DealRecord;
import com.ispan.CCCMaster.model.dto.BidProductQueryParams;
import com.ispan.CCCMaster.model.dto.BidRecordRequest;
import com.ispan.CCCMaster.service.BidProductService;
import com.ispan.CCCMaster.service.DealRecordService;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api")
@Validated
public class BidProductApi {

    private final BidProductService bidProductService;

    private final DealRecordService dealRecordService;

    public BidProductApi(BidProductService bidProductService,
                          DealRecordService dealRecordService) {
        this.bidProductService = bidProductService;
        this.dealRecordService = dealRecordService;
    }

    @GetMapping("/bidProducts")
    public Page<BidProduct> getBidProducts(
            // 搜尋
            @RequestParam(required = false) String categoryName,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false, defaultValue = "false") Boolean nonClosed,
            @RequestParam(required = false, defaultValue = "false") Boolean started,
            @RequestParam(required = false, defaultValue = "false") Boolean dueSoon,

            // 排序
            @RequestParam(defaultValue = "createdAt") String orderBy,
            @RequestParam(defaultValue = "DESC") String sort,

            // 分頁
            @RequestParam(defaultValue = "1") @Min(1) Integer page,
            @RequestParam(defaultValue = "3") @Min(0) Integer limit
    ) {

        // 設定參數傳遞物件
        BidProductQueryParams queryParams = new BidProductQueryParams();
        queryParams.setCategoryName(categoryName);
        queryParams.setKeyword(keyword);
        queryParams.setNonClosed(nonClosed);
        queryParams.setStarted(started);
        queryParams.setDueSoon(dueSoon);
        queryParams.setOrderBy(orderBy);
        queryParams.setSort(sort);
        queryParams.setPage(page);
        queryParams.setLimit(limit);

        return bidProductService.findBidProducts(queryParams);
    }

    @PutMapping("/bidProducts/{id}")
    public BidProduct updateBidPrice(@PathVariable Integer id,
                                     @RequestBody @Valid BidRecordRequest bidRecordRequest) {
        return bidProductService.updateBidPrice(id, bidRecordRequest);
    }

    @PostMapping("/bidProducts/{id}/dealRecords")
    public DealRecord createDealRecord(@PathVariable Integer id) {
        return dealRecordService.createDealRecord(id);
    }

}
