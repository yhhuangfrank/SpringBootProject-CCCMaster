package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.Forum.Response;
import com.ispan.CCCMaster.model.bean.product.Comment;
import com.ispan.CCCMaster.model.dto.ResponseQueryParams;
import com.ispan.CCCMaster.model.dto.ResponseRequest;
import com.ispan.CCCMaster.service.ArticleService;
import com.ispan.CCCMaster.service.ResponseService;
import com.ispan.CCCMaster.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@Controller
public class ResponseController {
    @Service
    static class UserContextHelper {
        public Integer getUserId() {
            return 1;
        }
        public void setUserId() {

        }
    }

    @Autowired
    private ResponseService responseService;

    @Autowired
    private LoginUtil loginUtil;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserContextHelper userContextHelper;

    @GetMapping("/responses")
    public Page<Response> getResponses(
            @RequestParam(defaultValue = "added") String articleBy ,
            @RequestParam(defaultValue = "DESC") String sort,

            @RequestParam(defaultValue = "1") @Min(1) Integer page,
            @RequestParam(defaultValue = "3") @Min(0) Integer limit) {
        ResponseQueryParams queryParams = new ResponseQueryParams();
        queryParams.setPage(page);
        queryParams.setLimit(limit);
        queryParams.setArticleBy(articleBy);
        queryParams.setSort(sort);
        return responseService.getAllResponses(queryParams);


    }

    @ResponseBody
    @GetMapping("/article/{id}/response")//新增留言
    public Page<Response> getResponse(@PathVariable("id") Integer id,
                                      @RequestParam(defaultValue = "1") @Min(1) Integer page,
                                      @RequestParam(defaultValue = "3") Integer limit) {
        ResponseQueryParams params = new ResponseQueryParams();
        params.setArticleId(id);
        params.setPage(page);
        params.setLimit(limit);
        return responseService.getAllResponses(params);
    }

    @ResponseBody
    @PostMapping("/article/{id}/response")//新增留言
    public Response createResponse(HttpSession session,
                                   @PathVariable Integer id,
                                   @RequestBody @Valid ResponseRequest responseRequest) {

        loginUtil.getLoginCustomerIdOptional(session)
                .orElseThrow(() -> new RuntimeException("尚未登入"));

        return responseService.createResponseFont(id, responseRequest);
    }







}
