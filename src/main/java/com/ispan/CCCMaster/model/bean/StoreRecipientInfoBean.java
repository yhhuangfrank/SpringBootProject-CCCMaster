package com.ispan.CCCMaster.model.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="StoreRecipientInfo")
public class StoreRecipientInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String storetype;
	private String storename;
	private String address;
	private String name;
	
	//雙向多對一
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="customer_id")
	private Customers cbStoreRecipientInfo;
		
	public StoreRecipientInfoBean(String storetype, String storename, String address, String name,
			Customers cbStoreRecipientInfo) {
		this.storetype = storetype;
		this.storename = storename;
		this.address = address;
		this.name = name;
		this.cbStoreRecipientInfo = cbStoreRecipientInfo;
	}
	public String getStoretype() {
		return storetype;
	}
	public void setStoretype(String storetype) {
		this.storetype = storetype;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
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
	
	

}
