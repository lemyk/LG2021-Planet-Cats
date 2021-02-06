package com.example.server_side;

public class User_account {
    private String credential_name;
    private String credential_sin_number;

    protected User_account(String name, String sin_number) {
        this.credential_name = new String(name);
        this.credential_sin_number = sin_number;
    }

    protected String get_username(){
        return this.credential_name;
    }

    protected boolean is_auth(String sin) {
        if (sin == this.credential_sin_number) {
            return true;
        }
        return false;
    }
}
