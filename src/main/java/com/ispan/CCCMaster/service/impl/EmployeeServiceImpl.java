package com.ispan.CCCMaster.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	public Employee findById(Integer id) {
		Optional<Employee> option = epyRepository.findById(id);
		if(option.isEmpty()) {
			return null;
		} else {
			return option.get();
		}
	}
	
	@Override
	@Transactional
	public void editById(Employee employee) {
		Optional<Employee> option = epyRepository.findById(employee.getEmployeeId());
		if(option.isPresent()) {
			Employee old = option.get();
			old.setEmployeeName(employee.getEmployeeName());
			old.setPositionId(employee.getPositionId());
			old.setPhoneNumber(employee.getPhoneNumber());
			old.setIdNumber(employee.getIdNumber());
			old.setPassword(employee.getPassword());
		}
	}
	
	@Override
	public void deleteById(Integer id) {
		epyRepository.deleteById(id);
	}

}
