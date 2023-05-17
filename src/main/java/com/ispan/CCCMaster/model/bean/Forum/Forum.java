package com.ispan.CCCMaster.model.bean.Forum;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ispan.CCCMaster.model.bean.product.Product;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "forum")
public class Forum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "forum_id")
    private Integer forumId;

    @Column(name = "forum_name", columnDefinition = "nvarchar(200)", nullable = true)
    private String forumName;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "start_date", columnDefinition = "datetime")
    private Date added;

    @Lob
    @Column(name = "image", columnDefinition = "varbinary(max)")
    private byte[] image;

    @Transient
    private MultipartFile imageFile;


    @OneToMany(cascade = CascadeType.PERSIST,orphanRemoval = true)
    @JoinColumn(name = "fk_forum_id", referencedColumnName = "forum_id")
    private Set<Article> articles = new LinkedHashSet<>();

    public byte[] getImage() {
        return image;
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

    @PrePersist
    public void  onCreate() {
        if(added == null) {
            added = new Date();
        }
    }


    public Forum() {
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
