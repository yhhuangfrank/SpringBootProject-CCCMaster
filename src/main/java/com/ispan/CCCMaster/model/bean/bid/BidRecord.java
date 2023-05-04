package com.ispan.CCCMaster.model.bean.bid;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.FetchType;
import java.util.Date;

@Entity
@Table(name = "BidRecords")
public class BidRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(name = "fk_customer_id"))
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bidproduct_id", nullable = false, foreignKey = @ForeignKey(name = "fk_bidproduct_id"))
    private BidProduct bidProduct;

    @Column(name = "bid_price", nullable = false)
    private Integer bidPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at", columnDefinition = "DATETIME", nullable = false)
    private Date createdAt;

    @PrePersist
    public void onCreate() {
        if (createdAt == null) {
            createdAt = new Date();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BidProduct getBidProduct() {
        return bidProduct;
    }

    public void setBidProduct(BidProduct bidProduct) {
        this.bidProduct = bidProduct;
    }

    public Integer getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Integer bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
