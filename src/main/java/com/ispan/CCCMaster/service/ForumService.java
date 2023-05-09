package com.ispan.CCCMaster.service;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.Forum.Forum;

public interface ForumService {
    void creatForum(Forum forum);

    Forum findForumById(Integer id);

    void deleteForumById(Integer id);

    Page<Forum> findByPage(Integer pageNumber);

    byte[] getForumImageById(Integer forumId);

    @Transactional
    void updateById(Forum input) throws IOException;

    Forum getLatest();
}
