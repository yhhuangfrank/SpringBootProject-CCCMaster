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
	
	@Column(name="shipper",columnDefinition = "nvarchar(20)")
	private String scshipper;
	
	@Column(name="shipper_address",columnDefinition = "nvarchar(80)")
	private String scshipperaddress;
	
	@Column(name="payment",columnDefinition = "nvarchar(30)")
	private String scpayment;
	
	@Column(name="addressee",columnDefinition = "nvarchar(20)")
	private String scaddressee;
	
	@Column(name="telephone",columnDefinition = "nvarchar(20)")
	private String sctelephone;
	
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

	public ShoppingCartBean(String shoppoingCartId, Integer quantity, Integer unitprice, Date settime, String scshipper,
			String scshipperaddress, String scpayment, String scaddressee, String sctelephone, Product productBean,
			Customer cbShoppingCart) {
		super();
		this.shoppoingCartId = shoppoingCartId;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.settime = settime;
		this.scshipper = scshipper;
		this.scshipperaddress = scshipperaddress;
		this.scpayment = scpayment;
		this.scaddressee = scaddressee;
		this.sctelephone = sctelephone;
		this.productBean = productBean;
		this.cbShoppingCart = cbShoppingCart;
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

	public String getScshipper() {
		return scshipper;
	}

	public void setScshipper(String scshipper) {
		this.scshipper = scshipper;
	}

	public String getScshipperaddress() {
		return scshipperaddress;
	}

	public void setScshipperaddress(String scshipperaddress) {
		this.scshipperaddress = scshipperaddress;
	}

	public String getScpayment() {
		return scpayment;
	}

	public void setScpayment(String scpayment) {
		this.scpayment = scpayment;
	}

	public String getScaddressee() {
		return scaddressee;
	}

	public void setScaddressee(String scaddressee) {
		this.scaddressee = scaddressee;
	}

	public String getSctelephone() {
		return sctelephone;
	}

	public void setSctelephone(String sctelephone) {
		this.sctelephone = sctelephone;
	}	
	
}
