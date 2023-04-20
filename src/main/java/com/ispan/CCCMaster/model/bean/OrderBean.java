package com.ispan.CCCMaster.model.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class OrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String orderid;
	private Integer freight;
	private Integer pointsdiscount;
	private String couponid;
	private String orderdate;
	private String arrivaldate;
	private String shipper;
	private String shipperaddress;
	private String payment;
	private String ordercondition;
	private String paymentcondition;
	
	//雙向多對一
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="customer_id")
	private Customers cbOrder;
	
	public OrderBean(String orderid,Integer freight,Integer pointsdiscount,String couponid,Integer unitprice,Integer quantity,
			String orderdate,String arrivaldate,String shipper,String shipperaddress,
			String payment,String ordercondition,String paymentcondition,Customers cbOrder) {
		this.orderid = orderid;
		this.freight = freight;
		this.pointsdiscount = pointsdiscount;
		this.couponid = couponid;
		this.orderdate = orderdate;
		this.arrivaldate = arrivaldate;
		this.shipper = shipper;
		this.shipperaddress = shipperaddress;
		this.payment = payment;
		this.ordercondition = ordercondition;
		this.paymentcondition = paymentcondition;
		this.cbOrder = cbOrder;
	}
	
	public OrderBean() {
		
	}
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public int getFreight() {
		return freight;
	}
	public void setFreight(int freight) {
		this.freight = freight;
	}
	public int getPointsdiscount() {
		return pointsdiscount;
	}
	public void setPointsdiscount(int pointsdiscount) {
		this.pointsdiscount = pointsdiscount;
	}
	public String getCouponid() {
		return couponid;
	}
	public void setCouponid(String couponid) {
		this.couponid = couponid;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getArrivaldate() {
		return arrivaldate;
	}
	public void setArrivaldate(String arrivaldate) {
		this.arrivaldate = arrivaldate;
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
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getOrdercondition() {
		return ordercondition;
	}
	public void setOrdercondition(String ordercondition) {
		this.ordercondition = ordercondition;
	}
	public String getPaymentcondition() {
		return paymentcondition;
	}
	public void setPaymentcondition(String paymentcondition) {
		this.paymentcondition = paymentcondition;
	}
	
		
}
