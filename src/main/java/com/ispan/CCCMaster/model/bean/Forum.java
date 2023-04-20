package com.ispan.CCCMaster.model.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "forumId")
    private Integer forumId;

    @Column(name = "forumName", columnDefinition = "nvarchar(200)", nullable = true)
    private String forumName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "startDate", columnDefinition = "datetime")
    private Date startDate;

    public void  onCreate() {
        if(startDate == null) {
            startDate = new Date();
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
