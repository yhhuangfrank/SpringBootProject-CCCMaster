package com.ispan.CCCMaster.model.bean.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;


    @OneToOne
    @JoinColumn(name = "order_details_id")
    private OrderDetailBean orderDetail;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }






    public Integer getRatingsId() {
        return commentId;
    }

    public void setRatingsId(Integer ratingsId) {
        this.commentId = ratingsId;
    }

    @Column(name = "rating", nullable = false)
    private Integer rating;
    @Column(name = "customer_comment")
    private String customerComment;

    @PrePersist
    public void onCreate() {
        if (commentDate == null) {
            commentDate= new Date();
        }
    }

    public OrderDetailBean getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetailBean orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getCustomerComment() {
        return customerComment;
    }

    public void setCustomerComment(String customerComment) {
        this.customerComment = customerComment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    @Temporal(TemporalType.TIMESTAMP) //對應到SSMS的DATETIME
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")//告訴 Spring 框架如何將輸入的日期和時間字串轉換為 Java 的Date
    @Column(name = "comment_date")
    private Date commentDate;


}
