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
    @Column(name = "articleId")
    private Integer articleId;


    @Column(name = "articleTitle", columnDefinition = "nvarchar(200)", nullable = true)
    private String articleTitle;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Integer customerId;

    @Column(name = "articleContent", columnDefinition = "nvarchar(200)", nullable = true)
    private String articleContent;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "articleDate", columnDefinition = "datetime")
    private Date articleDate;

    public void onCreated() {
        if(articleDate == null) {
            articleDate = new Date();
        }
    }

    @Column(name = "reposeCount")
    private Integer reposeCount;


    public Article() {
    }


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }



    public Integer getReposeCount() {
        return reposeCount;
    }

    public void setReposeCount(Integer reposeCount) {
        this.reposeCount = reposeCount;
    }
}
