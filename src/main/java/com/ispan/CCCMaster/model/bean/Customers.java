package com.ispan.CCCMaster.model.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Customers")
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;
	
	@Column(name = "email", columnDefinition = "varchar(50)")
	private String email;
	
	@Column(name = "password", columnDefinition = "varchar(20)")
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "start_date", columnDefinition = "datetime")
	private Date startDate;
	
	@Column(name = "name", columnDefinition = "nvarchar(15)")
	private String name;
	
	@Column(name = "phone_number", columnDefinition = "varchar(15)")
	private String phoneNumber;

	@Column(name = "point")
	private Integer point;
	
	@Column(name = "abandon_count")
	private Integer abandonCount;
	
	// BY 瑛仁
	@OneToMany(mappedBy="cbShoppingCart")
	Set<ShoppingCartBean> set = new HashSet<>();
	
	public Customers() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getAbandonCount() {
		return abandonCount;
	}

	public void setAbandonCount(Integer abandonCount) {
		this.abandonCount = abandonCount;
	}

}
