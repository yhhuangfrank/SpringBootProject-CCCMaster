package com.ispan.CCCMaster.api;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.dto.BidProductQueryParams;
import com.ispan.CCCMaster.model.dto.BidRecordRequest;
import com.ispan.CCCMaster.service.BidProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api")
@Validated
public class BidProductApi {

    private final BidProductService bidProductService;

    @Autowired
    public BidProductApi(BidProductService bidProductService) {
        this.bidProductService = bidProductService;
    }

    @GetMapping("/bidProducts")
    public Page<BidProduct> getBidProducts(
            // 搜尋
            @RequestParam(required = false) String categoryName,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false, defaultValue = "false") Boolean nonClosed,
            @RequestParam(required = false, defaultValue = "false") Boolean started,

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
        queryParams.setOrderBy(orderBy);
        queryParams.setSort(sort);
        queryParams.setPage(page);
        queryParams.setLimit(limit);

        return bidProductService.findBidProducts(queryParams);
    }

    @PutMapping("/bidProducts/{id}")
    public BidProduct updateBidPrice(@PathVariable Integer id,
                                     @ModelAttribute("bidRecordRequest")BidRecordRequest bidRecordRequest) {
        return bidProductService.updateBidPrice(id, bidRecordRequest);
    }
}
