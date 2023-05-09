package com.ispan.CCCMaster.model.bean.customer;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import org.springframework.format.annotation.DateTimeFormat;

import com.ispan.CCCMaster.model.bean.RecipientInfo.RecipientInfoBean;
import com.ispan.CCCMaster.model.bean.RecipientInfo.StoreRecipientInfoBean;
import com.ispan.CCCMaster.model.bean.order.BidOrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;

@Entity
@Table(name = "Customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer customerId;
	
	@Column(name = "email", columnDefinition = "varchar(50)")
	private String email;
	
	@Column(name = "password", columnDefinition = "varchar(20)")
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "start_date", columnDefinition = "datetime")
	private Date startDate;
	
	@Column(name = "name", columnDefinition = "nvarchar(15)")
	private String name;
	
	@Column(name = "phone_number", columnDefinition = "varchar(15)")
	private String phoneNumber;

	@Column(name = "point")
	private Integer point;
	
	@Column(name = "abandon_count")
	private Integer abandonCount;

	// 二手商品關聯 by Frank
	@Transient
	@OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
	private List<BidProduct> bidProductList;

	@PrePersist	//建立該筆資料時自動產生當天日期，以及把點數、棄標次數設為0
	public void onCreate() {
		if(startDate == null) {
			startDate = new Date();
		}
		if(point == null) {
			point=0;
		}
		if(abandonCount == null) {
			abandonCount = 0;
		}
	}

	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
	private Set<CustomerCoupon> customerCoupons = new HashSet<>();
	
	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
	private Set<CustomerFavorite> customerFavorites = new HashSet<>();
	
	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
	private Set<CustomerBrowsingHistory> customerBrowsingHistory = new HashSet<>();

	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
	private Set<CustomerNotify> customerNotify = new HashSet<>();
	
	// BY 瑛仁
	@OneToMany(mappedBy="cbShoppingCart")
	Set<ShoppingCartBean> set = new HashSet<>();
	
	public Customer() {
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getAbandonCount() {
		return abandonCount;
	}

	public void setAbandonCount(Integer abandonCount) {
		this.abandonCount = abandonCount;
	}

	// bidProduct getter & setter
	public List<BidProduct> getBidProductList() {
		return bidProductList;
	}

	public void setBidProductList(List<BidProduct> bidProductList) {
		this.bidProductList = bidProductList;
	}

	public Set<OrderBean> getSetco() {
		return setco;
	}

	public void setSetco(Set<OrderBean> setco) {
		this.setco = setco;
	}

	// private 方法 - 新增 bidProduct
	private void addBidProduct(BidProduct bidProduct) {
		if (bidProductList == null) {
            bidProductList = new ArrayList<>();
        }
        bidProductList.add(bidProduct);
	}

	//對收件地址(超商):一對多  by瑛仁
	@OneToMany(mappedBy="cbStoreRecipientInfo")
	Set<StoreRecipientInfoBean> setcsri = new HashSet<>();
			
	//對收件地址:一對多  by瑛仁
	@OneToMany(mappedBy="cbRecipientInfo")
	Set<RecipientInfoBean> setcri = new HashSet<>();
	
	//對訂單:一對多  by瑛仁
	@OneToMany(mappedBy="cbOrder")
//	@JsonIgnoreProperties("cbOrder")
	Set<OrderBean> setco = new LinkedHashSet<>();
	
	//對二手商品(買家):一對多  by瑛仁
	@OneToMany(mappedBy="cbBuyer")
	Set<BidOrderBean> setb = new HashSet<>();
	
	//對二手商品(賣家):一對多  by瑛仁
	@OneToMany(mappedBy="cbSeller")
	Set<BidOrderBean> sets = new HashSet<>();

}
