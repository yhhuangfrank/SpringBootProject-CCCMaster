package com.ispan.CCCMaster.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.dto.CustomerCheckRequest;

public interface CustomerService {

	void createCustomer(Customer ctm);

	Page<Customer> findByPage(Integer pageNumber);

	void deleteById(Integer id);

	Customer findById(Integer id);

	void editById(Customer customer);

	Boolean logIn(String accountNumber, String password, HttpServletRequest request);

	void logOut(HttpSession session);

	Boolean canEmailUse(CustomerCheckRequest ccr);

	Boolean canNameUse(CustomerCheckRequest ccr);

	Boolean canPhoneNumberUse(CustomerCheckRequest ccr);

	void editByIdForCustomer(Customer customer);

}
