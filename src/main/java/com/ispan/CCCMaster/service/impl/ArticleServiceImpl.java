package com.ispan.CCCMaster.service.impl;

import com.ispan.CCCMaster.model.bean.Forum.Article;
import com.ispan.CCCMaster.model.dao.ArticleDao;
import com.ispan.CCCMaster.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service//告訴spring這是一個bean
public class ArticleServiceImpl implements ArticleService {

    @Autowired//自動注入
    private ArticleDao articleDao;

    @Override
    public void createArticle(Article article) { //create article
        articleDao.save(article);
    }

    @Override
    public Article findArticleById(Integer id) { //get article by id
        Optional<Article> option = articleDao.findById(id);//Optional是一個容器對象，它包含了我們需要的對象，使用isPresent()方法來檢測容器內是否包含了對象
        if(option.isPresent()) {//如果有值
            return option.get();//返回值
        }
        throw new RuntimeException("沒有找到文章");//如果沒有值
    }

    @Override
    public void deleteArticleById(Integer id) { //delete article
        articleDao.deleteById(id);
    }

    public Page<Article> findByPage(Integer pageNumber) { //get article by page
        Pageable pgb = PageRequest.of(pageNumber - 1, 3, Sort.Direction.DESC, "added");
        Page<Article> page = articleDao.findAll(pgb);
        return page;
    }

    @Override
    @Transactional
    public void updateById(Article input) { //update article
        if (input.getTitle() != null && input.getTitle().length()>0 && input.getTitle().contains("習近平")) {
            throw new IllegalArgumentException("標題不合法");//contains()方法用於檢測字符串中是否包含子字符串或字符序列
        }
        Optional<Article> option = articleDao.findById(input.getArticleId());
            if (option.isPresent()) { //如果有找到資料就執行
            Article oldarticle = option.get();
                oldarticle.setTitle(input.getTitle());//把新的資料放進去
                oldarticle.setContent(input.getContent());//把新的資料放進去
                oldarticle.setImage(input.getImage());//把新的資料放進去
                articleDao.save(oldarticle);//存到資料庫
            } else {
                throw new RuntimeException("找不到資料");//如果沒有找到資料就報錯
//                throw new IllegalArgumentException("找不到資料");//如果傳輸的參數不合法就報錯
            }




        }


    @Override
    public byte[] getArticleImageById(Integer articleId) {
        Optional<Article> option = articleDao.findById(articleId);
        if (option.isPresent()) {
            Article article = option.get();
            return article.getImage();
        }
        return null;
    }
    @Override
    public Article getLatest() { //get latest forum

        return articleDao.findFirstByOrderByAddedDesc();
    }




}
