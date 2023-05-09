package com.ispan.CCCMaster.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Component
public class LoginUtil {

    public Optional<Integer> getLoginCustomerIdOptional(HttpSession session) {
        return Optional.ofNullable( (Integer) session.getAttribute("customerId"));
    }

    public Integer getLoginCustomerId(HttpSession session) {
        return (Integer) session.getAttribute("customerId");
    }

}
