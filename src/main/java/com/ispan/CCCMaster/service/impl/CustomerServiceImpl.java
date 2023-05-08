package com.ispan.CCCMaster.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao ctmDao;
	
	@Override
	public void createCustomer(Customer ctm) {
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
			old.setPassword(customer.getPassword());
			old.setPhoneNumber(customer.getPhoneNumber());
			old.setPoint(customer.getPoint());
			old.setAbandonCount(customer.getAbandonCount());
		}
	}
	
	@Override
	public void deleteById(Integer id) {
		ctmDao.deleteById(id);
	}

}
