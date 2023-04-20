package com.ispan.CCCMaster.model.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "response")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reponse_id")
    private Integer reponse_id;


    @Column(name = "customer_id")
    private Integer customer_id;

    @Column(name = "response_content", columnDefinition = "nvarchar(200)", nullable = true)
    private String response_content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "created_at", columnDefinition = "datetime")
    private Date created_at;



    @Column(name = "article_id")
    private Integer article_id;
    public Response() {
    }

    public Integer getReponse_id() {
        return reponse_id;
    }

    public void setReponse_id(Integer reponse_id) {
        this.reponse_id = reponse_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getResponse_content() {
        return response_content;
    }

    public void setResponse_content(String response_content) {
        this.response_content = response_content;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }
}
