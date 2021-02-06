package com.example.lassondegames2021_programmingchallenge;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.server_side.My_server;

public class Main_Server_Activity implements Parcelable {
    My_server ms;

    public Main_Server_Activity() {
        this.ms = new My_server();
    }

    public My_server getMs() {
        return ms;
    }

    public void setMs(My_server ms) {
        this.ms = ms;
    }

    protected Main_Server_Activity(Parcel in) {
        ms = (My_server) in.readValue(My_server.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ms);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Main_Server_Activity> CREATOR = new Parcelable.Creator<Main_Server_Activity>() {
        @Override
        public Main_Server_Activity createFromParcel(Parcel in) {
            return new Main_Server_Activity(in);
        }

        @Override
        public Main_Server_Activity[] newArray(int size) {
            return new Main_Server_Activity[size];
        }
    };
}