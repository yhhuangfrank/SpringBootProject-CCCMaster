package com.ispan.CCCMaster.model.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Integer article_id;

    @Column(name = "forum_id")
    private Integer forum_id;


    @Column(name = "title", columnDefinition = "nvarchar(200)", nullable = true)
    private String title;

    @Column(name = "customer_id")
    private Integer customer_id;

    @Column(name = "content", columnDefinition = "nvarchar(200)", nullable = true)
    private String content;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "created_at", columnDefinition = "datetime")
    private Date created_at;

    @Column(name = "like")
    private Integer like;

    public void onCreated() {
        if(created_at == null) {
            created_at = new Date();
        }
    }

    @Column(name = "response_count")
    private Integer response_count;


    public Article() {
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Integer getForum_id() {
        return forum_id;
    }

    public void setForum_id(Integer forum_id) {
        this.forum_id = forum_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getResponse_count() {
        return response_count;
    }

    public void setResponse_count(Integer response_count) {
        this.response_count = response_count;
    }
}
