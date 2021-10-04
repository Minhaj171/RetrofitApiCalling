package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.location.Address;
import android.os.Bundle;

import com.example.retrofitdemo.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Gson gson = new Gson();

       /* Addresss address = new Addresss("Bangladesh", "Dhaka");

        List<FamilyMember> memberList = new ArrayList<>();
        memberList.add(new FamilyMember( "Husband", 30));
        memberList.add(new FamilyMember( "Mother", 60));
        memberList.add(new FamilyMember( "Father", 70));*/

//        Employee employee = new Employee("Minhaj", 25, "minhaj@gmail.com", address, memberList);
//        String json = gson.toJson(employee);

        String json = "{\"firstName\":\"Minhaj\",\"address\":{\"City\":\"Dhaka\",\"Country\":\"Bangladesh\"},\"age\":25,\"family\":[{\"age\":30,\"role\":\"Husband\"},{\"age\":60,\"role\":\"Mother\"},{\"age\":70,\"role\":\"Father\"}],\"mail\":\"minhaj@gmail.com\"}";
        Employee employee = gson.fromJson(json, Employee.class);
        mainBinding.setDemo(employee);

    }

}