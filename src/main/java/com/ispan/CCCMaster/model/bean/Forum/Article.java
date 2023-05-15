package com.ispan.CCCMaster.model.bean.Forum;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Integer articleId;

//    @Column(name = "forum_id")
//    private Integer forumId;


    @Column(name = "title", columnDefinition = "nvarchar(200)", nullable = true)
    private String title;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "content", columnDefinition = "nvarchar(MAX)", nullable = true)
    private String content;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "added", columnDefinition = "datetime")
    private Date added;

    @Column(name = "like_count")
    private Integer likeCount;

    @PrePersist
    public void onCreate() {
        if(added == null) {
            added = new Date();
        }
    }

    @Column(name = "response_count")
    private Integer responseCount;

    @Lob
    @Column(name = "image", columnDefinition = "varbinary(max)")
    private byte[] image;
    @Transient
    private MultipartFile imageFile;

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public byte[] getImage() {
        return image;
    }


    public Article() {
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

//    public Integer getForumId() {
//        return forumId;
//    }
//
//    public void setForumId(Integer forumId) {
//        this.forumId = forumId;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return added;
    }

    public void setCreatedAt(Date createdAt) {
        this.added = createdAt;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getResponseCount() {
        return responseCount;
    }

    public void setResponseCount(Integer responseCount) {
        this.responseCount = responseCount;
    }


}

