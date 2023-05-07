package com.ispan.CCCMaster.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Component
public class LoginIdProvider {

    public Optional<Integer> getLoginCustomerId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        return Optional.ofNullable( (Integer) session.getAttribute("customerId"));
    }

}
