package com.webapp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Users {
    public boolean authentication(String username, String password) {
        /*if(username.equals("admin") && password.equals("abc123")) return true;
        else return false;*/

        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String url = "jdbc:mysql://localhost/webapp";
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT *  FROM user WHERE username='"+username+"' AND password='"+password+"'");
            while (rs.next()) {
                String user = rs.getString("username");
                if(user.equals(null)){
                    return false;
                }
                    else return true;
            }
            st.close();
            rs.close();
            conn.close();
        } catch (Exception e) {


        }return false;
    }
}