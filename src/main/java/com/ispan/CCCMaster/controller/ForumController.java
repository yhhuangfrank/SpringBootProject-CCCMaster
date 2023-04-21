package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.Forum;
import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import com.ispan.CCCMaster.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ForumController {

    @Autowired
    private ForumService fService;

    @GetMapping("/Forums/createform")
    public String getCreateForumForm(Model model) {
        model.addAttribute("forum", new Forum());
        return "back/Forum-create";
    }

    @PostMapping("/Forums/create")
    public String createForum(@ModelAttribute("forum") Forum forum)  {
        fService.creatForum(forum);
        return "back/back-test";
    }



}
