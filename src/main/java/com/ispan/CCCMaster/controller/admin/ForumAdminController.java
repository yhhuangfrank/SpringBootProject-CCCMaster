package com.ispan.CCCMaster.controller.admin;

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
public class ForumAdminController {

    @Autowired
    private ForumServiceImpl fService;

    @GetMapping("/admin/forums/createform") //新增討論版
    public String addForum(Model model, ModelAndView modelAndView) {//新增討論版
        model.addAttribute("forum", new Forum());//新增討論版

        Forum latest = fService.getLatest();//新增討論版
        model.addAttribute("latest", latest);
        return "back/forum/forum-create";
    }


    @PostMapping("/admin/forums/create") //送出新增討論版
    public String createForum(@ModelAttribute("forum") Forum forum, Model model) throws IOException {
            forum.setImage(forum.getImageFile().getBytes());//把圖片轉成byte[]
            fService.creatForum(forum);//把圖片存到資料庫
        return "redirect:/forums/showAllForum";

    }

    @GetMapping("/admin/forums/showAllForum") //顯示所有討論版
    public String showAllForum(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
        Page<Forum> page = fService.findByPage(pageNumber);
        model.addAttribute("page", page);
        Forum latest = fService.getLatest();
        model.addAttribute("latest", latest);
        return "back/forum/showForum";
    }


    @GetMapping("/admin/forum/editPage") //編輯討論版
    public String editPage(@RequestParam("id") Integer forumId, Model model) {//編輯討論版

        model.addAttribute("forum", fService.findForumById(forumId));//編輯討論版
        return "back/forum/editForum";
    }

    @PutMapping("/admin/forum/edit")
    public String putEditedForum(@ModelAttribute("forum") Forum forum) throws IOException {
        forum.setImage(forum.getImageFile().getBytes());

        fService.updateById(forum);

        return "redirect:/forums/showAllForum";

    }

    @GetMapping(value = "/admin/forums/showAllForum/{forumId}") //顯示討論版圖片
    public ResponseEntity<byte[]> getImage(@PathVariable("forumId") Integer forumId) {
        byte[] image = fService.getForumImageById(forumId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }


    @DeleteMapping("/admin/forums/delete") //刪除討論版
    public String deleteForum(@RequestParam("id") Integer id) {
        fService.deleteForumById(id);

        return "redirect:/forums/showAllForum";
    }


}
