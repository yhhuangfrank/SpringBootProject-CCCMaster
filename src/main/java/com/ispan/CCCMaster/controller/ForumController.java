package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.Forum;
import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import com.ispan.CCCMaster.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForumController {

    @Autowired
    private ForumService fService;

    @GetMapping("/Forums/createform") //新增討論版
    public String addForum(Model model, ModelAndView modelAndView){
        model.addAttribute("forum", new Forum());

        Forum latest = fService.getLatest();
        model.addAttribute("latest", latest);
        return "back/Forum-create";
    }


    @PostMapping("/Forums/create") //送出新增討論版
    public String createForum(@ModelAttribute("forum") Forum forum, Model model){
        fService.creatForum(forum);

        model.addAttribute("forum", new Forum());

        Forum latest = fService.getLatest();
        model.addAttribute("latest", latest);

        return "back/Forum-create";

    }


    @GetMapping("back/Forum-create") //顯示所有討論版
    public String showAllForum(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
        Page<Forum> page = fService.findByPage(pageNumber);
        return "back/showForum";
    }



}
