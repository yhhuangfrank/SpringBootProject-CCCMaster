package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.Forum;
import com.ispan.CCCMaster.model.dao.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
        if (option.isEmpty()) {
            return null;
        }
        return option.get();
    }


    public Page<Forum> findByPage(Integer pageNumber) {
        Pageable pgb = PageRequest.of(pageNumber - 1, 3, Sort.Direction.DESC, "added");
        Page<Forum> page = forumRepository.findAll(pgb);
        return page;
    }

    public Forum getLatest() {
        return forumRepository.findFirstByOrderByAddedDesc();
    }
}
