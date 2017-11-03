package com.webapp.models;

import java.sql.*;
import java.util.Arrays;


public class Students {
    Connection conn;
    Statement st;
    ResultSet rs;

    public ResultSet GetData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/webapp";
            conn = DriverManager.getConnection(url, "root", "");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT *  FROM students");
        } catch (Exception e){

        }

        return rs;
    }
    public void Close(){
        try{
            rs.close();
            st.close();
            conn.close();
        }catch(Exception e){}
    }

    public String[] GetStudent(Integer studentID) {
        String[] StudentArr = new String[12];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students WHERE id='"+studentID+"'");
            while(rs.next()) {
                StudentArr[0] = rs.getString("id");
                StudentArr[1] = rs.getString("student_no");
                StudentArr[2] = rs.getString("first_name");
                StudentArr[3] = rs.getString("last_name");
                StudentArr[4] = rs.getString("middle_name");
                StudentArr[5] = rs.getString("birthdate");
                StudentArr[6] = rs.getString("email");
                StudentArr[7] = rs.getString("contact_no");
                StudentArr[8] = rs.getString("address");
                StudentArr[9] = rs.getString("gender");
                StudentArr[10] = rs.getString("course");
                StudentArr[11] = rs.getString("image");
            }
            st.close();
            rs.close();
            conn.close();
        } catch (Exception e) {

        }
    return StudentArr;
    }
}
