package com.alian.learn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

@Entity
public class Alian {
    @jakarta.persistence.Id
    @GeneratedValue
    private Integer aid;
    private String name;
    private String tech;


    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Integer getAid() {
        return aid;
    }
}
