package com.ispan.CCCMaster.model.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RecipientInfo")
public class RecipientInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "address", columnDefinition = "nvarchar(70)")
	private String address;
	
	@Column(name = "name", columnDefinition = "nvarchar(50)")
	private String name;
	
	@Column(name = "telephone")
	private String telephone;
	
	//雙向多對一
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="customer_id")
	private Customers cbRecipientInfo;
	
	public RecipientInfoBean(String address, String name, String telephone, Customers cbRecipientInfo) {
		this.address = address;
		this.name = name;
		this.telephone = telephone;
		this.cbRecipientInfo = cbRecipientInfo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	

}
