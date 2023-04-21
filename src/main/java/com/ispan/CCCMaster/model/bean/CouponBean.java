package com.ispan.CCCMaster.model.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Coupon")
public class CouponBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String couponid;
	private String couponname;
	private String convertid;
	private Timestamp startdate;
	private Timestamp enddate;
	private Integer couponamount;
	private String instructions;
	
	
	
	public CouponBean(String couponid, String couponname, String convertid, Timestamp startdate, Timestamp enddate,
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
	public Timestamp getStartdate() {
		return startdate;
	}
	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}
	public Timestamp getEnddate() {
		return enddate;
	}
	public void setEnddate(Timestamp enddate) {
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
