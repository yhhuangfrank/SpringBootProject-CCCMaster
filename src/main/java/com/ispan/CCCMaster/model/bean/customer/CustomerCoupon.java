package com.ispan.CCCMaster.model.bean.customer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.ispan.CCCMaster.model.bean.coupon.CouponBean;

@Entity
@Table(name = "CustomerCoupons")
public class CustomerCoupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customers;
	
	@ManyToOne
	@JoinColumn(name = "convert_id")
	private CouponBean couponBean;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "build_time", columnDefinition = "datetime")
	private Date buildTime;
	
	@PrePersist	//建立該筆資料時自動產生當天日期，以及把點數、棄標次數設為0
	public void onCreate() {
		if(buildTime == null) buildTime = new Date();
	}
	
	@Column(name = "is_available", columnDefinition = "bit")
	private Boolean isAvailable;
	
	@Column(name = "unavailable_reason", columnDefinition = "char(1)")
	private String unavailableReason;

	public CustomerCoupon() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CouponBean getCouponBean() {
		return couponBean;
	}

	public void setCouponBean(CouponBean couponBean) {
		this.couponBean = couponBean;
	}

	public Date getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getUnavailableReason() {
		return unavailableReason;
	}

	public void setUnavailableReason(String unavailableReason) {
		this.unavailableReason = unavailableReason;
	}

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

}
