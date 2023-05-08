package com.ispan.CCCMaster.model.dto;

public class BidProductCommentQueryParams {

    private Integer bidProductId;

    private Integer page;

    private Integer limit;

    public Integer getBidProductId() {
        return bidProductId;
    }

    public void setBidProductId(Integer bidProductId) {
        this.bidProductId = bidProductId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
