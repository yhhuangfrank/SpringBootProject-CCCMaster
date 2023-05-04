package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
