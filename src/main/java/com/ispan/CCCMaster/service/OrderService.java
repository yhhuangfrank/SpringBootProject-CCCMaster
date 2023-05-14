package com.ispan.CCCMaster.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;

public interface OrderService {

	//依訂單編號找訂單(後台)
	OrderBean findOrderByid(String orderid);

	//找尋所有訂單(後台)
	List<OrderBean> findOrders();

	//訂單詳細資料
	List<OrderDetailBean> findOrder();

	//更改訂單資料
//	void updateById(OrderBean orderBean) throws IOException;
	
	//創立訂單
	void createOrder(OrderBean order,Integer customerId) throws IOException;
	
	//依照訂單找尋各自的訂單詳細資料
	List<OrderDetailBean> findorderdetailbyOId(String orderid);
	
	//綠界
	String ecpayCheckout(Integer customerId);

	//個人的所有訂單清單
	List<OrderBean> findOrderByCId(Integer customerId);


    // orderDetailId 找 orderDetail by 暐翔
    OrderDetailBean findOrderDetailById(Integer id);

    //個人訂單最新一筆
    OrderBean findLatestByCid(Integer customerId);
    
    //依訂單編號做搜尋
    public List<OrderBean> findByOrderId(Integer customerId,String orderid);
    
    //依時間搜尋
    public List<OrderBean> findByDate(String date)throws ParseException;
    
    //將搜尋輸入的年(年月)加上0101(01)
    public  Date getStartDate(String yearOrMonth)throws ParseException;
    
    //將搜尋輸入的年(年月)加上1231(31)
    public  Date getEndDate(String yearOrMonth)throws ParseException;
    

}