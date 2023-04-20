package com.ispan.CCCMaster.model.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "advertise")
public class Advertise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertise_id")
    private Integer advertise_id;

    @Column(name = "click_count")
    private Integer click_count;

    @Column(name = "image", columnDefinition = "nvarchar(200)", nullable = true)
    private String image;

    @Column(name = "navigate_url", columnDefinition = "nvarchar(200)", nullable = true)
    private String navigate_url;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "start_time", columnDefinition = "datetime")
    private Date start_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "end_time", columnDefinition = "datetime")
    private Date end_time;

    public Advertise() {
    }

    public Integer getAdvertise_id() {
        return advertise_id;
    }

    public void setAdvertise_id(Integer advertise_id) {
        this.advertise_id = advertise_id;
    }

    public Integer getClick_count() {
        return click_count;
    }

    public void setClick_count(Integer click_count) {
        this.click_count = click_count;
    }

    public String getNavigate_url() {
        return navigate_url;
    }

    public void setNavigate_url(String navigate_url) {
        this.navigate_url = navigate_url;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }




}
