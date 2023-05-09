package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.Forum.Forum;
import com.ispan.CCCMaster.service.impl.ForumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ForumController {

    @Autowired
    private ForumServiceImpl fService;


    @GetMapping("/forums/showAllForum") //顯示所有討論版
    public String showAllForum(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
        Page<Forum> page = fService.findByPage(pageNumber);
        model.addAttribute("page", page);
        Forum latest = fService.getLatest();
        model.addAttribute("latest", latest);
        return "front/forum/forum";
    }


    @GetMapping(value = "/forums/showAllForum/{forumId}") //顯示討論版圖片
    public ResponseEntity<byte[]> getImage(@PathVariable("forumId") Integer forumId) {
        byte[] image = fService.getForumImageById(forumId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }



}
