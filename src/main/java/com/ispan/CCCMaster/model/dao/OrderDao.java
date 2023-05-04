package com.ispan.CCCMaster.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ispan.CCCMaster.model.bean.order.OrderBean;


public interface OrderDao extends JpaRepository<OrderBean, String>{
	
	
	
}
