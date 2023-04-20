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
@Table(name = "ServiceForm")
public class ServiceFormModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	

	@Column(name = "chatroom_id")
	private Integer chatroom_id;

	@Column(name = "staff_id")
	private Integer staff_id;
	
	@Column(name = "type")
	private String type;
	

	@Column(name = "commentator")
	private String commentator;
	

	@Column(name = "remark", columnDefinition = "nvarchar(200)", nullable = true)
	private String remark;
	
	@Column(name = "reception_hours")
	private String reception_hours;


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


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getChatroom_id() {
		return chatroom_id;
	}


	public void setChatroom_id(Integer chatroom_id) {
		this.chatroom_id = chatroom_id;
	}


	public Integer getStaff_id() {
		return staff_id;
	}


	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCommentator() {
		return commentator;
	}


	public void setCommentator(String commentator) {
		this.commentator = commentator;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getReception_hours() {
		return reception_hours;
	}


	public void setReception_hours(String reception_hours) {
		this.reception_hours = reception_hours;
	}


	public Date getCreate_time() {
		return create_time;
	}


	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
}
