package com.ispan.CCCMaster.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.CCCMaster.model.bean.Employee;
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

}
