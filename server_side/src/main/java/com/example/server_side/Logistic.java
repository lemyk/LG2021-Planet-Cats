package com.example.server_side;

import java.io.Serializable;
import java.util.ArrayList;

public class Logistic implements Serializable {
    private ArrayList<WhiteBox> whiteboxList = new ArrayList<WhiteBox>();
    private int availableID = 0;
    private LocationStats activeSessionCustomerLoc;

    protected Logistic(){
        for (int i = 0; i < 2 ; i++) {
            //whiteboxAdd();
            whiteboxAddWithRandomLoc();
        }
        dispatchWhitebox(0);
        dispatchWhitebox(2);
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

    // first: id
    // second: distance in meter
    protected ArrayList<Tuple<Integer, Integer>> getWhiteBoxData() {
        if (activeSessionCustomerLoc == null) {
            return null;
        }
        ArrayList<Tuple<Integer, Integer>> result = new ArrayList<Tuple<Integer, Integer>>();
        for (WhiteBox i : whiteboxList){
            result.add(new Tuple(i.getId(), i.getLoc().calculateDistance(activeSessionCustomerLoc)));
        }
        return result;
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
        a.setLocation((int) (Math.random()*-5000), (int) (Math.random()*5000));
        whiteboxList.add(a);
    }
}
