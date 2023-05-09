package com.ispan.CCCMaster.util;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class LoginUtil {

    public Optional<Integer> getLoginCustomerId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        return Optional.ofNullable( (Integer) session.getAttribute("customerId"));
    }

}
