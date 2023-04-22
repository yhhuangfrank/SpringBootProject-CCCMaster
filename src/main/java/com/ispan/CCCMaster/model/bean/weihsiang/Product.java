package com.ispan.CCCMaster.model.bean.weihsiang;

import com.ispan.CCCMaster.model.bean.bid.Category;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @ManyToOne//產品種類Bean
    @JoinColumn(name = "product_category_id")
    private Category category;
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

    @Column(name = "number_of_comments")
    private Integer numberOfComments;
    @Column(name = "active",nullable = false)
    private Boolean active;
    @Lob
    @Column(name = "image", columnDefinition = "varbinary(max)")
    private byte[] image;
//@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "fk_product_id",referencedColumnName = "product_id")
    //private List<ProductImg> productImgs;

    @Transient
    private MultipartFile imageFile;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
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

    public Boolean getActive() {
        return active;
    }



    public void setActive(Boolean active) {
        this.active = active;
    }

    /*public List<ProductImg> getProductImgs() {
        return productImgs;
    }

    public void setProductImgs(List<ProductImg> productImgs) {
        this.productImgs = productImgs;
    }*/


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}


