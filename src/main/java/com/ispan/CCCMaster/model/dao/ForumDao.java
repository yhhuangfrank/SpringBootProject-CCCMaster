package com.ispan.CCCMaster.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.Forum.Forum;


public interface ForumDao extends JpaRepository<Forum,Integer> {
    Forum findFirstByOrderByAddedDesc();//获取最新的一条记录




}
