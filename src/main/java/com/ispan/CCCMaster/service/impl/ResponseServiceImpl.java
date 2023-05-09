package com.ispan.CCCMaster.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.Forum.Response;
import com.ispan.CCCMaster.model.dao.ResponseDao;
import com.ispan.CCCMaster.service.ResponseService;

@Service
public class ResponseServiceImpl implements ResponseService {
   @Autowired
    private ResponseDao responseDao;

   @Override
   public void createResponse(Response response) {
      responseDao.save(response);
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

}
