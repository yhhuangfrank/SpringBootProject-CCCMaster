package com.ispan.CCCMaster.model.bean;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BidOrder")
public class BidOrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "bid_order_id")
	private String bidorderid;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "freight")
	private Integer freight;
	
	@Column(name = "order_date", columnDefinition = "datetime", nullable = false)
	private String orderdate;
	
	@Column(name = "arrival_date", columnDefinition = "datetime", nullable = false)
	private String arrivaldate;
	
	@Column(name = "shipper", columnDefinition = "nvarchar(20)")
	private String shipper;
	
	@Column(name = "shipper_address", columnDefinition = "nvarchar(60)")
	private String shipperaddress;
	
	@Column(name = "payment", columnDefinition = "nvarchar(30)")
	private String payment;
	
	@Column(name = "order_condition", columnDefinition = "nvarchar(20)")
	private String ordercondition;
	
	@Column(name = "payment_condition", columnDefinition = "nvarchar(20)")
	private String paymentcondition;
	
	//買家雙向多對一	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="buyer_id")
	private Customer cbBuyer;
	
	//賣家雙向多對一	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="seller_id")
	private Customer cbSeller;
	
	//雙向一對一
	@OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="bidproducts_id")
	private BidProduct bpbidOrder;

	
	public BidOrderBean(String bidorderid, Integer price, Integer quantity, Integer freight, String orderdate,
			String arrivaldate, String shipper, String shipperaddress, String payment, String ordercondition,
			String paymentcondition) {
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
	}

	public String getBidorderid() {
		return bidorderid;
	}

	public void setBidorderid(String bidorderid) {
		this.bidorderid = bidorderid;
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
