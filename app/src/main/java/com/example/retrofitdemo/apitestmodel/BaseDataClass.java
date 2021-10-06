package com.example.retrofitdemo.apitestmodel;

import java.util.List;

/**
 * Created by Md Minhajul Islam on 10/6/2021.
 */
public class BaseDataClass {
    private List<ObjectDataClass> data;

    public BaseDataClass(List<ObjectDataClass> data) {
        this.data = data;
    }

    public List<ObjectDataClass> getData() {
        return data;
    }

    public void setData(List<ObjectDataClass> data) {
        this.data = data;
    }
}
