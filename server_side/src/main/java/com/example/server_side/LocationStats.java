package com.example.server_side;

public class LocationStats {
    private int x;
    private int y;

    protected LocationStats(int x, int y){
        this.x = x;
        this.y = y;
    }

    protected LocationStats(String a){
        this.x = a.length()*100;
        this.y = a.length()*200;
    }

    protected int calculateDistance(LocationStats target){
        return Math.abs(this.x - target.x) + Math.abs(this.y - target.y);
    }
}
