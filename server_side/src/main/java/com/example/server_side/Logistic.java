package com.example.server_side;

import java.util.ArrayList;

public class Logistic {
    private ArrayList<WhiteBox> whiteboxList = new ArrayList<WhiteBox>();
    private int availableID = 0;

    private LocationStats customerLoc;

    // commands
    protected void whiteboxAdd() {
        whiteboxList.add(new WhiteBox(getNewId()));
    }

    protected void retrieveCustomerLoc(LocationStats a ) {
        this.customerLoc = a;
    }

    // queries
    protected Tuple<Integer, Integer> getEarliestWhitebox() {
        if (customerLoc == null) {
            return new Tuple<Integer, Integer>(-1, -1);
        }
        Tuple<Integer, Integer> minTime = new Tuple(2147483647, -1);
        for (WhiteBox i : whiteboxList){
            int remainingTime = i.task_duration + i.getLoc().calculateDistance(customerLoc) / i.VELOCITY;
            if (remainingTime < minTime.x){
                minTime = new Tuple(remainingTime, i.getId());
            }
        }
        return minTime;
    }

    // private
    private int getNewId(){
        return availableID++;
    }

    private WhiteBox getWhiteboxById(int id){
        for (WhiteBox i : whiteboxList){
            if (i.getId() == id) return i;
        }
        return null;
    }

    private void dispatchWhitebox(int id){
        getWhiteboxById(id).initiateSession();
    }
}
