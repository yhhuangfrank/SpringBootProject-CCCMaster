package com.ispan.CCCMaster.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BidRecordRequest {
    @NotNull(message = "customerId is required")
    @Min(1)
    private Integer customerId;

    @NotNull(message = "bidPrice is required")
    @Min(1)
    private Integer bidPrice;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Integer bidPrice) {
        this.bidPrice = bidPrice;
    }
}
