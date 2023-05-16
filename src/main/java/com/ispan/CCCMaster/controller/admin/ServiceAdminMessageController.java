package com.ispan.CCCMaster.controller.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.service.MessageModel;
import com.ispan.CCCMaster.model.bean.service.UserStorage;
import com.ispan.CCCMaster.service.ServiceFromService;

@RestController
public class ServiceAdminMessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private  ServiceFromService serviceFromService;
    
    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageModel message) {
        System.out.println("handling send message: " + message + " to: " + to);
        boolean isExists = UserStorage.getInstance().getUsers().contains(to);
        if (isExists) {
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<Customer> searchCustomer(@RequestParam("customerId") Integer customerId) {
        Customer customer = serviceFromService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }
}
