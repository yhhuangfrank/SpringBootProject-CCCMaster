package com.ispan.CCCMaster.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ispan.CCCMaster.model.bean.service.ChatroomModel;

@Repository
public interface ChatroomRepository extends JpaRepository<ChatroomModel, Integer> {
    // 添加自定義的查詢方法，例如：
    Optional<ChatroomModel> findByChatroomid(Integer chatroomid);
}