package com.ispan.CCCMaster.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public Boolean login(String accountNumber, String password, HttpServletRequest request) {
		Boolean success = false;
		Customer foundCustomer = ctmDao.findByEmail(accountNumber);	//透過輸入的帳號尋找對應的會員
		//目前只有用 email 登入功能，未來會開發透過手機號碼登入
		if(foundCustomer == null) {
			return success;
		}
		String foundPassword = foundCustomer.getPassword();
		success = foundPassword.equals(password);
		if(success) {	//若登入成功則使原本的 session 失效，並取得新 session
			HttpSession session = request.getSession();
			session.invalidate();
			session = request.getSession();
			session.setAttribute("customerId", foundCustomer.getCustomerId());
			session.setAttribute("customerName", foundCustomer.getName());
		}
		return success;
	}
	
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

}
