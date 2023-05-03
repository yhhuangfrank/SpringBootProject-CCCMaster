package com.ispan.CCCMaster.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.dao.CustomerRepository;
import com.ispan.CCCMaster.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository ctmRepository;
	
	@Override
	public void createCustomer(Customer ctm) {
		ctmRepository.save(ctm);
	}
	
	@Override
	public Page<Customer> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.ASC, "customerId");
		Page<Customer> page = ctmRepository.findAll(pgb);
		return page;
	}

}
