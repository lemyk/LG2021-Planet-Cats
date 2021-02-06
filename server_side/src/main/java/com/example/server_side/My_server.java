package com.example.server_side;

public class My_server {
    private Database my_database = new Database();
    private User_account current_session;

    public boolean create_new_account(String username, String sin){
        // username exists
        if (my_database.has_user(username)) {
            return false;
        }
        // username is unique
        else {
            current_session = my_database.create_new_account(username, sin);
            return true;
        }
    }

    public boolean update_profile(String health_id, String location, String phone_number) {
        // session is empty
        if (current_session == null) {
            return false;
        }
        my_database.update_profile(current_session, health_id, location, phone_number);
        return true;
    }

    public boolean login(String username, String sin){
        // username does exist
        if (my_database.has_user(username)) {
            current_session = my_database.auth(username, sin);
            // right pair of username, password
            if (current_session != null) {
                return true;
            }
        }
        return false;
    }

    public boolean logout(){
        if (current_session != null){
            current_session = null;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        My_server a = new My_server();
        boolean test1 = a.create_new_account("a", "123");
        System.out.println(test1);
        System.out.println(a.current_session.get_username());
        System.out.println(a.update_profile("yes", "yes", "no"));
        System.out.println(a.logout());
        boolean test2 = a.create_new_account("a", "123");
        System.out.println(test2);
    }
}