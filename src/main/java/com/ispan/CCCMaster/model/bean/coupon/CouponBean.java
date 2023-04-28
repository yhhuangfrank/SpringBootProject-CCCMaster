package com.ispan.CCCMaster.model.bean.coupon;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Coupon")
public class CouponBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="coupon_id", columnDefinition = "nchar(36)")
	private String couponid;
	
	
	@Column(name="coupon_name",columnDefinition = "nvarchar(50)")
	private String couponname;
	
	
	@Column(name="convert_id",columnDefinition = "nvarchar(50)")
	private String convertid;
	
	@Column(name = "start_date", columnDefinition = "smalldatetime")
	private String startdate;
	
	@Column(name="end_date",columnDefinition = "smalldatetime")
	private String enddate;
	
	@Column(name="coupon_amount")
	private Integer couponamount;
	
	@Column(name="instructions",columnDefinition = "text")
	private String instructions;
	
	public CouponBean() {
		
	}
	
	public CouponBean(String couponid, String couponname, String convertid, String startdate, String enddate,
			Integer couponamount, String instructions) {
		this.couponid = couponid;
		this.couponname = couponname;
		this.convertid = convertid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.couponamount = couponamount;
		this.instructions = instructions;
	}
	public String getCouponid() {
		return couponid;
	}
	public void setCouponid(String couponid) {
		this.couponid = couponid;
	}
	public String getCouponname() {
		return couponname;
	}
	public void setCouponname(String couponname) {
		this.couponname = couponname;
	}
	public String getConvertid() {
		return convertid;
	}
	public void setConvertid(String convertid) {
		this.convertid = convertid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public Integer getCouponamount() {
		return couponamount;
	}
	public void setCouponamount(Integer couponamount) {
		this.couponamount = couponamount;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	
}
