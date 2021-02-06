package com.example.lassondegames2021_programmingchallenge;

import android.os.Parcel;
import android.os.Parcelable;

public class Symptoms implements Parcelable {
    private String name;
    private String desc;
    private String recommendation;

    public Symptoms(){

    }
    public Symptoms(String name, String desc, String recommendation){
        this.name = name;
        this.desc = desc;
        this.recommendation = recommendation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    protected Symptoms(Parcel in) {
        name = in.readString();
        desc = in.readString();
        recommendation = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeString(recommendation);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Symptoms> CREATOR = new Parcelable.Creator<Symptoms>() {
        @Override
        public Symptoms createFromParcel(Parcel in) {
            return new Symptoms(in);
        }

        @Override
        public Symptoms[] newArray(int size) {
            return new Symptoms[size];
        }
    };
}
