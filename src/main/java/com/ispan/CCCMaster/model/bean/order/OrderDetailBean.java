package com.ispan.CCCMaster.model.bean.order;

import com.ispan.CCCMaster.model.bean.product.Product;

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
@Table(name="OrderDetail")
public class OrderDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="unitprice")
	private Integer unitprice;
	
	@Column(name="quantity")
	private Integer quantity;
	
	//雙向多對一
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="order_id")
	private OrderBean orderBean;
	
	//雙向多對一
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="product_id")
	private Product pOrderDetail;
	
	public OrderDetailBean() {		
	}
	
	public OrderDetailBean(Integer unitprice, Integer quantity, OrderBean orderBean, Product pOrderDetail) {
		this.unitprice = unitprice;
		this.quantity = quantity;
		this.orderBean = orderBean;
		this.pOrderDetail = pOrderDetail;
	}
	public Integer getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getpOrderDetail() {
		return pOrderDetail;
	}
	public void setpOrderDetail(Product pOrderDetail) {
		this.pOrderDetail = pOrderDetail;
	}

	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}


}
