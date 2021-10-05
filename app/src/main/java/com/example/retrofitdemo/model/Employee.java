package com.example.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Md Minhajul Islam on 10/4/2021.
 */
public class Employee {
    @SerializedName("firstName")
    private String FirstName;
    private int age;
    private String mail;
    @SerializedName("address")
    private Addresss address;
    @SerializedName("family")
    private List<FamilyMember> mFamily;

    public Employee(String firstName, int age, String mail, Addresss address, List<FamilyMember> mFamily) {
        FirstName = firstName;
        this.age = age;
        this.mail = mail;
        this.address = address;
        this.mFamily = mFamily;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Addresss getAddress() {
        return address;
    }

    public void setAddress(Addresss address) {
        this.address = address;
    }

    public List<FamilyMember> getmFamily() {
        return mFamily;
    }

    public void setmFamily(List<FamilyMember> mFamily) {
        this.mFamily = mFamily;
    }
}
