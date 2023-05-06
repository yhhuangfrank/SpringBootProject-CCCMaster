package com.ispan.CCCMaster.model.bean.bid;

import com.ispan.CCCMaster.model.bean.category.Category;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import org.springframework.format.annotation.DateTimeFormat;

import com.ispan.CCCMaster.model.bean.order.BidOrderBean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BidProducts")
public class BidProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", columnDefinition = "nvarchar(50)", nullable = false)
    private String name;

    @Column(name = "base_price", nullable = false)
    private Integer basePrice;

    @Column(name = "bid_price", nullable = false)
    private Integer bidPrice;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "BidProduct_Category"))
    private Category category;

    @Column(name = "description", columnDefinition = "nvarchar(max)")
    private String description;

    @Column(name = "image", columnDefinition = "varchar(max)", nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(name = "BidProductBelongsToCustomer"))
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP) // 指定 DB 中時間精度
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 使用此格式在 Java 中解析日期
    @Column(name = "created_at", columnDefinition = "datetime", nullable = false)
    Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "expired_at", columnDefinition = "datetime")
    Date expiredAt;

    @Column(name = "view_count", columnDefinition = "int default 0", nullable = false)
    Integer viewCount;

    @PrePersist
    public void onCreate() {
        if (createdAt == null) {
            createdAt = new Date();
        }
        if (viewCount == null) {
            viewCount = 0;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public Integer getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Integer bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "BidProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", bidPrice=" + bidPrice +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", createdAt=" + createdAt +
                ", expiredAt=" + expiredAt +
                ", viewCount=" + viewCount +
                '}';
    }

    //對二手商品訂單:一對一  BY瑛仁
    @OneToOne(mappedBy = "bpbidOrder", fetch = FetchType.LAZY)
    BidOrderBean bidOrder;
}

