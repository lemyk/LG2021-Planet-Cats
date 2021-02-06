package com.example.lassondegames2021_programmingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.example.server_side.User_profile;

public class index_page extends AppCompatActivity {
    User_Profile_Activity uP;
    Main_Server_Activity ms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_page);

    }

    public void sTracker(View v){
        Intent intent = new Intent(this, symptom_tracker.class);
        Bundle bun = getIntent().getExtras();
        if(bun != null){
            uP = (User_Profile_Activity) bun.getParcelable("uProf");
            ms = (Main_Server_Activity) bun.getParcelable("mServer");
        }
        intent.putExtra("uProf", (Parcelable) uP);
        intent.putExtra("mServer", (Parcelable) ms);
        startActivity(intent);
    }
}