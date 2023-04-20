package com.ispan.CCCMaster.model.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article_like")
public class ArticleLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "articleId")
    private Integer articleId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "forumId")
    private Integer forumId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Integer customerId;

    @Column(name = "like")
    private Integer like;

    @Column(name = "likeDate")
    private Date likeDate;

    public ArticleLike() {
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }
}
