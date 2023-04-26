package com.ispan.CCCMaster.model.bean;

import com.ispan.CCCMaster.model.bean.weihsiang.Product;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ShoppingCartDetail")
public class ShoppingCartDetailBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="quantity", nullable = false)
	private Integer quantity;
	
	//雙向多對一
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="shopping_cart_id")
	private ShoppingCartBean shoppingcartbean;
	
	//雙向多對一
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="product_id")
	private Product productBean;
	
	public ShoppingCartDetailBean(Integer sCDquantity, ShoppingCartBean shoppingcartbean, Product productBean) {
		this.quantity = sCDquantity;
		this.shoppingcartbean = shoppingcartbean;
		this.productBean = productBean;
	}
	public Integer getSCDquantity() {
		return quantity;
	}
	public void setSCDquantity(Integer sCDquantity) {
		this.quantity = sCDquantity;
	}
	public ShoppingCartBean getShoppingcartbean() {
		return shoppingcartbean;
	}
	public Product getProductBean() {
		return productBean;
	}
	public void setShoppingcartbean(ShoppingCartBean shoppingcartbean) {
		this.shoppingcartbean = shoppingcartbean;
	}
	
	
}
