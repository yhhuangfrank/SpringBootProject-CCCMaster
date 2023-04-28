package com.ispan.CCCMaster.model.bean.employee;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Positions")
public class Position {
	
	@Id
	@Column(name = "position_id")
	private Integer positionId;
	
	@Column(name = "position_name", columnDefinition = "nvarchar(30)")
	private String positionName;
	
	@OneToMany(mappedBy = "positions", cascade = CascadeType.ALL)
	private Set<Employee> employees = new HashSet<>();

	public Position() {
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

}
