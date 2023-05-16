package com.ispan.CCCMaster.model.dao;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.order.OrderBean;


public interface OrderDao extends JpaRepository<OrderBean, String>,JpaSpecificationExecutor<OrderBean>{
	
	@Query(value="select * from Orders where customer_id= :id",nativeQuery = true)
	public List<OrderBean> findAllByCid(@Param(value="id")Integer customerId);
	
	@Query(value="select TOP (1) * from Orders where customer_id= :id order by order_date DESC",nativeQuery = true)
	public Optional<OrderBean> findByCidByOrderDateDesc(@Param(value="id")Integer customerId);
	
	//編號的查詢條件(前台)
	@Query(value="select * from Orders where customer_id= :cid AND order_id LIKE %:oid% order by order_date DESC",nativeQuery = true)
	public List<OrderBean> findByCidByIdContainingByOrderDateDesc(@Param(value="cid")Integer customerId,@Param(value="oid")String orderid);
	
	//編號的查詢條件(後台)
	@Query(value="select * from Orders where order_id LIKE %:oid%",nativeQuery = true)
	public List<OrderBean> findByIdContaining(@Param(value="oid")String orderid);
	
	//處理中查詢
	@Query(value="select * from Orders where order_condition = '處理中'",nativeQuery = true)
	public Page<OrderBean> findByOrderCondition(Pageable pageable);
	
	//處理中-編號查詢
	@Query(value="select * from Orders where order_condition = '處理中' AND order_id LIKE %:oid%",nativeQuery = true)
	public List<OrderBean> findByOrderConditionByIdContaining(@Param(value="oid")String orderid);
	
	//未付款查詢
	@Query(value="select * from Orders where payment_condition = '未付款'",nativeQuery = true)
	public Page<OrderBean> findBPaymentCondition(Pageable pageable);
	
	//未付款-編號查詢
	@Query(value="select * from Orders where payment_condition = '未付款' AND order_id LIKE %:oid%",nativeQuery = true)
	public List<OrderBean> findByPaymentConditionByIdContaining(@Param(value="oid")String orderid);
	
	//訂單取消查詢
	@Query(value="select * from Orders where order_condition = '已取消'",nativeQuery = true)
	public Page<OrderBean> findCancelOrder(Pageable pageable);
	
	//訂單取消-編號查詢
	@Query(value="select * from Orders where order_condition = '已取消' AND order_id LIKE %:oid%",nativeQuery = true)
	public List<OrderBean> findByCancelOrderByIdContaining(@Param(value="oid")String orderid);
	
	//退款中查詢
	@Query(value="select * from Orders where payment_condition = '退款中'",nativeQuery = true)
	public Page<OrderBean> findRefund(Pageable pageable);
	
	//退款中-編號查詢
	@Query(value="select * from Orders where payment_condition = '退款中' AND order_id LIKE %:oid%",nativeQuery = true)
	public List<OrderBean> findByRefundByIdContaining(@Param(value="oid")String orderid);

	//個人訂單已完成
//	@Query(value="select * from Orders where order_condition = '已完成' AND order_id=:id AND customer_id= :cid",nativeQuery = true)
//	public Optional<OrderBean> findFinishOrder(@Param(value="id")String orderid,@Param(value="cid")Integer customerId);
	
}
