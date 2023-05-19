package com.ispan.CCCMaster.service.impl;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.employee.Employee;
import com.ispan.CCCMaster.model.dao.EmployeeDao;
import com.ispan.CCCMaster.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao epyDao;
	
	@Override
	public void createEmployee(Employee epy) {
		String hashedPw = BCrypt.hashpw(epy.getPassword(), BCrypt.gensalt());
		epy.setPassword(hashedPw);
		epyDao.save(epy);
	}
	
	@Override
	public Page<Employee> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.ASC, "employeeId");
		Page<Employee> page = epyDao.findAll(pgb);
		return page;
	}
	
	@Override
	public Employee findById(Integer id) {
		Optional<Employee> option = epyDao.findById(id);
		if(option.isEmpty()) {
			return null;
		} else {
			return option.get();
		}
	}
	
	@Override
	@Transactional
	public void editById(Employee employee) {
		Optional<Employee> option = epyDao.findById(employee.getEmployeeId());
		if(option.isPresent()) {
			Employee old = option.get();
			old.setEmployeeName(employee.getEmployeeName());
			old.setPosition(employee.getPosition());
			old.setPhoneNumber(employee.getPhoneNumber());
			old.setIdNumber(employee.getIdNumber());
			old.setPassword(employee.getPassword());
		}
	}
	
	@Override
	public void deleteById(Integer id) {
		epyDao.deleteById(id);
	}
	
	@Override
	public Boolean logIn(Integer employeeId, String password, HttpServletRequest request) {
		Boolean success = false;
		Optional<Employee> option = epyDao.findById(employeeId);	//透過輸入的編號尋找對應的員工
		if(option.isEmpty()) {
			return success;
		}
		Employee foundEmployee = option.get();
		String foundPassword = foundEmployee.getPassword();
		success = BCrypt.checkpw(password, foundPassword);
		if(success) {	//若登入成功則使原本的 session 失效，並取得新 session
			HttpSession session = request.getSession();
			session.invalidate();
			session = request.getSession();
			session.setAttribute("employeeId", foundEmployee.getEmployeeId());	//把 employeeId 存進 session
			session.setAttribute("employeeName", foundEmployee.getEmployeeName());	//把 employeeName 存進 session
			session.setAttribute("positionName", foundEmployee.getPosition().getPositionName());	//把 positionName 存進 session
		}
		return success;
	}
	
	@Override
	public void logOut(HttpSession session) {
		session.invalidate();
	}

}
