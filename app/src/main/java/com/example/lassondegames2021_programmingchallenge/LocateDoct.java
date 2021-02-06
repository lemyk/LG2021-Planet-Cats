package com.example.lassondegames2021_programmingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.server_side.My_server;
import com.example.server_side.Tuple;
import com.example.server_side.User_profile;
import com.example.server_side.WhiteBox;

import java.util.ArrayList;

public class LocateDoct extends AppCompatActivity {
    User_Profile_Activity uP;
    Main_Server_Activity ms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locate_doct);

        Bundle bun = getIntent().getExtras();
        if(bun != null){
            uP = (User_Profile_Activity) bun.getParcelable("uProf");
            ms = (Main_Server_Activity) bun.getParcelable("mServer");
        }
        TextView tv = new TextView(this);
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(18f);

        String my_loc = "Your current location is: [" + uP.getuProf().getLoc().toString() + "]\n\n";
        Tuple earliest = ms.getMs().estimateArrival();
        String earliestString = "A Doctor-On-The-Go-Vehicle (id" + earliest.y + ") is currently " + 10 + " km from your location.\nEstimated arrival time: " + (float)((int)earliest.x/60.0) + " minutes";

        String others = "Other Doctor-On-The-Go-Vehicle in your area: \n";

        tv.setText(earliestString);

        LinearLayout ll = (LinearLayout) findViewById(R.id.lGo);
        ll.addView(tv);
    }
}