package com.ispan.CCCMaster.model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "WorkOrder")
public class WorkOrderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	

	@Column(name = "staff_id")
	private Integer staff_id;

	@Column(name = "form_id")
	private Integer form_id;
	

	@Column(name = "type")
	private String type;
	
	@Column(name = "emergency_level")
	private String emergency_level;
	

	@Column(name = "Processing_status")
	private String Processing_status;
	

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "create_time", columnDefinition = "datetime")
	private Date create_time;
	

	@PrePersist
	public void onCreate() {
		if(create_time == null) {
			create_time = new Date();
		}
	}
	

	@Column(name = "aging")
	private String aging;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getStaff_id() {
		return staff_id;
	}


	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}


	public Integer getForm_id() {
		return form_id;
	}


	public void setForm_id(Integer form_id) {
		this.form_id = form_id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getEmergency_level() {
		return emergency_level;
	}


	public void setEmergency_level(String emergency_level) {
		this.emergency_level = emergency_level;
	}


	public String getProcessing_status() {
		return Processing_status;
	}


	public void setProcessing_status(String processing_status) {
		Processing_status = processing_status;
	}


	public Date getCreate_time() {
		return create_time;
	}


	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}


	public String getAging() {
		return aging;
	}


	public void setAging(String aging) {
		this.aging = aging;
	}
	
	
	
}

