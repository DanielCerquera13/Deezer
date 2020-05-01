package com.example.deezer.model;

public class User {

    private int id;
    private String name;
    private String tracklist;
    private String type;


    public User(int id, String name, String tracklist, String type) {
        this.id = id;
        this.name = name;
        this.tracklist = tracklist;
        this.type = type;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
