package com.example.server_side;

import java.io.Serializable;

public class WhiteBox implements Serializable {
    protected int task_duration;
    private LocationStats location;
    private int id;
    protected boolean isBusy;

    // velocity in meter per sec
    protected final int VELOCITY = 12;
    private final int NEW_SESSION = 30*60;

    // constructor
    protected WhiteBox(int id){
        this.id = id;
        this.location = new LocationStats(0, 0);
    }

    // commands
    protected void setLocation(int x, int y){
        this.location = new LocationStats(x, y);
    }

    protected void initiateSession(){
        task_duration = NEW_SESSION;
        isBusy = true;
    }

    // queries
    protected LocationStats getLoc(){
        return this.location;
    }

    protected int getId(){
        return this.id;
    }
}
