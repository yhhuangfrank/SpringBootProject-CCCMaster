package com.ispan.CCCMaster.service;

import java.io.IOException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.Forum.Response;

public interface ResponseService {

    //創立回覆
    void createResponse(Response response);

    //找尋所有回覆
    List<Response> findAllResponses();

    //依照回覆編號找尋回覆
    Response findResponseById(Integer id);

    //刪除回覆
    void deleteResponseById(Integer id);

    //更改回覆資料
    @Transactional
    void updateById(Response input) throws IOException;

    Response getLatest();
}
