package com.ispan.CCCMaster.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BidProductCommentRequest {

    @NotBlank(message = "comment is required!")
    private String comment;

    @NotNull(message = "customerId is required!")
    @Min(value = 1,  message = "customerId 需大於 0")
    private Integer customerId;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
