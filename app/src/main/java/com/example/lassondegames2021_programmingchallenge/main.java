package com.example.lassondegames2021_programmingchallenge;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class main extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        Button sTrack = (Button)v.findViewById(R.id.bSympTrack);
        sTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Navigation.findNavController(v1).navigate(R.id.indexPage);
            }
        });
        return v;
    }
}