package com.ispan.CCCMaster.model.bean.Forum;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "response")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_id")
    private Integer responseId;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_Response_customer"))
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Column(name = "response_content", columnDefinition = "nvarchar(200)", nullable = true)
    private String responseContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "added", columnDefinition = "datetime")
    private Date added;

    @PrePersist
    public void onCreate() {
        if(added == null) {
            added = new Date();
        }
    }


    public Response() {
    }

    public Integer getResponseId() {
        return responseId;
    }

    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
    }



    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }


}
