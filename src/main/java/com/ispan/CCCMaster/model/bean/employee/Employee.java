package com.ispan.CCCMaster.model.bean.employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "employee_name", columnDefinition = "nvarchar(20)")
	private String employeeName;

	@Column(name = "phone_number", columnDefinition = "varchar(15)", unique = true)
	private String phoneNumber;
	
	@Column(name = "id_number", columnDefinition = "char(10)", unique = true)
	private String idNumber;
	
	@Column(name = "password", columnDefinition = "varchar(max)")
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "hire_date", columnDefinition = "date")
	private Date hireDate;
	
	@PrePersist	//建立該筆資料時自動產生當天日期
	public void onCreate() {
		if(hireDate == null) {
			hireDate = new Date();
		}
	}

	public Employee() {
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

}
