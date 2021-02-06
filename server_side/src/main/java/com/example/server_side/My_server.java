package com.example.server_side;

public class My_server {
    private Database my_database = new Database();
    private User_account current_session;

    public boolean create_new_account(String username, String sin){
        if (my_database.has_user(username)) {
            return false;
        }
        else {
            current_session = my_database.create_new_account(username, sin);
            return true;
        }
    }

    public boolean update_profile(String health_id, String location, String phone_number) {
        if (current_session == null) {
            return false;
        }
        my_database.update_profile(current_session, health_id, location, phone_number);
        return true;
    }

    public boolean login(String username, String sin){
        if (my_database.has_user(username)) {
            if (my_database.is_correct_combination(username, sin)) {
                current_session = my_database.get_user_account_by_name(username);
                return true;
            }
        }
        return false;
    }
}