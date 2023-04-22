package com.ispan.CCCMaster.model.dto;

import java.util.Map;
import java.util.Optional;

public class ImgurResponse {

    Map<String, Optional<Object>> data;

    Boolean success;

    Integer status;

    public Map<String, Optional<Object>> getData() {
        return data;
    }

    public void setData(Map<String, Optional<Object>> data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ImgurResponse{" +
                "data=" + data +
                ", success=" + success +
                ", status=" + status +
                '}';
    }

}
