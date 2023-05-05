package com.ispan.CCCMaster.model.dao;


import com.ispan.CCCMaster.model.bean.Forum.Forum;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ForumDao extends JpaRepository<Forum,Integer> {
    Forum findFirstByOrderByAddedDesc();//获取最新的一条记录




}
