package com.ispan.CCCMaster.service;

import org.springframework.data.domain.Page;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.service.ReportForm2Model;

public interface ServiceFromService {

	public void createform(ReportForm2Model rfm);
	
	ReportForm2Model findReportFormById(Integer id);
	
	void deleteReportFormById(Integer id);
	
	public Page<ReportForm2Model> findByPage(Integer pageNumber,Integer customerid);
	ReportForm2Model getLatest();
	
	 public Customer getCustomerById(Integer customerId)  ;
	 
	 public OrderBean getOrderById(String orderid);

	
}
