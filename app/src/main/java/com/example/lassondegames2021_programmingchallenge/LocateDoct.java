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
        String earliestString = String.format("A Doctor-On-The-Go-Vehicle (id: %d) has been scheduled to arrive to your location.\nEstimated arrival time: %.2f minutes\n\n",
                earliest.y, (float)((int)earliest.x/60.0));

        String others = "Other Doctor-On-The-Go Vehicles in your area: \n";
        for(Tuple<Tuple<Integer, Integer>, Boolean> k : ms.getMs().getWhiteboxData()){
            others += String.format("- Doctor-On-The-Go Vehicle id: %d (%.2f km)\n", k.x.x,((float)(k.x.y/1000.0)));
            others += String.format("\tCurrent Status: %s\n\n", k.y?"Busy":"Free");
        }

        tv.setText(my_loc + earliestString + others);


        LinearLayout ll = (LinearLayout) findViewById(R.id.lGo);
        ll.addView(tv);
    }
}