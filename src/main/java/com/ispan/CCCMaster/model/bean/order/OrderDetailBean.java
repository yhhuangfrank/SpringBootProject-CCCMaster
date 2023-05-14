package com.ispan.CCCMaster.model.bean.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ispan.CCCMaster.model.bean.product.Comment;
import com.ispan.CCCMaster.model.bean.product.Product;

import java.io.Serializable;

import javax.persistence.*;

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
	@JsonIgnoreProperties("seto")//新增by暐翔 為了解決雙向關係的json循環引用問題
	private OrderBean orderBean;
	
	//雙向多對一
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="product_id")
	private Product pOrderDetail;

	@OneToOne(mappedBy = "orderDetail")//新增 by 暐翔
	@JsonIgnoreProperties("orderDetail")
	private Comment comment;

	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderBean getOrderBean() {
		return orderBean;
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

	@Override
	public String toString() {
		return "OrderDetailBean [id=" + id + ", unitprice=" + unitprice + ", quantity=" + quantity + ", orderBean="
				+ orderBean + ", pOrderDetail=" + pOrderDetail + "]";
	}

	
}
