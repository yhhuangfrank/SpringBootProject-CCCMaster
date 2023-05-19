package com.ispan.CCCMaster.model.bean.service;

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
@Table(name = "ReportForm2")
public class ReportForm2Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "order_id")
	private Integer orderid;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "narrative", columnDefinition = "nvarchar(200)", nullable = true)
	private String narrative;
	
	@Column(name = "customer_id")
	private Integer customerid;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;
	
	@Column(name = "reply", columnDefinition = "nvarchar(200)", nullable = true)
	private String Reply;
	



	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "create_time", columnDefinition = "datetime")
	private Date createtime;
	

	@PrePersist
	public void onCreate() {
		if(createtime == null) {
			createtime = new Date();
		}
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getOrderid() {
		return orderid;
	}


	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getNarrative() {
		return narrative;
	}


	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}


	public Integer getCustomerid() {
		return customerid;
	}


	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getReply() {
		return Reply;
	}


	public void setReply(String reply) {
		Reply = reply;
	}
}
