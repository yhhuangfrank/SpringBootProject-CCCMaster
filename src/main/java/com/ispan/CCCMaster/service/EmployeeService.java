package com.ispan.CCCMaster.service;

import org.springframework.data.domain.Page;

import com.ispan.CCCMaster.model.bean.employee.Employee;

public interface EmployeeService {

	void createEmployee(Employee epy);

	Page<Employee> findByPage(Integer pageNumber);

	Employee findById(Integer id);

	void editById(Employee employee);

	void deleteById(Integer id);

}