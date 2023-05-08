package com.ispan.CCCMaster.model.bean.bid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "BidProductComments")
public class BidProductComment {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(max)", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "bidProduct_id", foreignKey = @ForeignKey(name = "fk_bidProductComment_bidProduct"))
    private BidProduct bidProduct;

    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_bidProductComment_customer"))
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 使回傳 json 時，按照格式顯示日期
    @Column(name = "created_at", columnDefinition = "datetime", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at", columnDefinition = "datetime", nullable = false)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = new Date();
        }
        if (updatedAt == null) {
            updatedAt = createdAt;
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BidProduct getBidProduct() {
        return bidProduct;
    }

    public void setBidProduct(BidProduct bidProduct) {
        this.bidProduct = bidProduct;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
