package com.ispan.CCCMaster.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private CustomerDao ctmDao;

}
