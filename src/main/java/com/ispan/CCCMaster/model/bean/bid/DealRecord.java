package com.ispan.CCCMaster.model.bean.bid;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DealRecords")
public class DealRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "bidProduct_id",  nullable = false, foreignKey = @ForeignKey(name = "fk_dealedRecords_bidProduct"))
    private BidProduct bidProduct;

    @ManyToOne
    @JoinColumn(name = "customer_id",  nullable = false, foreignKey = @ForeignKey(name = "fk_dealedRecords_customer"))
    private Customer customer;

    @Column(name = "deal_price", nullable = false)
    private Integer dealPrice;

    @Column(name = "is_not_paid",nullable = false, columnDefinition = "bit default 0")
    private Boolean isNotPaid;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at", nullable = false, columnDefinition = "datetime")
    private Date createdAt;

    @PrePersist
    public void onCreate() {
        if (createdAt == null) {
            createdAt = new Date();
        }
        if (isNotPaid == null) {
            isNotPaid = false;
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

    public Boolean getNotPaid() {
        return isNotPaid;
    }

    public void setNotPaid(Boolean notPaid) {
        isNotPaid = notPaid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
