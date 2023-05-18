package com.ispan.CCCMaster.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.service.ReportForm2Model;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.model.dao.OrderDao;
import com.ispan.CCCMaster.model.dao.ServiceFromDao;

@Service
public class ServiceFromServiceImpl implements com.ispan.CCCMaster.service.ServiceFromService {
	
    @Autowired
    private ServiceFromDao serviceFromDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private OrderDao orderDao;

    public void createform(ReportForm2Model rfm) {
    	serviceFromDao.save(rfm);
    }
    
    public ReportForm2Model findReportFormById(Integer id) {
    	Optional<ReportForm2Model> option = serviceFromDao.findById(id);

    	if(option.isEmpty()) {
    		return null;
    	}
    	
    	return option.get();
    	
    }

    public void deleteReportFormById(Integer id) {
    	serviceFromDao.deleteById(id);
    }

    public Page<ReportForm2Model> findByPageId(Integer pageNumber,Integer customerid){
    	Pageable pgb = PageRequest.of(pageNumber-1, 5, Sort.Direction.DESC,"createtime");
    	Page<ReportForm2Model> page = serviceFromDao.findAllByCustomerid(customerid,pgb);
    	return page;
    }
    public Page<ReportForm2Model> findByPage(Integer pageNumber){
    	Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC,"createtime");
    	Page<ReportForm2Model> page = serviceFromDao.findAll(pgb);
    	return page;
    }

	public ReportForm2Model getLatest() {
		return serviceFromDao.findFirstByOrderByCreatetimeDesc();
	}
	
	@Transactional
	public ReportForm2Model updateById(Integer id, String newMsg) {
    Optional<ReportForm2Model> option = serviceFromDao.findById(id);
		
		if(option.isPresent()) {
			ReportForm2Model msg = option.get();
			msg.setReply(newMsg);;
			return msg;
		}
		return null;
	}

	
	
	//查詢客戶資料
    public Customer getCustomerById(Integer customerId) {
        return customerDao.findByCustomerId(customerId);
    }
    //查詢訂單資料
    public OrderBean getOrderById(String orderid) {
        return orderDao.findByOrderid(orderid);
    }

}
