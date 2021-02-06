package com.example.lassondegames2021_programmingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;

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
            aP.setBackgroundColor(Color.rgb(255,110,64));
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
            aP.setBackgroundColor(Color.rgb(255,110,64));
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
            aP.setBackgroundColor(Color.rgb(255,215,64));
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
            aP.setBackgroundColor(Color.rgb(255,171,64));
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
            aP.setBackgroundColor(Color.rgb(255,110,64));
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
            aP.setBackgroundColor(Color.rgb(255,171,64));
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
            aP.setBackgroundColor(Color.rgb(255,110,64));
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
            aP.setBackgroundColor(Color.rgb(255,110,64));
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
        Intent intent3 = new Intent(this, Recommendation.class);
        //Intent intent2 = new Intent(Intent.ACTION_CALL);
        /*boolean aP_symp = false;
        boolean br_symp = false;
        boolean dz_symp = false;
        boolean c_symp = false;
        boolean bl_symp = false;
        boolean hch_symp = false;
        boolean v_symp = false;
        boolean cP_symp = false;*/
        if(evaluation_point >= 18){

        }
        else if(evaluation_point >= 12 && evaluation_point < 18){
            //intent2.setData(Uri.parse("tel:+14379707012"));
            Toast.makeText(symptom_tracker.this,
                    "You are being connected to our Doctors Hotline", Toast.LENGTH_LONG).show();
        }
        else{
            Symptoms s = new Symptoms();
            if(c_symp && dz_symp && !aP_symp && !br_symp && !bl_symp && !hch_symp && !v_symp && !cP_symp){
                s.setName("Common Cold/Allergy");
                s.setDesc("You are experiencing" + s.getName() + ". Nothing is serious, please follow our instructions.");
                s.setRecommendation("- Take 1 tablet of Advil with warm water\n- Take a nap");
            }
            else if(!c_symp && !dz_symp && aP_symp && !br_symp && !bl_symp && !hch_symp && v_symp && !cP_symp){
                s.setName("Diarrhea");
                s.setDesc("You are experiencing "+ s.getName() +". Nothing is serious, please follow our instructions.");
                s.setRecommendation("- Take 1 tablet of Immodium with warm water\n- Take a nap");
            }
            else {
                if(c_symp){
                    if(s.getName() == null){
                        s.setName("Coughing");
                    }
                    else{
                        s.setName(s.getName() + ", Coughing");
                    }
                    if(s.getRecommendation() == null){
                        s.setRecommendation("- Drink warm lemondade.\n");
                    }
                    else{
                        s.setRecommendation(s.getRecommendation() + "- Drink warm lemondade.\n");
                    }
                }
                if(dz_symp){
                    if(s.getName() == null){
                        s.setName("Dizziness");
                    }
                    else{
                        s.setName(s.getName() + ", Dizziness");
                    }
                    if(s.getRecommendation() == null){
                        s.setRecommendation("- Lie down and close your eyes for 15 minutes.\n");
                    }
                    else{
                        s.setRecommendation(s.getRecommendation() + "- Lie down and close your eyes for 15 minutes.\n");
                    }
                }
                if(aP_symp){
                    if(s.getName() == null){
                        s.setName("Stomachache");
                    }
                    else{
                        s.setName(s.getName() + ", Stomachache");
                    }
                    if(s.getRecommendation() == null){
                        s.setRecommendation("- Lie down and keep your stomach warm. Take pain reliever if possible.\n");
                    }
                    else{
                        s.setRecommendation(s.getRecommendation() + "- Lie down and keep your stomach warm. Take pain reliever if possible.\n");
                    }
                }
                if(br_symp){
                    if(s.getName() == null){
                        s.setName("Sinus");
                    }
                    else{
                        s.setName(s.getName() + ", Sinus");
                    }
                    if(s.getRecommendation() == null){
                        s.setRecommendation("- Drink plenty of water. Use a neti pot if possible.\n");
                    }
                    else{
                        s.setRecommendation(s.getRecommendation() + "- Drink plenty of water. Use a neti pot if possible.\n");
                    }
                }
                if(bl_symp){
                    if(s.getName() == null){
                        s.setName("Bleeding");
                    }
                    else{
                        s.setName(s.getName() + ", Bleeding");
                    }
                    if(s.getRecommendation() == null){
                        s.setRecommendation("- Apply bandage on the wound. If the bleeding is too much. Call 911.\n");
                    }
                    else{
                        s.setRecommendation(s.getRecommendation() + "- Apply bandage on the wound. If the bleeding is too much. Call 911.\n");
                    }
                }
                if(hch_symp){
                    if(s.getName() == null){
                        s.setName("Headache");
                    }
                    else{
                        s.setName(s.getName() + ", Headache");
                    }
                    if(s.getRecommendation() == null){
                        s.setRecommendation("- Take pain reliever and lie down with eyes closed for 15 minutes.\n");
                    }
                    else{
                        s.setRecommendation(s.getRecommendation() + "- Take pain reliever and lie down with eyes closed for 15 minutes.\n");
                    }
                }
                if(v_symp){
                    if(s.getName() == null){
                        s.setName("Vomiting");
                    }
                    else{
                        s.setName(s.getName() + ", Vomiting");
                    }
                    if(s.getRecommendation() == null){
                        s.setRecommendation("- Drink clear or ice-cold drinks.\n");
                    }
                    else{
                        s.setRecommendation(s.getRecommendation() + "- Drink clear or ice-cold drinks.\n");
                    }
                }
                if(cP_symp){
                    if(s.getName() == null){
                        s.setName("Chest Pain");
                    }
                    else{
                        s.setName(s.getName() + ", Chest Pain");
                    }
                    if(s.getRecommendation() == null){
                        s.setRecommendation("- Take Aspirin with warm water.\n - Apply a cold pack on pain area.");
                    }
                    else{
                        s.setRecommendation(s.getRecommendation() + "- Take Aspirin with warm water.\n - Apply a cold pack on pain area.");
                    }
                }
                s.setDesc("You are experiencing the following symptom(s):"+ s.getName() +". Nothing is serious, please follow our instructions.");
            }
            intent3.putExtra("symtm", s);
            startActivity(intent3);
        }
    }
}