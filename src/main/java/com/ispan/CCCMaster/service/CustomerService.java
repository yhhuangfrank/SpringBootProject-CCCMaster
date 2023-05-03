package com.ispan.CCCMaster.service;

import org.springframework.data.domain.Page;

import com.ispan.CCCMaster.model.bean.customer.Customer;

public interface CustomerService {

	void createCustomer(Customer ctm);

	Page<Customer> findByPage(Integer pageNumber);

}
