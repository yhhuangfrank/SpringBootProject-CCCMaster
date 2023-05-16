package com.ispan.CCCMaster.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ispan.CCCMaster.model.customexception.CustomerUnLoginException;
import com.ispan.CCCMaster.model.customexception.EmployeeUnLoginException;

@Aspect
@Component
public class Authentication {
	
	@Autowired
	private HttpSession session;
	
	@Before("@annotation(com.ispan.CCCMaster.annotation.CustomerAuthentication)")	//只要使用 @CustomerAuthentication 註解的 Method 都會受到驗證保護
	public void authenticateCustomer() {
		Object customer = session.getAttribute("customerId");
		
		if (customer == null) throw new CustomerUnLoginException();
	}
	
	@Before("@annotation(com.ispan.CCCMaster.annotation.EmployeeAuthentication)")	//只要使用 @EmployeeAuthentication 註解的 Method 都會受到驗證保護
	public void authenticateEmployee() {
		Object employee = session.getAttribute("employeeId");
		
		if (employee == null) throw new EmployeeUnLoginException();
	}

}
