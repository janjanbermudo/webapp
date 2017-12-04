package com.webapp.models;

import com.mysql.fabric.Response;

import javax.naming.ldap.PagedResultsControl;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Arrays;
import java.io.PrintWriter;


public class Students {
    Connection conn;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    String url = "jdbc:mysql://localhost/webapp";

    public ResultSet GetData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT *  FROM students");
        } catch (Exception e) {

        }

        return rs;
    }

    public void Close() {
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
        }
    }

    public String[] GetStudent(Integer studentID) {
        String[] StudentArr = new String[12];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp", "root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students WHERE id='" + studentID + "'");
            while (rs.next()) {
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

    public boolean updateStudent(
            String id,
            String student_no,
            String first_name,
            String last_name,
            String middle_name,
            String birthdate,
            String email,
            String contact_no,
            String address,
            String gender,
            String course) {

        boolean bln = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            String sql = "Update students set " +
                    "first_name=?, " +
                    "middle_name=?, " +
                    "last_name=?, " +
                    "birthdate=?, " +
                    "email=?, " +
                    "contact_no=?, " +
                    "address=?, " +
                    "gender=?, " +
                    "course=? " +
                    "WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, first_name);
            ps.setString(2, middle_name);
            ps.setString(3, last_name);
            ps.setString(4, birthdate);
            ps.setString(5, email);
            ps.setString(6, contact_no);
            ps.setString(7, address);
            ps.setString(8, gender);
            ps.setString(9, course);
            ps.setString(10, id);

            int result = ps.executeUpdate();
            if(result > 0) {
                //Successful Update
                bln = true;
            } else {
                //Not Successful Update
                bln = false;
            }
        } catch (Exception e) {

        }
        return bln;
    }

    public ResultSet searchStudent(String searchValue) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT *  FROM students WHERE " +
                    "first_name LIKE '%"+searchValue+"%' OR " +
                    "middle_name LIKE '%"+searchValue+"%' OR " +
                    "last_name LIKE '%"+searchValue+"%'"
            );


        } catch (Exception e) {

        }

        return rs;
    }
}
