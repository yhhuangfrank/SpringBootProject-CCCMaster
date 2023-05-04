package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
