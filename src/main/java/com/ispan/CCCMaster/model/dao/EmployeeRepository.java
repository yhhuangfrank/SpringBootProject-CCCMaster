package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
