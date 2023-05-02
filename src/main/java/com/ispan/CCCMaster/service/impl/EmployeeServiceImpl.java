package com.ispan.CCCMaster.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ispan.CCCMaster.model.bean.employee.Employee;
import com.ispan.CCCMaster.model.dao.EmployeeRepository;
import com.ispan.CCCMaster.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository epyRepository;
	
	@Override
	public void createEmployee(Employee epy) {
		epyRepository.save(epy);
	}
	
	@Override
	public Page<Employee> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.ASC, "employeeId");
		Page<Employee> page = epyRepository.findAll(pgb);
		return page;
	}

}
