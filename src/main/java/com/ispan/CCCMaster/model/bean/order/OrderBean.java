package com.ispan.CCCMaster.model.bean.order;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import com.ispan.CCCMaster.model.bean.customer.Customer;

@Entity
@Table(name="Orders")
public class OrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="order_id", nullable = false)
	private String orderid;
	
	@Column(name="freight")
	private Integer freight;
	
	@Column(name="points_discount")
	private Integer pointsdiscount;
	
	@Column(name="coupon_id",columnDefinition = "nchar(36)")
	private String couponid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "order_date", columnDefinition = "datetime", nullable = false)
	private Date orderdate;
	
	@Column(name = "arrival_date", columnDefinition = "date")
	private String arrivaldate;
	
	@Column(name="shipper",columnDefinition = "nvarchar(20)")
	private String shipper;
	
	@Column(name="shipper_address",columnDefinition = "nvarchar(80)")
	private String shipperaddress;
	
	@Column(name="payment",columnDefinition = "nvarchar(30)")
	private String payment;
	
	@Column(name="order_condition",columnDefinition = "nvarchar(20)")
	private String ordercondition;
	
	@Column(name="payment_condition",columnDefinition = "nvarchar(20)")
	private String paymentcondition;
	
	@Column(name="total_amount")
	private Integer totalamount;
	
	@Column(name="addressee",columnDefinition = "nvarchar(20)")
	private String addressee;
	
	@Column(name="telephone",columnDefinition = "nvarchar(20)")
	private String telephone;
	

	//雙向多對一
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="customer_id")
	@JsonIgnoreProperties("setco")
	private Customer cbOrder;
	
	//對訂單明細:一對多  
	@OneToMany(mappedBy="orderBean",cascade=CascadeType.ALL)
	@JsonIgnoreProperties("orderBean")//新增by暐翔 為了解決雙向關係的json循環引用問題
	Set<OrderDetailBean> seto = new HashSet<>();

	
	public OrderBean(String orderid, Integer freight, Integer pointsdiscount, String couponid, Date orderdate,
			String arrivaldate, String shipper, String shipperaddress, String payment, String ordercondition,
			String paymentcondition, Integer totalamount, String addressee, String telephone, Customer cbOrder) {
		super();
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
		this.totalamount = totalamount;
		this.addressee = addressee;
		this.telephone = telephone;
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

	public Integer getFreight() {
		return freight;
	}

	public void setFreight(Integer freight) {
		this.freight = freight;
	}

	public Integer getPointsdiscount() {
		return pointsdiscount;
	}

	public void setPointsdiscount(Integer pointsdiscount) {
		this.pointsdiscount = pointsdiscount;
	}

	public String getCouponid() {
		return couponid;
	}

	public void setCouponid(String couponid) {
		this.couponid = couponid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
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

	public Integer getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Integer totalamount) {
		this.totalamount = totalamount;
	}

	public Customer getCbOrder() {
		return cbOrder;
	}

	public void setCbOrder(Customer cbOrder) {
		this.cbOrder = cbOrder;
	}

	public Set<OrderDetailBean> getSeto() {
		return seto;
	}

	public void setSeto(Set<OrderDetailBean> seto) {
		this.seto = seto;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
		
}
