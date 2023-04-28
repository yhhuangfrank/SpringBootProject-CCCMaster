package com.ispan.CCCMaster.model.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BidProductRequest {

    @NotBlank(message = "名稱不可為空!")
    private String name;

    @NotNull(message = "底價不可為空!")
    @Min(value = 0, message = "底價不可小於0!")
    private Integer basePrice;

    @NotBlank(message = "種類不可為空!")
    private String categoryName;

    private String description;

    private MultipartFile image;

    private String endDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "BidProductRequest{" +
                "name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
