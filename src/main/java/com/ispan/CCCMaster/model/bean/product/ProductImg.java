package com.ispan.CCCMaster.model.bean.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ProductImg")
public class ProductImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_img_id")
    private Integer productImgId;
    @Lob
    @Column(name = "image",columnDefinition = "varbinary(max)")
    private byte[] image;

    @Temporal(TemporalType.TIMESTAMP) //對應到SSMS的DATETIME
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")//告訴 Spring 框架如何將輸入的日期和時間字串轉換為 Java 的Date
    @Column(name = "create_date")
    private Date createDate;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @Column(name = "is_main_image")
    private Boolean mainImage;

    public Boolean getMainImage() {
        return mainImage;
    }

    public void setMainImage(Boolean mainImage) {
        this.mainImage = mainImage;
    }

    @PrePersist
    public void onCreate() {
        if (createDate == null) {
            createDate = new Date();
        }
    }

    public Integer getProductImgId() {
        return productImgId;
    }

    public void setProductImgId(Integer productImgId) {
        this.productImgId = productImgId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }



}
