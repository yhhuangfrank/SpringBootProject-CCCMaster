package com.ispan.CCCMaster.model.bean.shoppingcart;

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

import com.ispan.CCCMaster.model.bean.product.Product;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;

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
	
	@Column(name="shipper",columnDefinition = "nvarchar(20)")
	private String shipper;
	
	@Column(name="shipper_address",columnDefinition = "nvarchar(80)")
	private String shipperaddress;
	
	@Column(name="payment",columnDefinition = "nvarchar(30)")
	private String scpayment;
	
	@Column(name="addressee",columnDefinition = "nvarchar(20)")
	private String addressee;
	
	@Column(name="telephone",columnDefinition = "nvarchar(20)")
	private String telephone;
	
	
	//雙向多對一	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="customer_id")
	private Customer cbShoppingCart;
	
	//雙向一對多
	@OneToMany(mappedBy="shoppingCartBean",cascade = CascadeType.ALL)
	Set<ShoppingCartDetailBean> setscd = new HashSet<>();
	
	@PrePersist
	public void onCreate() {
		if(settime  == null) {
			settime = new Date();
		}
	}
	
	public ShoppingCartBean(String shoppoingCartId, Date settime, String shipper, String shipperaddress,
			String scpayment, String addressee, String telephone, Customer cbShoppingCart) {
		super();
		this.shoppoingCartId = shoppoingCartId;
		this.settime = settime;
		this.shipper = shipper;
		this.shipperaddress = shipperaddress;
		this.scpayment = scpayment;
		this.addressee = addressee;
		this.telephone = telephone;
		this.cbShoppingCart = cbShoppingCart;
	}

	public ShoppingCartBean() {
		
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


	public Customer getCbShoppingCart() {
		return cbShoppingCart;
	}


	public void setCbShoppingCart(Customer cbShoppingCart) {
		this.cbShoppingCart = cbShoppingCart;
	}


	public String getShipper() {
		return shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public String getShipperaddress() {
		return shipperaddress;
	}

	public void setShipperaddress(String shipperaddress) {
		this.shipperaddress = shipperaddress;
	}

	public String getScpayment() {
		return scpayment;
	}

	public void setScpayment(String scpayment) {
		this.scpayment = scpayment;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<ShoppingCartDetailBean> getSetscd() {
		return setscd;
	}

	public void setSetscd(Set<ShoppingCartDetailBean> setscd) {
		this.setscd = setscd;
	}


	
}
