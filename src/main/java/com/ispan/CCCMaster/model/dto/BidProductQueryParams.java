package com.ispan.CCCMaster.model.dto;

public class BidProductQueryParams {

    private String categoryName;

    private String keyword;

    private Boolean nonClosed;

    private Boolean started;

    private Boolean dueSoon;

    private String orderBy;

    private String sort;

    private Integer page;

    private Integer limit;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Boolean getNonClosed() {
        return nonClosed;
    }

    public void setNonClosed(Boolean nonClosed) {
        this.nonClosed = nonClosed;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }

    public Boolean getDueSoon() {
        return dueSoon;
    }

    public void setDueSoon(Boolean dueSoon) {
        this.dueSoon = dueSoon;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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
