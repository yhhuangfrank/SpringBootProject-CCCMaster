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
	public Boolean login(String accountNumber, String password) {
		Customer foundCustomer = ctmDao.findByEmail(accountNumber);	//透過輸入的帳號尋找對應的會員
		//目前只有用 email 登入功能，未來會開發透過手機號碼登入功能
		String foundPassword = foundCustomer.getPassword();
		Boolean success = foundPassword.equals(password);
		return success;
	}

}
