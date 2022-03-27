package com.example.dogbreed.model;

import com.google.gson.annotations.SerializedName;

public class DogBreed {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("temperament")
    private String temperament;
    @SerializedName("url")
    private String url;

    public DogBreed(int id, String name, String temperament, String url) {
        this.id = id;
        this.name = name;
        this.temperament = temperament;
        this.url = url;
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

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
