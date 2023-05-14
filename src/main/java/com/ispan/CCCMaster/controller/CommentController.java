package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @GetMapping("/comment/check")
    public boolean checkCommentExist(@RequestParam(name = "orderDetailId") Integer orderDetailId) {
        System.out.println("checkOrderDetail");
        System.out.println(orderDetailId);
        return commentService.checkCommentExist(orderDetailId);
    }

    @ResponseBody
    @PostMapping("/comment/create")
    public boolean createComment(@RequestParam("orderDetailId")Integer orderDetailId,
                                 @RequestParam("content")String content,
                                 @RequestParam("rating")Integer rating){

        return commentService.createComment(orderDetailId,content,rating);
    }

    @ResponseBody
    @PutMapping("/comment/update")
    public boolean updateComment(@RequestParam("orderDetailId")Integer orderDetailId,
                                 @RequestParam("content")String content,
                                 @RequestParam("rating")Integer rating){
return commentService.updateComment(orderDetailId,content,rating);
    }
}
