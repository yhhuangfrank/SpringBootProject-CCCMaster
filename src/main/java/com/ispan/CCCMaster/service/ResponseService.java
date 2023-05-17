package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.Forum.Article;
import com.ispan.CCCMaster.model.bean.Forum.Response;
import com.ispan.CCCMaster.model.dto.ResponseQueryParams;
import com.ispan.CCCMaster.model.dto.ResponseRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

public interface ResponseService {

    //創立回覆
    void createResponse(Response response);

    Response createResponseFont(Integer id, ResponseRequest responseRequest);

    //找尋所有回覆
    List<Response> findAllResponses();

    Page<Response> getAllResponses(ResponseQueryParams params);

    Page<Response> findResponseByArticleId(Integer articleId,Integer pageNumber);

    //依照回覆編號找尋回覆
    Response findResponseById(Integer id);

    //刪除回覆
    void deleteResponseById(Integer id);

    //更改回覆資料
    @Transactional
    void updateById(Response input) throws IOException;

    Response updateResponseFont(Integer id);

    Response getLatest();


    Page<Response> findByPage(Integer pageNumber);
}
