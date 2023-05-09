package com.ispan.CCCMaster.model.bean.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ECommerce")
public class ECommerce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "e_commerce_id")
    private Integer eCommerceId;
    @Column(name = "e_commerce_name")
    private String eCommerceName;
}
