package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.bid.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
}
