package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.Forum.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseDao extends JpaRepository<Response, Integer> {
    Response findFirstByOrderByAddedDesc();
}
