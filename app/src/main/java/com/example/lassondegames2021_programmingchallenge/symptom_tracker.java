package com.example.lassondegames2021_programmingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class symptom_tracker extends AppCompatActivity {
    int evaluation_point = 0;
    boolean aP_symp = false;
    boolean br_symp = false;
    boolean dz_symp = false;
    boolean c_symp = false;
    boolean bl_symp = false;
    boolean hch_symp = false;
    boolean v_symp = false;
    boolean cP_symp = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_tracker);
    }

    public void abdominalPain(View v){
        Button aP = (Button)v.findViewById(R.id.bAbdominalPain);
        if(!aP_symp){
            aP.setBackgroundColor(Color.rgb(0,150,136));
            evaluation_point += 5;
            aP_symp = true;
        }
        else{
            aP.setBackgroundColor(Color.rgb(103,58,183));
            evaluation_point -= 5;
            aP_symp = false;
        }
    }

    public void breathingProblem(View v){
        Button aP = (Button)v.findViewById(R.id.bBreath);
        if(!br_symp){
            aP.setBackgroundColor(Color.rgb(0,150,136));
            evaluation_point += 5;
            br_symp = true;
        }
        else{
            aP.setBackgroundColor(Color.rgb(103,58,183));
            evaluation_point -= 5;
            br_symp = false;
        }
    }

    public void Dizzy(View v){
        Button aP = (Button)v.findViewById(R.id.bDizzy);
        if(!dz_symp){
            aP.setBackgroundColor(Color.rgb(0,150,136));
            evaluation_point += 2;
            dz_symp = true;
        }
        else{
            aP.setBackgroundColor(Color.rgb(103,58,183));
            evaluation_point -= 2;
            dz_symp = false;
        }
    }
    public void coughing(View v){
        Button aP = (Button)v.findViewById(R.id.bCough);
        if(!c_symp){
            aP.setBackgroundColor(Color.rgb(0,150,136));
            evaluation_point += 3;
            c_symp = true;
        }
        else{
            aP.setBackgroundColor(Color.rgb(103,58,183));
            evaluation_point -= 3;
            c_symp = false;
        }
    }

    public void bleeding(View v){
        Button aP = (Button)v.findViewById(R.id.bBleeding);
        if(!bl_symp){
            aP.setBackgroundColor(Color.rgb(0,150,136));
            evaluation_point += 5;
            bl_symp = true;
        }
        else{
            aP.setBackgroundColor(Color.rgb(103,58,183));
            evaluation_point -= 5;
            bl_symp = false;
        }
    }

    public void headache(View v){
        Button aP = (Button)v.findViewById(R.id.bHeadache);
        if(!hch_symp){
            aP.setBackgroundColor(Color.rgb(0,150,136));
            evaluation_point += 3;
            hch_symp = true;
        }
        else{
            aP.setBackgroundColor(Color.rgb(103,58,183));
            evaluation_point -= 3;
            hch_symp = false;
        }
    }

    public void vomit(View v){
        Button aP = (Button)v.findViewById(R.id.bVomitting);
        if(!v_symp){
            aP.setBackgroundColor(Color.rgb(0,150,136));
            evaluation_point += 5;
            v_symp = true;
        }
        else{
            aP.setBackgroundColor(Color.rgb(103,58,183));
            evaluation_point -= 5;
            v_symp = false;
        }
    }

    public void chestPain(View v){
        Button aP = (Button)v.findViewById(R.id.bChestPain);
        if(!cP_symp){
            aP.setBackgroundColor(Color.rgb(0,150,136));
            evaluation_point += 4;
            cP_symp = true;
        }
        else{
            aP.setBackgroundColor(Color.rgb(103,58,183));
            evaluation_point -= 4;
            cP_symp = false;
        }
    }

    public void submit(View v){
        Intent intent = new Intent(this, index_page.class);
        startActivity(intent);
    }
}