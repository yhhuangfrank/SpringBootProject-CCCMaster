package com.ispan.CCCMaster.model.bean.product;

import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Ratings")
public class Ratings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratings_id")
    private Integer ratingsId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "order_details_id")
    private OrderDetailBean orderDetail;


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
