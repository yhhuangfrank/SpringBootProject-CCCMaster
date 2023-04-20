package com.ispan.CCCMaster.model.bean;

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
    @ManyToOne(cascade = CascadeType.ALL)//產品Bean 產品單向一對多?
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "e_commerce_id")//電商平台Bean 電商單向一對多?
    private ECommerce eCommerce;


    @Temporal(TemporalType.TIMESTAMP) //對應到SSMS的DATETIME
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")//告訴 Spring 框架如何將輸入的日期和時間字串轉換為 Java 的Date
    @Column(name = "crawler_date",nullable = false)
    private Date crawlerDate;
    @Column(name = "price")
    private Integer price;

}
