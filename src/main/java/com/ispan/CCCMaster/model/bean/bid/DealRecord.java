package com.ispan.CCCMaster.model.bean.bid;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.ispan.CCCMaster.model.bean.customer.Customer;

@Entity
@Table(name = "DealRecords")
public class DealRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "bidProduct_id",  nullable = false, foreignKey = @ForeignKey(name = "fk_dealRecords_bidProduct"))
    private BidProduct bidProduct;

    @ManyToOne
    @JoinColumn(name = "customer_id",  nullable = false, foreignKey = @ForeignKey(name = "fk_dealRecords_customer"))
    private Customer customer;

    @Column(name = "deal_price", nullable = false)
    private Integer dealPrice;

    @Column(name = "is_paid",nullable = false, columnDefinition = "bit default 0")
    private Boolean isPaid;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at", nullable = false, columnDefinition = "datetime")
    private Date createdAt;

    @PrePersist
    public void onCreate() {
        if (createdAt == null) {
            createdAt = new Date();
        }
        if (isPaid == null) {
            isPaid = false;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(Integer dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
