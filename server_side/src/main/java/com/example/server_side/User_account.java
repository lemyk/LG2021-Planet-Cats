package com.example.server_side;

import java.io.Serializable;

public class User_account implements Serializable {
    private String credential_name;
    private String credential_sin_number;

    // constructor
    protected User_account(String name, String sin_number) {
        this.credential_name = new String(name);
        this.credential_sin_number = sin_number;
    }

    // queries
    protected String get_username(){
        return this.credential_name;
    }

    protected boolean is_auth(String sin) {
        if (sin.equals(this.credential_sin_number)) {
            return true;
        }
        return false;
    }
}
