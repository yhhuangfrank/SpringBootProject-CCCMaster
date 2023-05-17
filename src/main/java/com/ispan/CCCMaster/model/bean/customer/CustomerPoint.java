package com.ispan.CCCMaster.model.bean.customer;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ispan.CCCMaster.model.bean.order.OrderBean;

@Entity
@Table(name="CustomerPoints")
public class CustomerPoint implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "points")
	private Integer points;
	
	@Column(name="plus_or_neg")
	private Boolean plusorneg;
	
	@Column(name="customer_id")
	private Integer customerId;
	
	@Column(name="order_id")
	private String orderid;

	public CustomerPoint() {
		
	}


	public CustomerPoint(Integer id, Integer points, Boolean plusorneg, Integer customerId, String orderid) {
		super();
		this.id = id;
		this.points = points;
		this.plusorneg = plusorneg;
		this.customerId = customerId;
		this.orderid = orderid;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getPoints() {
		return points;
	}


	public void setPoints(Integer points) {
		this.points = points;
	}


	public Boolean getPlusorneg() {
		return plusorneg;
	}


	public void setPlusorneg(Boolean plusorneg) {
		this.plusorneg = plusorneg;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getOrderid() {
		return orderid;
	}


	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	

	
}
