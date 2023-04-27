package com.ispan.CCCMaster.controller.api;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.dto.BidProductQueryParams;
import com.ispan.CCCMaster.service.BidProductService;
import com.ispan.CCCMaster.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping("/api")
public class BidProductApi {

    private final BidProductService bidProductService;

    private final CategoryService categoryService;

    @Autowired
    public BidProductApi(BidProductService bidProductService,
                         CategoryService categoryService) {
        this.bidProductService = bidProductService;
        this.categoryService = categoryService;
    }

    @GetMapping("/bidProducts")
    public Page<BidProduct> getBidProducts(
            @RequestParam(required = false) String categoryName,

            @RequestParam(defaultValue = "createdAt") String orderBy,
            @RequestParam(defaultValue = "DESC") String sort,

            @RequestParam(defaultValue = "1") @Min(1) Integer page,
            @RequestParam(defaultValue = "4") @Min(0) Integer limit
    ) {

        // 設定參數傳遞物件
        BidProductQueryParams queryParams = new BidProductQueryParams();
        queryParams.setCategoryName(categoryName);
        queryParams.setOrderBy(orderBy);
        queryParams.setSort(sort);
        queryParams.setPage(page);
        queryParams.setLimit(limit);

        return bidProductService.findBidProducts(queryParams);
    }

    @PutMapping("/bidProducts/{id}")
    public BidProduct updateBidPrice(@PathVariable Integer id,
                                                     @RequestParam(name = "bidPrice") Integer bidPrice) {
        return bidProductService.updateBidPrice(id, bidPrice);
    }
}
