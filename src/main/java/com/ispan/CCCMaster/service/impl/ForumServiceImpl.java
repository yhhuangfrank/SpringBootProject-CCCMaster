package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.Forum;
import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import com.ispan.CCCMaster.model.dao.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.Normalizer;
import java.util.Optional;

@Service
public class ForumService {

    @Autowired
    private ForumRepository forumRepository;


    public void creatForum(Forum forum) {
        forumRepository.save(forum);
    }

    public Forum findForumById(Integer id) {
        Optional<Forum> option = forumRepository.findById(id);

        if(option.isEmpty()) {
            return null;
        }

        return option.get();
    }

    public void deleteForumById(Integer id) { //delete forum

        forumRepository.deleteById(id);
    }



    public Page<Forum> findByPage(Integer pageNumber) { //get forum by page
        Pageable pgb = PageRequest.of(pageNumber - 1, 3, Sort.Direction.DESC, "added");
        Page<Forum> page = forumRepository.findAll(pgb);
        return page;
    }

    public byte[] getForumImageById(Integer forumId) {
        Optional<Forum> option = forumRepository.findById(forumId);
        if (option.isPresent()) {
            Forum forum = option.get();
            return forum.getImage();
        } else return null;
    }




//    @Transactional
//    public Forum updateById(Integer forumId, String newForum) { //update forum
//        Optional<Forum> option = forumRepository.findById(forumId);
//
//        if(option.isPresent()) {
//            Forum forum = option.get();
//            forum.setForumName(newForum);
//            return forum;
//        }
//        return null;
//    }

    @Transactional
    public void updateById(Forum input) throws IOException {//update forum
        Optional<Forum> option = forumRepository.findById(input.getForumId());
        if (option.isPresent()) { //如果有找到資料就執行
            Forum forum = option.get();//把資料庫的資料存到forum
            forum.setForumName(input.getForumName());//把新的討論版名稱存到資料庫
            forum.setImage(input.getImage());
            forumRepository.save(forum);//存到資料庫
        } else {
            throw new RuntimeException("找不到資料");
        }

//                option.ifPresentOrElse(//如果有找到資料就執行
//                (existed) -> {//如果有找到資料就執行
//                    existed.setForumName(input.getForumName());//把新的討論版名稱存到資料庫
//                    existed.setImage(input.getImage());//把新的圖片存到資料庫
//
//                    forumRepository.save(existed);
//
//
//                },
//                () -> {//如果沒有找到資料就執行
//                    throw new RuntimeException("找不到資料");
//                }
//        );





    }




    public Forum getLatest() { //get latest forum

        return forumRepository.findFirstByOrderByAddedDesc();
    }


}
