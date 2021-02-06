package com.example.lassondegames2021_programmingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.server_side.User_profile;

public class index_page extends AppCompatActivity {
    User_profile up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_page);

    }

    public void sTracker(View v){
        Intent intent = new Intent(this, symptom_tracker.class);
        startActivity(intent);
    }
}