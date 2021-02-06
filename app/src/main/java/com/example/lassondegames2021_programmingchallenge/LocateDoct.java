package com.example.lassondegames2021_programmingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.server_side.My_server;
import com.example.server_side.User_profile;
import com.example.server_side.WhiteBox;

public class LocateDoct extends AppCompatActivity {
    User_profile uP;
    My_server ms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locate_doct);

        Bundle bun = getIntent().getExtras();
        if(bun != null){
            uP = (User_profile) bun.getParcelable("uProf");
            ms = (My_server) bun.getParcelable("mServer");
        }
        
    }
}