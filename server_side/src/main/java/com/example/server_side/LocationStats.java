package com.example.server_side;

public class LocationStats {
    private int x;
    private int y;

    protected LocationStats(int x, int y){
        this.x = x;
        this.y = y;
    }

    protected int calculateDistance(LocationStats target){
        return Math.abs(this.x - target.x) + Math.abs(this.y - target.y);
    }
}
