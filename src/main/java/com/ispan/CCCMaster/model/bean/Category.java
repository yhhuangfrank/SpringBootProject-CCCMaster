package com.ispan.CCCMaster.model.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name", columnDefinition = "nvarchar(50)", nullable = false)
    String name;

    @Column(name = "created_at", columnDefinition = "datetime", nullable = false)
    Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
