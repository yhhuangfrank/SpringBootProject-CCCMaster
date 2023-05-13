//package com.ispan.CCCMaster.controller.admin;
//import java.util.Date;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.DestinationVariable;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ispan.CCCMaster.model.bean.service.ChatroomModel;
//import com.ispan.CCCMaster.model.bean.service.MessageModel;
//import com.ispan.CCCMaster.model.dao.ChatroomRepository;
//@RestController
//public class ServiceAdminMessageController {
//
//    @Autowired
//    private SimpMessagingTemplate simpMessagingTemplate;
//
//    @Autowired
//    private ChatroomRepository chatroomRepository;
//
//    @MessageMapping("/chat/{chatroomId}")
//    public void sendMessage(@DestinationVariable Integer chatroomId, MessageModel message) {
//        System.out.println("handling send message: " + message + " to chatroom: " + chatroomId);
//
//        Optional<ChatroomModel> optionalChatroom = chatroomRepository.findById(chatroomId);
//        if (optionalChatroom.isPresent()) {
//            ChatroomModel chatroom = optionalChatroom.get();
//            message.setChatroom(chatroom);
//            message.setCreatetime(new Date());
//            chatroom.getMessages().add(message);
//            chatroomRepository.save(chatroom);
//
//            simpMessagingTemplate.convertAndSend("/topic/chat/" + chatroomId, message);
//        }
//    }
//}