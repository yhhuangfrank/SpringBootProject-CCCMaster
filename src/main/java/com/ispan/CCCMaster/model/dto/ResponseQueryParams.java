package com.ispan.CCCMaster.model.dto;

public class ResponseQueryParams {

    private Integer articleId;

    public Integer getArticleId() {
        return articleId;
    }

    private Integer page;

    private Integer limit;

    private String articleBy;

    private String sort;

    public String getArticleBy() {
        return articleBy;
    }

    public void setArticleBy(String articleBy) {
        this.articleBy = articleBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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
