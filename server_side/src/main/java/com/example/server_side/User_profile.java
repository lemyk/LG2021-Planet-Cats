package com.example.server_side;

public class User_profile {
    private String healthcare_id;
    private LocationStats location;
    private String phone_number;

    // constructor
    protected User_profile(String healthcare_id, String location, String phone_number) {
        this.healthcare_id = new String(healthcare_id);
        this.location = new LocationStats(location);
        this.phone_number = new String(phone_number);
    }

    protected User_profile(){    }

    // update
    protected void updateId(String new_id){
        this.healthcare_id = new_id;
    }

    protected void updateLocation(String new_location){
        this.location = new LocationStats(new_location);
    }

    protected void updatePhoneNumber(String new_phone_number){
        this.phone_number = new_phone_number;
    }

    protected void update (String healthcare_id, String location, String phone_number) {
        this.healthcare_id = new String(healthcare_id);
        this.location = new LocationStats(location);
        this.phone_number = new String(phone_number);
    }

    // query
    protected LocationStats getLoc(){
        return this.location;
    }
}
