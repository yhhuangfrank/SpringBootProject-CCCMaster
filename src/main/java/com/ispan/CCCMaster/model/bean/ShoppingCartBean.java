package com.ispan.CCCMaster.model.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ShoppingCart")
public class ShoppingCartBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String shoppoingCartId;
	private Timestamp settime;
	private Integer isCheckout;
	
	//雙向多對一	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="customer_id")
	private CustomerBean cbShoppingCart;
	
	//雙向一對多	
	@OneToMany(mappedBy = "shoppingcartbean",cascade=CascadeType.ALL)
	Set<ShoppingCartDetailBean> scd = new HashSet<>();
	
	public ShoppingCartBean(String shoppoingCartId,Timestamp settime,Integer isCheckout,CustomerBean customerBean) {
		this.shoppoingCartId = shoppoingCartId;
		this.settime = settime;
		this.isCheckout = isCheckout;
		this.customerBean = customerBean;
	}
	
	public ShoppingCartBean() {
	}

	public String getShoppoingCartId() {
		return shoppoingCartId;
	}

	public void setShoppoingCartId(String shoppoingCartId) {
		this.shoppoingCartId = shoppoingCartId;
	}

	public Timestamp getSettime() {
		return settime;
	}

	public void setSettime(Timestamp settime) {
		this.settime = settime;
	}

	public Integer getIsCheckout() {
		return isCheckout;
	}

	public void setIsCheckout(Integer isCheckout) {
		this.isCheckout = isCheckout;
	}

}
