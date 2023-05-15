package com.ispan.CCCMaster.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.model.dao.OrderDao;
import com.ispan.CCCMaster.model.dao.OrderDetailDao;
import com.ispan.CCCMaster.model.dao.ProductDao;
import com.ispan.CCCMaster.model.dao.ShoppingCartDao;
import com.ispan.CCCMaster.service.OrderService;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import javax.persistence.criteria.Predicate;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao oDao;

	@Autowired
	OrderDetailDao odDao;

	@Autowired
	ShoppingCartDao scDao;

	@Autowired
	ProductDao pDao;
	
	@Autowired
	CustomerDao cDao;
	

	//依訂單編號找訂單
	@Override
	public OrderBean findOrderByid(String orderid) {
		Optional<OrderBean> option = oDao.findById(orderid);
		if(option.isEmpty()) {
			return null;
		}
		return option.get();
	}

	//找尋所有訂單
	@Override
	public Page<OrderBean> findOrdersByPage(Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber-1, 15,Sort.Direction.ASC,"orderid");
		Page<OrderBean> page = oDao.findAll(pgb);
		return page;
	}

	//訂單詳細資料
	@Override
	public List<OrderDetailBean> findOrder(){
		return odDao.findAll();
	}

	
	//更改訂單資料
	@Override
	@Transactional
	public void updateById(OrderBean orderBean) throws IOException{
		Optional<OrderBean> option = oDao.findById(orderBean.getOrderid());
		if(option.isPresent()) {
			OrderBean oldOrder = option.get();
			oldOrder.setArrivaldate(orderBean.getArrivaldate());
			oldOrder.setShipperaddress(orderBean.getShipperaddress());
			oldOrder.setOrdercondition(orderBean.getOrdercondition());
			oldOrder.setShipperaddress(orderBean.getShipperaddress());
		}
	}
	
	//建立訂單
	@Override
	@Transactional
	public void createOrder(OrderBean order,Integer customerId) throws IOException{
		Date date = new Date();
		String dateString = String.valueOf(date.getTime());
		//id
		order.setOrderid(dateString);
		//日期
		order.setOrderdate(date);
		//訂單狀態
		order.setOrdercondition("處理中");
		order.setPaymentcondition("未付款");
		//customerid
		Optional<Customer> cOption = cDao.findById(customerId);
		Customer c = cOption.get();
		order.setCbOrder(c);
		//將購物車加入訂單明細內
		Set<OrderDetailBean> orderdetails = new HashSet<>();
		List<ShoppingCartBean> scBean = scDao.findAllByCid(customerId);
		for(ShoppingCartBean sc : scBean) {
			OrderDetailBean od = new OrderDetailBean();
			od.setQuantity(sc.getScquantity());
			od.setUnitprice(sc.getUnitprice());
			od.setpOrderDetail(sc.getProductBean());
			od.setOrderBean(order);
			orderdetails.add(od);
			//更新存貨
			Optional<Product> poption = pDao.findById(sc.getProductBean().getProductId());
			Optional<ShoppingCartBean> scoption = scDao.findByPidandCid(sc.getProductBean().getProductId(),sc.getCbShoppingCart().getCustomerId());
			if(poption.isPresent()) {
				if(scoption.isPresent()) {				
					ShoppingCartBean oldsc = scoption.get();
					Integer min= oldsc.getScquantity();
					Product oldp = poption.get();
					Integer inventory = oldp.getInventory();
					inventory -= min;
					oldp.setInventory(inventory);
				}
			}
		}
		//計算訂單總額
		Integer totalamount = 0;
		for(ShoppingCartBean sc : scBean) {		
			totalamount += sc.getScquantity()*sc.getUnitprice();			
		}
		if(totalamount >1000) {
			order.setFreight(0);
		}else {
			order.setFreight(30);
		}
		order.setTotalamount(totalamount);
		order.setSeto(orderdetails);
		oDao.save(order);
		//刪除購物車
		scDao.deleteByCid(customerId);
	}

	//訂單的詳細資料
	@Override
	public List<OrderDetailBean> findorderdetailbyOId(String orderid) {
		return odDao.findByOid(orderid);	  
	}

	//金流
	@Override
	public String ecpayCheckout(Integer customerId) {	
		AllInOne all = new AllInOne("");
		AioCheckOutALL obj = new AioCheckOutALL();
		//特店編號
		obj.setMerchantID("3002607");
		//交易時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setLenient(false);
		obj.setMerchantTradeDate(sdf.format(new Date()));
		Optional<OrderBean> option = oDao.findByCidByOrderDateDesc(customerId);
		if(option.isPresent()) {
			OrderBean order = option.get();
			//交易金額
			String payamounts = String.valueOf(order.getTotalamount()+order.getFreight());
			obj.setTotalAmount(payamounts);
			//交易編號
			obj.setMerchantTradeNo("test"+order.getOrderid());
		}	
		//交易描述
		obj.setTradeDesc("test Description");
		//商品名稱
		obj.setItemName("3C商品");
		obj.setReturnURL("http://localhost:8080/returnURL");
		//付完後回到首頁
		obj.setOrderResultURL("http://localhost:8080/front/orders/edit");
		obj.setNeedExtraPaidInfo("N");
		String form = all.aioCheckOut(obj, null);
		return form;
	}

	//個人的訂單清單
	@Override
	public List<OrderBean> findOrderByCId(Integer customerId) {
		return oDao.findAllByCid(customerId);
	}
	
	// orderDetailId 找 orderDetail by 暐翔
	@Override
	public OrderDetailBean findOrderDetailById(Integer id){
		Optional<OrderDetailBean> optional=odDao.findById(id);
		if(optional.isPresent()){
			return optional.get();
		}
		return null;
	}

	//個人訂單最新的一筆
	@Override
	public OrderBean findLatestByCid(Integer customerId) {
		Optional<OrderBean> option = oDao.findByCidByOrderDateDesc(customerId);
		if(option.isEmpty()) {
			return null;
		}
		return option.get();
	}
	
	@Override
	public List<OrderBean> findByOrderId(Integer customerId,String orderid){
		return oDao.findByCidByIdContainingByOrderDateDesc(customerId, orderid);
	}
	
	//依時間搜尋
	@Override
	public List<OrderBean> findByDate(String date) throws ParseException {
		Date startDate = getStartDate(date);
		Date endDate = getEndDate(date);
		Specification<OrderBean> spec = (root, query, criteriaBuilder) -> {
			Predicate p1 = criteriaBuilder.greaterThanOrEqualTo(root.get("time"), startDate);
			Predicate p2 = criteriaBuilder.greaterThanOrEqualTo(root.get("time"), endDate);
			return criteriaBuilder.or(p1,p2);
		};
		return oDao.findAll(spec);
	}
	
	//將搜尋輸入的年(年月)加上0101(01)
	@Override
	public Date getStartDate(String yearOrMonth) throws ParseException {
		String startDateStr = yearOrMonth.length() == 4?yearOrMonth+"0101":yearOrMonth+"01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = sdf.parse(startDateStr);
		return sdate;
	}

	//將搜尋輸入的年(年月)加上1231(31)
	@Override
	public Date getEndDate(String yearOrMonth) throws ParseException {
		String endDateStr = yearOrMonth.length() == 4?yearOrMonth+"1231":yearOrMonth+"31";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date edate = sdf.parse(endDateStr);
		return edate;
	}

	

}
