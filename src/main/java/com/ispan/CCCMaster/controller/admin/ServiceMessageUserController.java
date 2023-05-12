package com.ispan.CCCMaster.controller.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.service.ChatroomModel;
import com.ispan.CCCMaster.model.dao.ChatroomRepository;
@RestController
@CrossOrigin
public class ServiceMessageUserController {

    @Autowired
    private ChatroomRepository chatroomRepository;

    @GetMapping("/registration/{userName}")
    public ResponseEntity<ChatroomModel> register(@PathVariable Integer userName) {
        System.out.println("handling register user request: " + userName);
        try {
            Customer customer = new Customer();
            customer.setCustomerId(userName);

            ChatroomModel chatroom = new ChatroomModel();
            chatroom.setCustomer(customer);
            chatroom.setCreate_time(new Date());

            chatroomRepository.save(chatroom);

            return ResponseEntity.ok().body(chatroom);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/fetchAllUsers")
    public List<ChatroomModel> fetchAll() {
        return chatroomRepository.findAll();
    }

}