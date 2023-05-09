package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.service.MessageClient;

public interface MessagesDao extends JpaRepository<MessageClient, Integer> {

     public MessageClient findFirstByOrderByCreatetimeDesc();
}
