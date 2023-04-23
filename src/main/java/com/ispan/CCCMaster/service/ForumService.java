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



    @Transactional
  public Forum updateById(Integer forumId, String newForum) { //update forum
        Optional<Forum> option = forumRepository.findById(forumId);

        if(option.isPresent()) {
            Forum forum = option.get();
            forum.setForumName(newForum);
            return forum;
        }
        return null;
    }





    public Forum getLatest() { //get latest forum

        return forumRepository.findFirstByOrderByAddedDesc();
    }


}
