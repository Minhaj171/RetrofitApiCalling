package com.example.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Md Minhajul Islam on 10/4/2021.
 */
public class Addresss {
    @SerializedName("Country")
    private String mCountry;
    @SerializedName("City")
    private String mCity;

    public Addresss(String mCountry, String mCity) {
        this.mCountry = mCountry;
        this.mCity = mCity;
    }
}
