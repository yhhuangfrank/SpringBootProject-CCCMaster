package com.ispan.CCCMaster.model.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;

public interface OrderDetailDao extends JpaRepository<OrderDetailBean, Integer>{

}
