package com.ispan.CCCMaster.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.CCCMaster.model.bean.Employees;
import com.ispan.CCCMaster.model.dao.EmployeeRepository;
import com.ispan.CCCMaster.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository epyRepository;
	
	@Override
	public void createEmployee(Employees epy) {
		epyRepository.save(epy);
	}

}
