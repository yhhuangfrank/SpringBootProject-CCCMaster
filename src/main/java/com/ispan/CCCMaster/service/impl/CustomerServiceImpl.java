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

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.model.dto.CustomerCheckRequest;
import com.ispan.CCCMaster.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao ctmDao;
	
	@Override
	public void createCustomer(Customer ctm) {
		String hashedPw = BCrypt.hashpw(ctm.getPassword(), BCrypt.gensalt());
		ctm.setPassword(hashedPw);
		ctmDao.save(ctm);
	}
	
	@Override
	public Page<Customer> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.ASC, "customerId");
		Page<Customer> page = ctmDao.findAll(pgb);
		return page;
	}
	
	@Override
	public Customer findById(Integer id) {
		Optional<Customer> option = ctmDao.findById(id);
		if(option.isEmpty()) {
			return null;
		} else {
			return option.get();
		}
	}
	
	@Override
	@Transactional
	public void editById(Customer customer) {
		Optional<Customer> option = ctmDao.findById(customer.getCustomerId());
		if(option.isPresent()) {
			Customer old = option.get();
			old.setEmail(customer.getEmail());
			old.setName(customer.getName());
//			old.setPassword(customer.getPassword());
			old.setPhoneNumber(customer.getPhoneNumber());
			old.setPoint(customer.getPoint());
			old.setAbandonCount(customer.getAbandonCount());
		}
	}
	
	@Override
	@Transactional
	public void editByIdForCustomer(Customer customer) {
		Optional<Customer> option = ctmDao.findById(customer.getCustomerId());
		if(option.isPresent()) {
			Customer old = option.get();
			old.setEmail(customer.getEmail());
			old.setName(customer.getName());
			String hashedPw = BCrypt.hashpw(customer.getPassword(), BCrypt.gensalt());
			old.setPassword(hashedPw);
			old.setPhoneNumber(customer.getPhoneNumber());
		}
	}
	
	@Override
	public void deleteById(Integer id) {
		ctmDao.deleteById(id);
	}
	
	@Override
	public Boolean logIn(String accountNumber, String password, HttpServletRequest request) {
		Boolean success = false;
		Customer foundCustomer = ctmDao.findByEmail(accountNumber);	//透過輸入的帳號尋找對應的會員
		//目前只有用 email 登入功能，未來會開發透過手機號碼登入
		if(foundCustomer == null) {
			return success;
		}
		String foundPassword = foundCustomer.getPassword();
		success = BCrypt.checkpw(password, foundPassword);
		if(success) {	//若登入成功則使原本的 session 失效，並取得新 session
			HttpSession session = request.getSession();
			session.invalidate();
			session = request.getSession();
			session.setAttribute("customerId", foundCustomer.getCustomerId());	//把 customerId 存進 session
			session.setAttribute("customerName", foundCustomer.getName());	//把 customerName 存進 session
		}
		return success;
	}
	
	@Override
	public void logOut(HttpSession session) {
		session.invalidate();
	}
	
	@Override
	public Boolean canEmailUse(CustomerCheckRequest ccr) {
		Customer foundCustomer = ctmDao.findByEmail(ccr.getEmail());
//		if(foundCustomer == null) {
//			return true;
//		} else {
//			return false;
//		}
		
		return foundCustomer == null ? true : false;
	}
	
	@Override
	public Boolean canNameUse(CustomerCheckRequest ccr) {
		Customer foundCustomer = ctmDao.findByName(ccr.getName());
//		if(foundCustomer == null) {
//			return true;
//		} else {
//			return false;
//		}
		
		return foundCustomer == null ? true : false;
	}
	
	@Override
	public Boolean canPhoneNumberUse(CustomerCheckRequest ccr) {
		Customer foundCustomer = ctmDao.findByPhoneNumber(ccr.getPhoneNumber());
//		if(foundCustomer == null) {
//			return true;
//		} else {
//			return false;
//		}
		
		return foundCustomer == null ? true : false;
	}

}
