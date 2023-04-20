package com.ispan.CCCMaster.model.bean;

import javax.persistence.*;

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
