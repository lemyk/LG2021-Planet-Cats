package com.example.server_side;

import java.util.ArrayList;

public class Logistic {
    private ArrayList<WhiteBox> whiteboxList = new ArrayList<WhiteBox>();
    private int availableID = 0;
    private LocationStats activeSessionCustomerLoc;

    protected Logistic(){
        for (int i = 0; i < 2 ; i++) {
            //whiteboxAdd();
            whiteboxAddWithRandomLoc();
        }
    }

    // commands
    protected void whiteboxAdd() {
        whiteboxList.add(new WhiteBox(getNewId()));
    }

    protected void retrieveCustomerLoc(User_profile a) {
        this.activeSessionCustomerLoc = a.getLoc();
    }

    // queries
    // first: time estimate
    // second: white box id
    protected Tuple<Integer, Integer> getEarliestWhitebox() {
        if (activeSessionCustomerLoc == null) {
            return new Tuple<Integer, Integer>(-1, -1);
        }
        Tuple<Integer, Integer> minTime = new Tuple(2147483647, -1);
        for (WhiteBox i : whiteboxList){
            int remainingTime = i.task_duration + i.getLoc().calculateDistance(activeSessionCustomerLoc) / i.VELOCITY;
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

    // only for demo
    private void whiteboxAddWithRandomLoc() {
        WhiteBox a = new WhiteBox(getNewId());
        a.setLocation((int) (Math.random()*-200), (int) (Math.random()*200));
        whiteboxList.add(a);
    }
}
