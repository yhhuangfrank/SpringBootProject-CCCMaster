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
    @Column(name = "advertiseId")
    private Integer advertiseId;

    @Column(name = "clickCount")
    private Integer clickCount;

    @Column(name = "image", columnDefinition = "nvarchar(200)", nullable = true)
    private String image;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "startTime", columnDefinition = "datetime")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "endTime", columnDefinition = "datetime")
    private Date endTime;

    public Advertise() {
    }

    public Integer getAdvertise_id() {
        return advertiseId;
    }

    public void setAdvertise_id(Integer advertise_id) {
        this.advertiseId = advertise_id;
    }

    public Integer getClick_count() {
        return clickCount;
    }

    public void setClick_count(Integer click_count) {
        this.clickCount = click_count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getStart_time() {
        return startTime;
    }

    public void setStart_time(Date start_time) {
        this.startTime = start_time;
    }

    public Date getEnd_time() {
        return endTime;
    }

    public void setEnd_time(Date end_time) {
        this.endTime = end_time;
    }
}
