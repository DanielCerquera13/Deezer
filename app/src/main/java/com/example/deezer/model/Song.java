package com.example.deezer.model;

import java.io.Serializable;

public class Song implements Serializable {

    private long id;
    private String title;
    private String link;
    private long duration;
    private Artist artist;
    private Album album;
    private String release_date;
    private String picture_big;


    public Song() {
    }

    public Song(long id, String title, String link, long duration, Artist artist, Album album, String release_date, String picture_big) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.duration = duration;
        this.artist = artist;
        this.album = album;
        this.release_date = release_date;
        this.picture_big = picture_big;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }


    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getPicture_big() {
        return picture_big;
    }
}
