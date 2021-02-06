package com.example.server_side;

import java.util.HashMap;

public class Database {
    private HashMap<User_account, User_profile> account_collection = new HashMap<User_account, User_profile>();

    // commands
    protected User_account create_new_account(String username, String sin) {
        User_account newly_created = new User_account(username, sin);
        account_collection.put(newly_created, new User_profile());
        return newly_created;
    }

    protected void update_profile(User_account account, String health_id, String location, String phone_number) {
        if (account != null) {
           User_profile profile = account_collection.get(account);
           profile.update(health_id, location, phone_number);
        }
    }

    // query
    protected boolean has_user(String username) {
        for (User_account i : account_collection.keySet()) {
            if (i.get_username().equals(username)) {
                return true;
            }
        }
        return false;
    }

    protected User_account auth(String username, String sin) {
        User_account temp = get_user_account_by_name(username);
        if (temp.is_auth(sin)) {
            return temp;
        };
        return null;
    }

    protected User_account get_user_account_by_name(String username) {
        for (User_account i : account_collection.keySet()) {
            if (i.get_username().equals(username)) {
                return i;
            }
        }
        return null;
    }

    protected User_profile get_user_profile(User_account a) {
        return account_collection.get(a);
    }
    // operations
}
