package com.ispan.CCCMaster.model.bean.Advertise;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ispan.CCCMaster.model.bean.product.Product;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "advertise")
public class Advertise implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertise_id")
    private Integer advertiseId;

    @Column(name = "click_count")
    private Integer clickCount;

    @Column(name = "title", columnDefinition = "nvarchar(200)", nullable = true)
    private String title;

    @Column(name = "image", columnDefinition = "nvarchar(200)", nullable = true)
    private String image;

    @Column(name = "navigate_url", columnDefinition = "nvarchar(200)", nullable = true)
    private String navigateUrl;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "start_time", columnDefinition = "datetime", nullable = false)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "end_time", columnDefinition = "datetime")
    private Date endTime;

    

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "my_advertise_products",joinColumns ={@JoinColumn(name="advertise_id")},
            inverseJoinColumns = {@JoinColumn(name="product_id")})
    private Set<Product> products;


    public Advertise() {
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Integer getAdvertiseId() {
        return advertiseId;
    }

    public void setAdvertiseId(Integer advertiseId) {
        this.advertiseId = advertiseId;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public String getNavigateUrl() {
        return navigateUrl;
    }

    public void setNavigateUrl(String navigateUrl) {
        this.navigateUrl = navigateUrl;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
