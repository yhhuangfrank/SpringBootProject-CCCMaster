package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.service.MessageModel;

public interface MessagesDao extends JpaRepository<MessageModel, Integer> {

     public MessageModel findFirstByOrderByCreatetimeDesc();
}
