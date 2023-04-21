package com.ispan.CCCMaster.model.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BidOrder")
public class BidOrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String bidorderid;
	private Integer buyerid;
	private Integer sellerid;
	private Integer bidproductid;
	private Integer price;
	private Integer quantity;
	private Integer freight;
	private Timestamp orderdate;
	private Timestamp arrivaldate;
	private String shipper;
	private String shipperaddress;
	private String payment;
	private String ordercondition;
	private String paymentcondition;
	
	//買家雙向多對一	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="buyer_id")
	private Customers cbBuyer;
	
	//賣家雙向多對一	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="seller_id")
	private Customers cbSeller;
	
	//雙向一對一
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="bidproducts_id")
	private BidProduct bpbidOrder;
	
	public BidOrderBean(String bidorderid, Integer price, Integer quantity, Integer freight, Timestamp orderdate,
			Timestamp arrivaldate, String shipper, String shipperaddress, String payment, String ordercondition,
			String paymentcondition, Customers cbBuyer, Customers cbSeller, BidProduct bpbidOrder) {
		super();
		this.bidorderid = bidorderid;
		this.price = price;
		this.quantity = quantity;
		this.freight = freight;
		this.orderdate = orderdate;
		this.arrivaldate = arrivaldate;
		this.shipper = shipper;
		this.shipperaddress = shipperaddress;
		this.payment = payment;
		this.ordercondition = ordercondition;
		this.paymentcondition = paymentcondition;
		this.cbBuyer = cbBuyer;
		this.cbSeller = cbSeller;
		this.bpbidOrder = bpbidOrder;
	}
	public String getBidorderid() {
		return bidorderid;
	}
	public void setBidorderid(String bidorderid) {
		this.bidorderid = bidorderid;
	}
	public Integer getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
	}
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public Integer getBidproductid() {
		return bidproductid;
	}
	public void setBidproductid(Integer bidproductid) {
		this.bidproductid = bidproductid;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getFreight() {
		return freight;
	}
	public void setFreight(Integer freight) {
		this.freight = freight;
	}
	public Timestamp getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}
	public Timestamp getArrivaldate() {
		return arrivaldate;
	}
	public void setArrivaldate(Timestamp arrivaldate) {
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
