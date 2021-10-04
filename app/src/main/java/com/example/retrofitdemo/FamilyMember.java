package com.example.retrofitdemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Md Minhajul Islam on 10/4/2021.
 */
public class FamilyMember {
    @SerializedName("role")
    private String mRole;
    @SerializedName("age")
    int mAge;

    public FamilyMember(String mRole, int mAge) {
        this.mRole = mRole;
        this.mAge = mAge;
    }
}
