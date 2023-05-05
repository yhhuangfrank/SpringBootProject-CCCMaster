package com.ispan.CCCMaster.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private CustomerDao ctmDao;
	
	@Override
	public Boolean login(Customer ctm) {
		Customer foundCustomer = ctmDao.findByEmail(ctm.getEmail());
		String foundPassword = foundCustomer.getPassword();
		return foundPassword.equals(ctm.getPassword());
	}

}
