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
@Table(name = "messageServer")
public class MessageServer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "messageServer_id")
	private Integer messageServerid;
	
	@Column(name = "chatroomid")
	private Integer chatroomid;
	
	@Column(name = "content", columnDefinition = "nvarchar(200)", nullable = true)
	private String content;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "createtime", columnDefinition = "datetime")
	private Date createtime;
	

	@PrePersist
	public void onCreate() {
		if(createtime == null) {
			createtime = new Date();
		}
	}

	public MessageServer() {
	}

	public Integer getMessageServerid() {
		return messageServerid;
	}

	public void setMessageServerid(Integer messageServerid) {
		this.messageServerid = messageServerid;
	}



	public Integer getChatroomid() {
		return chatroomid;
	}


	public void setChatroomid(Integer chatroomid) {
		this.chatroomid = chatroomid;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	

}
