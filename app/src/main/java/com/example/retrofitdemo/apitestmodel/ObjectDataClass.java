package com.example.retrofitdemo.apitestmodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Md Minhajul Islam on 10/6/2021.
 */
public class ObjectDataClass {
    @SerializedName("resource")
    private String continents;
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String countryName;
    @SerializedName("updated_at")
    private String time;

    public ObjectDataClass(String continents, String id, String countryName, String time) {
        this.continents = continents;
        this.id = id;
        this.countryName = countryName;
        this.time = time;
    }

    public String getContinents() {
        return continents;
    }

    public void setContinents(String continents) {
        this.continents = continents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
