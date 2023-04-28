package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.Forum;
import com.ispan.CCCMaster.service.ForumService;
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
    private ForumService fService;

    @GetMapping("/Forums/createform") //新增討論版
    public String addForum(Model model, ModelAndView modelAndView){
        model.addAttribute("forum", new Forum());

        Forum latest = fService.getLatest();
        model.addAttribute("latest", latest);
        return "back/Forum-create";
    }



//    @PostMapping("/Forums/create") //送出新增討論版
//    public String createForum(@ModelAttribute("forum") Forum forum, Model model){
//        fService.creatForum(forum);
//
//
//        model.addAttribute("forum", new Forum());
//
//        Forum latest = fService.getLatest();
//        model.addAttribute("latest", latest);
//
//        return "redirect:/Forums/showAllForum";
//
//    }

    @PostMapping("/Forums/create") //送出新增討論版
    public String createForum(@ModelAttribute("forum") Forum forum) {
        try {
            forum.setImage(forum.getImageFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        fService.creatForum(forum);
        return "redirect:/Forums/showAllForum";
    }





    @GetMapping("/Forums/showAllForum") //顯示所有討論版
    public String showAllForum(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
        Page<Forum> page = fService.findByPage(pageNumber);
        model.addAttribute("page", page);
        Forum latest = fService.getLatest();
        model.addAttribute("latest", latest);
        return "back/showForum";
    }



    @GetMapping("/Forum/editPage") //編輯討論版
    public String editPage(@RequestParam("id") Integer forumId, Model model) {
        Forum forum = fService.findForumById(forumId);
        model.addAttribute("forum", forum);
        return "back/editForum";
    }

    @PutMapping("/Forum/edit")
    public String putEditedForum(@ModelAttribute("forum") Forum forum) {
//        fService.updateById(forum.getForumId(),forum.getForumName());
        try{
            fService.updateById(forum);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/Forums/showAllForum";

    }

    @GetMapping(value = "/Forums/showAllForum/{forumId}") //顯示討論版圖片
    public ResponseEntity<byte[]> getImage(@PathVariable("forumId") Integer forumId) {
        byte[] image = fService.getForumImageById(forumId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }






    @DeleteMapping("/Forums/delete") //刪除討論版
   public String deleteForum(@RequestParam("id") Integer id) {
        fService.deleteForumById(id);

        return "redirect:/Forums/showAllForum";
    }



}
