package com.example.lassondegames2021_programmingchallenge;

import androidx.appcompat.app.AppCompatActivity;
import com.example.server_side.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class mainPage extends AppCompatActivity {
    String uname, pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        EditText etxt = (EditText) findViewById(R.id.uName);
        if(etxt != null){
            uname = etxt.getText().toString();
        }
        EditText pd = (EditText) findViewById(R.id.uPin);
        if(pd != null){
            pwd = pd.getText().toString();
        }
    }

    public void loginClick(View v){
        Intent intent = new Intent(this, index_page.class);
        My_server ms = new My_server();
        if(ms.login(uname, pwd)){
            startActivity(intent);
        }else{
            Toast.makeText(mainPage.this,
                    "Your username or PIN is incorrect. Please try again.", Toast.LENGTH_LONG).show();
        }
    }
}