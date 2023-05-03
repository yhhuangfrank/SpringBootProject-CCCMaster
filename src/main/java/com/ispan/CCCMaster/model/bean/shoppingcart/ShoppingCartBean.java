package com.ispan.CCCMaster.model.bean.shoppingcart;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.ispan.CCCMaster.model.bean.product.Product;

import com.ispan.CCCMaster.model.bean.customer.Customer;

@Entity
@Table(name="ShoppingCart")
public class ShoppingCartBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="shoppoing_cart_id")
	private String shoppoingCartId;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="unit_price")
	private Integer unitprice;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "settime", columnDefinition = "datetime", nullable = false)
	private Date settime;
	
	//雙向多對一
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="product_id")
	private Product productBean;	
	
	//雙向多對一	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="customer_id")
	private Customer cbShoppingCart;
	
	@PrePersist
	public void onCreate() {
		if(settime  == null) {
			settime = new Date();
		}
	}
	
	public ShoppingCartBean() {
		
	}

	public ShoppingCartBean(String shoppoingCartId, Integer quantity, Date settime, Product productBean,
			Customer cbShoppingCart,Integer unitprice) {
		this.shoppoingCartId = shoppoingCartId;
		this.quantity = quantity;
		this.settime = settime;
		this.productBean = productBean;
		this.cbShoppingCart = cbShoppingCart;
		this.unitprice = unitprice;
	}

	public String getShoppoingCartId() {
		return shoppoingCartId;
	}

	public void setShoppoingCartId(String shoppoingCartId) {
		this.shoppoingCartId = shoppoingCartId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getSettime() {
		return settime;
	}

	public void setSettime(Date settime) {
		this.settime = settime;
	}

	public Product getProductBean() {
		return productBean;
	}

	public Customer getCbShoppingCart() {
		return cbShoppingCart;
	}

	public void setProductBean(Product productBean) {
		this.productBean = productBean;
	}

	public void setCbShoppingCart(Customer cbShoppingCart) {
		this.cbShoppingCart = cbShoppingCart;
	}

	public Integer getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}	
	
}
