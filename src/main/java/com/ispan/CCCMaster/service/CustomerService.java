package com.ispan.CCCMaster.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;

import com.ispan.CCCMaster.model.bean.customer.Customer;

public interface CustomerService {

	void createCustomer(Customer ctm);

	Page<Customer> findByPage(Integer pageNumber);

	void deleteById(Integer id);

	Customer findById(Integer id);

	void editById(Customer customer);

	Boolean login(String accountNumber, String password, HttpServletRequest request);

	void logout(HttpSession session);

}
