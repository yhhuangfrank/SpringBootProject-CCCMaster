package com.ispan.CCCMaster.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.service.CustomerService;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Component
public class LoginUtil {
	
	// add by YUYU
	@Autowired
	private CustomerService ctmService;

    // api 使用
    public Optional<Integer> getLoginCustomerIdOptional(HttpSession session) {
        return Optional.ofNullable( (Integer) session.getAttribute("customerId"));
    }

    // 一般 controller 使用
    public Integer getLoginCustomerId(HttpSession session) {
        return (Integer) session.getAttribute("customerId");
    }
    
    // add by YUYU
    public Customer getLoginCustomer(HttpSession session) {
    	Integer customerId = (Integer) session.getAttribute("customerId");
    	return ctmService.findById(customerId);
    }

}
