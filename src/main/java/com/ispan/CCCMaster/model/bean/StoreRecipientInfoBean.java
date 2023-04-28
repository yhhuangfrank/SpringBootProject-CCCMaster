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

import com.ispan.CCCMaster.model.bean.customer.Customer;

@Entity
@Table(name="StoreRecipientInfo")
public class StoreRecipientInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "storetype", columnDefinition = "nvarchar(10)")
	private String storetype;
	
	@Column(name = "storename", columnDefinition = "nvarchar(20)")
	private String storename;
	
	@Column(name = "address", columnDefinition = "nvarchar(70)")
	private String address;
	
	@Column(name = "name", columnDefinition = "nvarchar(50)")
	private String name;
	
	//雙向多對一
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="customer_id")
	private Customer cbStoreRecipientInfo;
		
	public StoreRecipientInfoBean(String storetype, String storename, String address, String name,
			Customer cbStoreRecipientInfo) {
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
