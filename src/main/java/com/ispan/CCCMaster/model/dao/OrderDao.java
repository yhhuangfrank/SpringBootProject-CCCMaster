package com.ispan.CCCMaster.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;



import com.ispan.CCCMaster.model.bean.OrderBean;


public interface OrderDao extends JpaRepository<OrderBean, String>{
	
	
	
}
