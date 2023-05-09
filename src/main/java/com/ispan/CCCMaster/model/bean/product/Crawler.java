package com.ispan.CCCMaster.model.bean.product;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Crawler")
public class Crawler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crawler_id")
    private Integer crawlerId;
    @ManyToOne//產品Bean 產品雙向一對多?
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "e_commerce_id")//電商平台Bean 電商單向一對多?
    private ECommerce eCommerce;

    public String getCrawlerProductName() {
        return crawlerProductName;
    }

    public void setCrawlerProductName(String crawlerProductName) {
        this.crawlerProductName = crawlerProductName;
    }

    @Column(name = "crawler_product_name")
    private String crawlerProductName;


    public Integer getCrawlerId() {
        return crawlerId;
    }

    public void setCrawlerId(Integer crawlerId) {
        this.crawlerId = crawlerId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ECommerce geteCommerce() {
        return eCommerce;
    }

    public void seteCommerce(ECommerce eCommerce) {
        this.eCommerce = eCommerce;
    }

    public Date getCrawlerDate() {
        return crawlerDate;
    }

    public void setCrawlerDate(Date crawlerDate) {
        this.crawlerDate = crawlerDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Temporal(TemporalType.TIMESTAMP) //對應到SSMS的DATETIME
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")//告訴 Spring 框架如何將輸入的日期和時間字串轉換為 Java 的Date
    @Column(name = "crawler_date",nullable = false)
    private Date crawlerDate;
    @Column(name = "price")
    private Integer price;

    @PrePersist
    public void onCreate() {
        if (crawlerDate == null) {
            crawlerDate = new Date();
        }

    }

}
