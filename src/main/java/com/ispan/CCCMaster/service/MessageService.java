package com.ispan.CCCMaster.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.service.MessageClient;
import com.ispan.CCCMaster.model.dao.MessagesDao;

@Service
public class MessageService {
	
    @Autowired
	private MessagesDao msgRepository;
    
    public void addMessage(MessageClient msg) {
    	msgRepository.save(msg);
    }
    
    public MessageClient findMessagesById(Integer id) {
    	Optional<MessageClient> option = msgRepository.findById(id);
    	
    	if(option.isEmpty()) {
    		return null;
    	}
    	
    	return option.get();
    	
    }
    
    public void deleteMessagesById(Integer id) {
    	msgRepository.deleteById(id);
    }
    
    public Page<MessageClient> findByPage(Integer pageNumber){
    	Pageable pgb = PageRequest.of(pageNumber-1, 3, Sort.Direction.DESC,"createtime");
    	Page<MessageClient> page = msgRepository.findAll(pgb);
    	return page;
    }
    
    @Transactional
    public MessageClient updateById(Integer id, String newMsg,Integer newCid) {
    	Optional<MessageClient> option = msgRepository.findById(id);
    	
    	if(option.isPresent()) {
    		MessageClient msg = option.get();
    		msg.setContent(newMsg);
    		msg.setChatroomid(newCid);
    		return msg;
    	}
    	return null;
    }
    public MessageClient getLatest() {
    	return msgRepository.findFirstByOrderByCreatetimeDesc();
    }
    
}
