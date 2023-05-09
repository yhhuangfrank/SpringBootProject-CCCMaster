package com.ispan.CCCMaster.model.bean.product;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Ratings")
public class Ratings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratings_id")
    private Integer ratingsId;
    //    @ManyToOne//訂單Bean  訂單單向一對多?
//    @JoinColumn(name = "order_id")
//    private Order Order;
    @ManyToOne(cascade = CascadeType.ALL)//訂單Bean
    @JoinColumn(name = "product_id")
    private Product product;

    //    @ManyToOne(cascade = CascadeType.ALL)//會員Bean  會員單向一對多?
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
    @Column(name = "rating", nullable = false)
    private Integer rating;
    @Column(name = "customer_comment")
    private String customerComment;
    @Column(name = "customer_comment_img")
    private String customerCommentImg;
    @Temporal(TemporalType.TIMESTAMP) //對應到SSMS的DATETIME
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")//告訴 Spring 框架如何將輸入的日期和時間字串轉換為 Java 的Date
    @Column(name = "comment_date")
    private Date commentDate;


}
