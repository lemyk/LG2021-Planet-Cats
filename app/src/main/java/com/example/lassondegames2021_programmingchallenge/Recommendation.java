package com.example.lassondegames2021_programmingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Locale;

public class Recommendation extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextToSpeech t1;
    Symptoms sm = new Symptoms();
    int eval = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            eval = extras.getInt("eval_score");
            sm = (Symptoms)extras.getParcelable("symtm");
        }

        LinearLayout ll = (LinearLayout) findViewById(R.id.lRecomm);
        ll.addView(recommendations(eval));

    }

    public void speakText(View v) {

        String textContents = sm.getDesc() + "\n" + sm.getRecommendation();
        t1.speak(textContents, TextToSpeech.QUEUE_FLUSH, null, null);

    }

    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {
            //Setting speech Language
            t1.setLanguage(Locale.CANADA);
        }
    }

    public TextView recommendations(int eval){
        TextView tv = new TextView(this);
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(18f);
        String symptoms_desc = sm.getDesc();
        String symptoms_rec = sm.getRecommendation();
        tv.setText(symptoms_desc + "\n\n" + symptoms_rec);
        t1 = new TextToSpeech(this, this);

        String toSpeak = tv.getText().toString();
        return tv;
    }
}