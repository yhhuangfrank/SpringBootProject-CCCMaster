package com.ispan.CCCMaster.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.service.MessageModel;
import com.ispan.CCCMaster.model.dao.MessagesRepository;

@Service
public class MessageService {
	
    @Autowired
	private MessagesRepository msgRepository;
    
    public void addMessage(MessageModel msg) {
    	msgRepository.save(msg);
    }
    
    public MessageModel findMessagesById(Integer id) {
    	Optional<MessageModel> option = msgRepository.findById(id);
    	
    	if(option.isEmpty()) {
    		return null;
    	}
    	
    	return option.get();
    	
    }
    
    public void deleteMessagesById(Integer id) {
    	msgRepository.deleteById(id);
    }
    
    public Page<MessageModel> findByPage(Integer pageNumber){
    	Pageable pgb = PageRequest.of(pageNumber-1, 3, Sort.Direction.DESC,"createtime");
    	Page<MessageModel> page = msgRepository.findAll(pgb);
    	return page;
    }
    
    @Transactional
    public MessageModel updateById(Integer id, String newMsg,Integer newCid,Integer newItr) {
    	Optional<MessageModel> option = msgRepository.findById(id);
    	
    	if(option.isPresent()) {
    		MessageModel msg = option.get();
    		msg.setContent(newMsg);
    		msg.setChatroomid(newCid);
    		msg.setInitiator(newItr);
    		return msg;
    	}
    	return null;
    }
    public MessageModel getLatest() {
    	return msgRepository.findFirstByOrderByCreatetimeDesc();
    }
    
}
