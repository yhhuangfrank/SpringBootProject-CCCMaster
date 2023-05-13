package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.service.chatModel;

public interface MessagesDao extends JpaRepository<chatModel, Integer> {

     public chatModel findFirstByOrderByCreatetimeDesc();
}
