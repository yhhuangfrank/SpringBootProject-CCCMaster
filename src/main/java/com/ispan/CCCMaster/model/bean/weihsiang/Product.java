package com.ispan.CCCMaster.model.bean.weihsiang;

import com.ispan.CCCMaster.model.bean.Category;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @ManyToOne//產品種類Bean
    @JoinColumn(name = "product_category_id")
    private Category category;
    @Column(name = "product_brand")
    private String productBrand;
    @Column(name = "product_name",nullable = false)
    private String productName;
    @Column(name = "price")
    private Integer price;
    @Column(name = "inventory",nullable = false)
    private Integer inventory;
    @Column(name = "num_of_purchases")
    private Integer numOfPurchases;
    @Column(name = "product_views")
    private Integer productViews;
    @Column(name = "desciption")
    private String desciption;
    @Column(name = "number_of_ratings")
    private Integer numberOfRatings;
    @Column(name = "avg_rating")
    private Double avgRating;

    @Column(name = "number_of_comments")
    private Integer numberOfComments;
    @Column(name = "active",nullable = false)
    private Boolean active;
@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_product_id",referencedColumnName = "product_id")
    private List<ProductImg> productImgs;
}


