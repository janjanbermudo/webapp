package com.webapp.servlets;

import com.webapp.models.Students;
import com.webapp.models.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(
        name = "view"
)
public class view extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentID = Integer.parseInt(request.getParameter("id"));
        Students students = new Students();
        String[] StudentArr = students.GetStudent(studentID);
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        out.println(StudentArr[0]);
        out.println(StudentArr[1]);
        out.println(StudentArr[2]);
        out.println(StudentArr[3]);
        out.println(StudentArr[4]);
        out.println(StudentArr[5]);
        out.println(StudentArr[6]);
        out.println(StudentArr[7]);
        out.println(StudentArr[8]);
        out.println(StudentArr[9]);
        out.println(StudentArr[10]);
        out.println("<img src=\"assets/images/" + StudentArr[11] + "\">");
    }
}