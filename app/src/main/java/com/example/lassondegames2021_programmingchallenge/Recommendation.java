package com.example.lassondegames2021_programmingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Recommendation extends AppCompatActivity {
    int eval = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            eval = extras.getInt("eval_score");
        }

        LinearLayout ll = (LinearLayout) findViewById(R.id.lRecomm);
        ll.addView(recommendations(eval));

    }

    public TextView recommendations(int eval){
        TextView tv = new TextView(this);
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(18f);
        tv.setText("hello");


        return tv;
    }
}