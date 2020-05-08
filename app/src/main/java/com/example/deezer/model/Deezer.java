package com.example.deezer.model;

import java.io.Serializable;

public class Deezer implements Serializable {

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
