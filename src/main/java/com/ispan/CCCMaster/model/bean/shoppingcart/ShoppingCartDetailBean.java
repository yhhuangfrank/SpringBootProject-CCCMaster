package com.ispan.CCCMaster.model.bean.shoppingcart;

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

import com.ispan.CCCMaster.model.bean.product.Product;

@Entity
@Table(name="ShoppingCartDetail")
public class ShoppingCartDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="quantity")
	private Integer scquantity;
	
	@Column(name="unit_price")
	private Integer unitprice;
	
	//雙向多對一
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="product_id")
	private Product productBean;
	
	//雙向多對一
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="shopping_cart_id")
	private ShoppingCartBean shoppingCartBean;

	
	public ShoppingCartDetailBean(Integer id, Integer scquantity, Integer unitprice, Product productBean,
			ShoppingCartBean shoppingCartBean) {
		super();
		this.id = id;
		this.scquantity = scquantity;
		this.unitprice = unitprice;
		this.productBean = productBean;
		this.shoppingCartBean = shoppingCartBean;
	}

	public ShoppingCartDetailBean() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getScquantity() {
		return scquantity;
	}

	public void setScquantity(Integer scquantity) {
		this.scquantity = scquantity;
	}

	public Integer getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}

	public Product getProductBean() {
		return productBean;
	}

	public void setProductBean(Product productBean) {
		this.productBean = productBean;
	}

	public ShoppingCartBean getShoppingCartBean() {
		return shoppingCartBean;
	}

	public void setShoppingCartBean(ShoppingCartBean shoppingCartBean) {
		this.shoppingCartBean = shoppingCartBean;
	}
	
	
}
