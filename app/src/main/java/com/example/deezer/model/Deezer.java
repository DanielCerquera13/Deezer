package com.example.deezer.model;

public class Deezer {

    private Data[] data;


    public Deezer(Data[] data) {
        this.data = data;
    }

    public Deezer() {
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
}
