package com.example.deezer.model;

import java.io.Serializable;

public class Album implements Serializable {

    private long id;
    private String title;
    private String cover_big;


    public Album() {
    }

    public Album(Long id, String title,  String cover_big) {
        this.id = id;
        this.title = title;
        this.cover_big = cover_big;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover_big() {
        return cover_big;
    }

    public void setCover_big(String cover_big) {
        this.cover_big = cover_big;
    }
}
