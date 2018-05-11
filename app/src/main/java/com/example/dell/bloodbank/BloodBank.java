package com.example.dell.bloodbank;

import android.app.Application;

import com.firebase.client.Firebase;


public class BloodBank extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
