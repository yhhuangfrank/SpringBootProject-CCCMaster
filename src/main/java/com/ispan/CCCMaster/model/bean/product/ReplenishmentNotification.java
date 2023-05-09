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
@Table(name = "ReplenishmentNotification")
public class ReplenishmentNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Integer notificationId;
    //    @OneToMany//會員Bean 會員單向一對多?
//    @JoinColumn(name = "customer_id")
//    private Costomer costomer;
    @ManyToOne (cascade = CascadeType.ALL)//產品Bean 產品單向一對多?
    @JoinColumn(name = "product_id")
    private Product product;

    @Temporal(TemporalType.TIMESTAMP) //對應到SSMS的DATETIME
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")//告訴 Spring 框架如何將輸入的日期和時間字串轉換為 Java 的Date
    @Column(name = "create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP) //對應到SSMS的DATETIME
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")//告訴 Spring 框架如何將輸入的日期和時間字串轉換為 Java 的Date
    @Column(name = "notification_date")
    private Date notificationDate;

    @Column(name = "notification_status")
    private Boolean notificationStatus;



}
