package com.ispan.CCCMaster.api;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.BidProductComment;
import com.ispan.CCCMaster.model.bean.bid.DealRecord;
import com.ispan.CCCMaster.model.customexception.ApiErrorException;
import com.ispan.CCCMaster.model.dto.BidProductCommentRequest;
import com.ispan.CCCMaster.model.dto.BidProductQueryParams;
import com.ispan.CCCMaster.model.dto.BidRecordRequest;
import com.ispan.CCCMaster.service.BidProductCommentService;
import com.ispan.CCCMaster.service.BidProductService;
import com.ispan.CCCMaster.service.DealRecordService;
import com.ispan.CCCMaster.util.LoginUtil;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api")
@Validated
public class BidProductApi {

    private final BidProductService bidProductService;

    private final BidProductCommentService bidProductCommentService;

    private final DealRecordService dealRecordService;

    private final LoginUtil loginUtil;

    public BidProductApi(BidProductService bidProductService,
                         BidProductCommentService bidProductCommentService,
                          DealRecordService dealRecordService,
                         LoginUtil loginUtil) {
        this.bidProductService = bidProductService;
        this.bidProductCommentService = bidProductCommentService;
        this.dealRecordService = dealRecordService;
        this.loginUtil = loginUtil;
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
    public BidProduct updateBidPrice(HttpSession session,
                                     @PathVariable Integer id,
                                     @RequestBody @Valid BidRecordRequest bidRecordRequest) {
        Integer loginCustomerId = loginUtil.getLoginCustomerId(session).orElseThrow(() -> new ApiErrorException(401, "請先登入!"));
        if (bidProductService.checkIsOwner(id, loginCustomerId)) throw new ApiErrorException(400, "不可對自己的商品出價!");

        return bidProductService.updateBidPrice(id, bidRecordRequest);
    }

    @PostMapping("/bidProducts/{id}/dealRecords")
    public DealRecord createDealRecord(@PathVariable Integer id) {
        return dealRecordService.createDealRecord(id);
    }

    @PostMapping("/bidProducts/{id}/comments")
    public BidProductComment createComment(HttpSession session,
                                           @PathVariable Integer id,
                                           @RequestBody @Valid BidProductCommentRequest bidProductCommentRequest) {
        loginUtil.getLoginCustomerId(session).orElseThrow(() -> new ApiErrorException(401, "請先登入!"));
        return bidProductCommentService.createComment(id, bidProductCommentRequest);
    }
}
