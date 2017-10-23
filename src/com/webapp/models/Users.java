package com.webapp.models;

public class Users {
    public boolean authentication(String username, String password) {
        if(username.equals("admin") && password.equals("abc123")) return true;
        else return false;
    }
}
