package com.ispan.CCCMaster.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class BidProductRequest {

    private String name;

    private Integer basePrice;

    private String categoryName;

    private String description;

    private MultipartFile image;

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

    @Override
    public String toString() {
        return "BidProductRequest{" +
                "name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", description='" + description + '\'' +
                ", image=" + image +
                '}';
    }
}
