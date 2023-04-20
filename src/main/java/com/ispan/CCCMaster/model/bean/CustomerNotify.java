package com.ispan.CCCMaster.model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CustomerNotify")
public class CustomerNotify {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "notify", columnDefinition = "nvarchar(50)")
	private String notify;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "build_time", columnDefinition = "datetime")
	private Date buildTime;
	
	@Column(name = "is_read", columnDefinition = "bit")
	private Boolean isRead;

	public CustomerNotify() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getNotify() {
		return notify;
	}

	public void setNotify(String notify) {
		this.notify = notify;
	}

	public Date getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

}
