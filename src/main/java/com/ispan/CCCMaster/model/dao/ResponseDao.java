package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.Forum.Response;

public interface ResponseDao extends JpaRepository<Response, Integer> {
    Response findFirstByOrderByAddedDesc();
}
