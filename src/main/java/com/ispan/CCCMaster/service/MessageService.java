package com.ispan.CCCMaster.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.service.chatModel;
import com.ispan.CCCMaster.model.dao.MessagesDao;

@Service
public class MessageService {
	
    @Autowired
	private MessagesDao msgRepository;
    
    public void addMessage(chatModel msg) {
    	msgRepository.save(msg);
    }
    
    public chatModel findMessagesById(Integer id) {
    	Optional<chatModel> option = msgRepository.findById(id);
    	
    	if(option.isEmpty()) {
    		return null;
    	}
    	
    	return option.get();
    	
    }
    
    public void deleteMessagesById(Integer id) {
    	msgRepository.deleteById(id);
    }
    
    public Page<chatModel> findByPage(Integer pageNumber){
    	Pageable pgb = PageRequest.of(pageNumber-1, 3, Sort.Direction.DESC,"createtime");
    	Page<chatModel> page = msgRepository.findAll(pgb);
    	return page;
    }
    
    @Transactional
    public chatModel updateById(Integer id, String newMsg,Integer newCid,Integer newItr) {
    	Optional<chatModel> option = msgRepository.findById(id);
    	
    	if(option.isPresent()) {
    		chatModel msg = option.get();
    		msg.setContent(newMsg);
    		msg.setChatroomid(newCid);
    		msg.setInitiator(newItr);
    		return msg;
    	}
    	return null;
    }
    public chatModel getLatest() {
    	return msgRepository.findFirstByOrderByCreatetimeDesc();
    }
    
}
