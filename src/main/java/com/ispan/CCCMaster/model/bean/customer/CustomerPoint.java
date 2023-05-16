package com.ispan.CCCMaster.model.bean.customer;

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
public class CustomerPoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "points")
	private Integer points;
	
	@Column(name="plus_or_neg")
	private Boolean plusorneg;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="customer_id")
	private Customer cpoints;
	
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="order_id")
	private OrderBean opoint;

	public CustomerPoint() {
		
	}
	
	public CustomerPoint(Integer id, Integer points, Boolean plusorneg, Customer cpoints, OrderBean opoint) {
		super();
		this.id = id;
		this.points = points;
		this.plusorneg = plusorneg;
		this.cpoints = cpoints;
		this.opoint = opoint;
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


	public Customer getCpoints() {
		return cpoints;
	}


	public void setCpoints(Customer cpoints) {
		this.cpoints = cpoints;
	}


	public OrderBean getOpoint() {
		return opoint;
	}


	public void setOpoint(OrderBean opoint) {
		this.opoint = opoint;
	}

	
}
