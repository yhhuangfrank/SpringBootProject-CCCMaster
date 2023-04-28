package com.ispan.CCCMaster.model.bean.product;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ProductImg")
public class ProductImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_img_id")
    private Integer productImgId;
    @Column(name = "img")
    private String image;
    @Column(name = "img_purpose")
    private Boolean imgPurpose;

    @Temporal(TemporalType.TIMESTAMP) //對應到SSMS的DATETIME
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")//告訴 Spring 框架如何將輸入的日期和時間字串轉換為 Java 的Date
    @Column(name = "create_date")
    private Date createDate;

   /* @ManyToOne(cascade = CascadeType.ALL)//產品Bean 產品單向一對多
    @JoinColumn(name = "product_id")
    private Product product;*/


}
