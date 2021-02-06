package com.example.server_side;

public class User_profile {
    private String healthcare_id;
    private String location;
    private String phone_number;

    protected User_profile(String healthcare_id, String location, String phone_number) {
        this.healthcare_id = new String(healthcare_id);
        this.location = new String(location);
        this.phone_number = new String(phone_number);
    }

    protected User_profile(){

    }

    protected void update_id(String new_id){
        this.healthcare_id = new_id;
    }

    protected void location(String new_location){
        this.location = new_location;
    }

    protected void update_phone_number(String new_phone_number){
        this.phone_number = new_phone_number;
    }

    protected void update (String healthcare_id, String location, String phone_number) {
        this.healthcare_id = new String(healthcare_id);
        this.location = new String(location);
        this.phone_number = new String(phone_number);
    }
}
