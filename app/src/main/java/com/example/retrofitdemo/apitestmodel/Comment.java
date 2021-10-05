package com.example.retrofitdemo.apitestmodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Md Minhajul Islam on 10/5/2021.
 */
public class Comment {
    private int postId;
    private int id;
    private String name;
    private String email;
    @SerializedName("body")
    private String text;

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return text;
    }
}
