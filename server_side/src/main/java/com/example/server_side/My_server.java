package com.example.server_side;

public class My_server {
    private AccountDatabase myDatabase = new AccountDatabase();
    private User_account current_session;
    private Logistic myLogistic = new Logistic();

    // init
    public My_server(){
        create_new_account("lemyk", "1234");
    }

    // account operations
    public boolean create_new_account(String username, String sin){
        // username exists
        if (myDatabase.has_user(username)) {
            return false;
        }
        // username is unique
        else {
            current_session = myDatabase.create_new_account(username, sin);
            return true;
        }
    }

    public boolean update_profile(String health_id, String location, String phone_number) {
        // session is empty
        if (current_session == null) {
            return false;
        }
        myDatabase.update_profile(current_session, health_id, location, phone_number);
        return true;
    }

    public boolean login(String username, String sin){
        // username does exist
        if (myDatabase.has_user(username)) {
            current_session = myDatabase.auth(username, sin);
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

    // service operations (only usable when there is an account on active session
    public User_profile getCurrentSessionProfile(){
        if (current_session != null) {
            return myDatabase.get_user_profile(current_session);
        }
        return null;
    }
    public int estimateArrival(){
        if (current_session != null) {
            myLogistic.retrieveCustomerLoc(myDatabase.get_user_profile(current_session));
            return myLogistic.getEarliestWhitebox().x;
        }
        return -1;
    }

    public void enqueueForDoctor(){

    }

    public void cancelQueue(){

    }

    public void receiveInfo(float degree){

    }

    private void createReport(){

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