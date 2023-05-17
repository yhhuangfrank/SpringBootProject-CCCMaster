package com.ispan.CCCMaster.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ispan.CCCMaster.model.bean.Forum.Article;
import com.ispan.CCCMaster.model.bean.Forum.Response;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.dao.ArticleDao;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.model.dao.ResponseDao;
import com.ispan.CCCMaster.model.dto.ResponseQueryParams;
import com.ispan.CCCMaster.model.dto.ResponseRequest;
import com.ispan.CCCMaster.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ResponseDao responseDao;

    @Autowired
    private final CustomerDao customerDao;

    public ResponseServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public void createResponse(Response response) {
        responseDao.save(response);
    }

    @Override
    public Response createResponseFont(Integer id, ResponseRequest responseRequest) {
        Article foundArticle = articleDao.findById(id).orElseThrow(() -> new RuntimeException("沒有找到回覆"));
        Customer foundCustomer = customerDao.findById(responseRequest.getCustomerId()).orElseThrow(() ->
                new RuntimeException("沒有找到客戶"));

        System.out.println("============");
        System.out.println("============");
        System.out.println("============");
        System.out.println("find article: " + foundArticle.getArticleId());
        System.out.println("============");
        System.out.println("============");
        System.out.println("============");

        Response response = new Response();
        response.setResponseContent(responseRequest.getComment());
        response.setCustomer(foundCustomer);
        response.setArticle(foundArticle);
        return responseDao.save(response);
    }



    @Override
   public Response findResponseById(Integer id) {
       Optional<Response> option = responseDao.findById(id);
       if(option.isPresent()) {//如果有值
           return option.get();//返回值
       }
       throw new RuntimeException("沒有找到回覆");
   }

   @Override
   public List<Response> findAllResponses() {
       return responseDao.findAll();
   }

   @Override
   public void deleteResponseById(Integer id) {
       responseDao.deleteById(id);
   }


   @Override
   public Response getLatest() {
      return responseDao.findFirstByOrderByAddedDesc();
   }

   @Override
   @Transactional
   public void updateById(Response input) {
       Optional<Response> option = responseDao.findById(input.getResponseId());
       if (option.isPresent()) { //如果有找到資料就執行
           Response oldresponse = option.get();
               oldresponse.setResponseContent(input.getResponseContent());//把新的資料放進去
               responseDao.save(oldresponse);//存到資料庫
           } else {
               throw new RuntimeException("沒有找到回覆");
           }
       }

    @Override
    public Response updateResponseFont(Integer id) {
        return null;
    }

    public Page<Response> findByPage(Integer pageNumber){
        Pageable pgb = PageRequest.of(pageNumber-1, 3, Sort.Direction.DESC, "added");
        Page<Response> page = responseDao.findAll(pgb);
        return page;
    }

    @Override
    public Page<Response> getAllResponses(ResponseQueryParams params) {
        Integer id = params.getArticleId();
        Integer page = params.getPage();
        Integer limit = params.getLimit();
        Article foundArticle = articleDao.findById(id).orElseThrow(() -> new RuntimeException("沒有找到文章"));

        Pageable pgb = PageRequest.of(page - 1, limit, Sort.Direction.DESC, "added");
        Page<Response> allByArticleId = responseDao.findAllByArticleId(foundArticle.getArticleId(), pgb);
        try {
            System.out.println(new ObjectMapper().writeValueAsString(allByArticleId));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return allByArticleId;
    }

    public Page<Response> findResponseByArticleId(Integer articleId,Integer pageNumber){
        Sort sort = Sort.by(Sort.Direction.DESC, "added");
        Pageable pgb = PageRequest.of(pageNumber-1, 3, Sort.Direction.DESC, "added");
        Page<Response> page = responseDao.findAllByArticleId(articleId,pgb);
        return page;
    }





}
