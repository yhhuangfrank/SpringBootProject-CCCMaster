package com.ispan.CCCMaster.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface LoginService {

	Boolean login(String accountNumber, String password, HttpServletRequest request);

	void logout(HttpSession session);
}
