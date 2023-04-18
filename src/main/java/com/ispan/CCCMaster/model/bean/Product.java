package com.ispan.CCCMaster.model.bean;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class ProductBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //    @ManyToOne//產品種類Bean
//    @JoinColumn(name = "product_category_id")
//    private ProductCategory productCategory;
    @Column(name = "product_brand")
    private String productBrand;
    @Column(name = "product_name",nullable = false)
    private String productName;
    @Column(name = "price")
    private Integer price;
    @Column(name = "inventory",nullable = false)
    private Integer inventory;
    @Column(name = "num_of_purchases")
    private Integer numOfPurchases;
    @Column(name = "product_views")
    private Integer productViews;
    @Column(name = "desciption")
    private String desciption;
    @Column(name = "number_of_ratings")
    private Integer numberOfRatings;
    @Column(name = "avg_rating")
    private Double avgRating;

    public String getProductBrand() {
        return productBrand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getNumOfPurchases() {
        return numOfPurchases;
    }

    public void setNumOfPurchases(Integer numOfPurchases) {
        this.numOfPurchases = numOfPurchases;
    }

    public Integer getProductViews() {
        return productViews;
    }

    public void setProductViews(Integer productViews) {
        this.productViews = productViews;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Integer getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(Integer numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public Integer getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(Integer numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Column(name = "number_of_comments")
    private Integer numberOfComments;
    @Column(name = "active",nullable = false)
    private boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
}
