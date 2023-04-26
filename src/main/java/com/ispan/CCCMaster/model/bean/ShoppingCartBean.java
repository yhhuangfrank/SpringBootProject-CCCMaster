package com.ispan.CCCMaster.model.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ShoppingCart")
public class ShoppingCartBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="shoppoing_cart_id")
	private String shoppoingCartId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "settime", columnDefinition = "datetime", nullable = false)
	private Date settime;
	
	@Column(name="is_Checkout")
	private Integer isCheckout;
	
	//雙向多對一	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="customer_id")
	private Customers cbShoppingCart;
	
	//雙向一對多	
	@OneToMany(mappedBy = "shoppingcartbean",cascade=CascadeType.ALL)
	Set<ShoppingCartDetailBean> scd = new HashSet<>();
	
	@PrePersist
	public void onCreate() {
		if(settime  == null) {
			settime = new Date();
		}
	}
	
	public ShoppingCartBean() {
		
	}
	
	public ShoppingCartBean(String shoppoingCartId, Date settime, Integer isCheckout, Set<ShoppingCartDetailBean> scd) {
		this.shoppoingCartId = shoppoingCartId;
		this.settime = settime;
		this.isCheckout = isCheckout;
		this.scd = scd;
	}

	public String getShoppoingCartId() {
		return shoppoingCartId;
	}

	public void setShoppoingCartId(String shoppoingCartId) {
		this.shoppoingCartId = shoppoingCartId;
	}

	public Date getSettime() {
		return settime;
	}

	public void setSettime(Date settime) {
		this.settime = settime;
	}

	public Integer getIsCheckout() {
		return isCheckout;
	}

	public void setIsCheckout(Integer isCheckout) {
		this.isCheckout = isCheckout;
	}

	public Customers getCbShoppingCart() {
		return cbShoppingCart;
	}
	
	

}
