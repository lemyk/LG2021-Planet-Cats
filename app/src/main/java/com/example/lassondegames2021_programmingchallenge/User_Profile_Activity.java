package com.example.lassondegames2021_programmingchallenge;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.server_side.User_profile;

public class User_Profile_Activity implements Parcelable {
    User_profile uProf;
    public User_Profile_Activity(User_profile uProf) {
        this.uProf = uProf;
    }

    public User_profile getuProf() {
        return uProf;
    }

    protected User_Profile_Activity(Parcel in) {
        uProf = (User_profile) in.readValue(User_profile.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(uProf);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<User_Profile_Activity> CREATOR = new Parcelable.Creator<User_Profile_Activity>() {
        @Override
        public User_Profile_Activity createFromParcel(Parcel in) {
            return new User_Profile_Activity(in);
        }

        @Override
        public User_Profile_Activity[] newArray(int size) {
            return new User_Profile_Activity[size];
        }
    };
}