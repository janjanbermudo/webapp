package com.webapp.models;



import java.io.PrintWriter;
import java.sql.*;
import java.util.Arrays;


/**
 * Created by Ian on 30/10/2017.
 */
public class Students {
    Connection conn;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    String url = "jdbc:mysql://localhost:3306/webapp";

    public ResultSet GetData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM students");
        } catch (Exception e) {

        }
        return rs;
    }

    public void Close() {
        try {
            st.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
        }
    }

    public String[] GetStudent(int studentID) {
        String[] StudentsArr = new String[12];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM students WHERE id ='" + studentID + "'");
            while (rs.next()) {
                StudentsArr[0] = rs.getString("id");
                StudentsArr[1] = rs.getString("name");
                StudentsArr[2] = rs.getString("recipe");
                StudentsArr[3] = rs.getString("image");

            }
        } catch (Exception e) {
        }
        return StudentsArr;
    }

    public Boolean deleteStudent(String id) {
        boolean bln = false;
        String debug = "null";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            String sql = "DELETE FROM students WHERE id =?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);


            int result = ps.executeUpdate();
            if (result > 0)
                bln = true;

        } catch (Exception e) {
            debug = e.getMessage();
        }
        return bln;
    }
    public Boolean addStudent(String id,
                                 String name,
                                 String recipe,
                                 String image) {
        boolean bln = false;
        String debug = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            String sql = "INSERT INTO students " +
                    " (id," +
                    "name," +
                    "recipe,"+
                    "image) " +
                    "VALUES " +
                    "(?, ?, ?, ?)";


            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, recipe);
            ps.setString(4, image);


            int result = ps.executeUpdate();
            if (result > 0)
                bln = true;
            else
                bln = false;

        } catch (Exception e) { debug = e.getMessage(); }
        return bln;
    }


    public Boolean updateStudent(String id,
                                 String name,
                                 String recipe,
                                 String image) {
        boolean bln = false;
        String debug = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            String sql = "UPDATE students set " +
                    "id=?, " +
                    "name=?, " +
                    "recipe=?, " +
                    "image=?, " +
                    "WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, recipe);
            ps.setString(4, image);


            int result = ps.executeUpdate();
            if (result > 0)
                bln = true;
            else
                bln = false;

        } catch (Exception e) { debug = e.getMessage(); }
        return bln;
    }


    public ResultSet searchStudent(String search){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM students WHERE"
                    + " id LIKE '%"+search+"%' OR "
                    + "name LIKE '%"+search+"%' OR "
                    + "recipe LIKE '%"+search+"%'");

        } catch (Exception e) {

        }
        return rs;
    }
}

