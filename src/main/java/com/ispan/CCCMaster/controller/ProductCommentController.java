package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.product.Comment;
import com.ispan.CCCMaster.service.OrderService;
import com.ispan.CCCMaster.service.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductCommentController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductCommentService productCommentService;

    @GetMapping("/front/comment/create/form/{orderDetailId}")
    public String getCreateCommentForm(@PathVariable("orderDetailId") Integer orderDetailId, Model model) {
        Comment comment = new Comment();
        comment.setOrderDetail(orderService.findOrderDetailById(orderDetailId));
        model.addAttribute("comment", comment);
        return "/front/comment/commentForm";
    }

    @ResponseBody
    @GetMapping("/front/detail/comment")
    public Page<Comment> getProductComment(@RequestParam("productId") Integer productId, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNumber) {
        Page<Comment> page = productCommentService.findCommentByProductId(productId, pageNumber);
        return page;
    }
}
