package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.Forum;
import com.ispan.CCCMaster.model.dao.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;

@Service
public class ForumService {

    @Autowired
    private ForumRepository forumRepository;

    public void creatForum(Forum forum){
        forumRepository.save(forum);
    }



}
