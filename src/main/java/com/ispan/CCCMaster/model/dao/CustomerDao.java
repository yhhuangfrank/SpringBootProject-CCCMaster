package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.customer.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	public Customer findByEmail(String email);
	
	@Query("FROM Customer as c WHERE c.name = :name")
	public Customer findByName(@Param("name") String name);
	
	@Query("FROM Customer as c WHERE c.phoneNumber = :phoneNumber")
	public Customer findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}
