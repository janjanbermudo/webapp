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
        request.setAttribute("id", StudentArr[0]);
        request.setAttribute("student_no", StudentArr[1]);
        request.setAttribute("first_name", StudentArr[2]);
        request.setAttribute("last_name", StudentArr[3]);
        request.setAttribute("middle_name", StudentArr[4]);
        request.setAttribute("birthdate", StudentArr[5]);
        request.setAttribute("email", StudentArr[6]);
        request.setAttribute("contact_no", StudentArr[7]);
        request.setAttribute("address", StudentArr[8]);
        request.setAttribute("gender", StudentArr[9]);
        request.setAttribute("course", StudentArr[10]);
        request.setAttribute("images", StudentArr[11]);

        request.getRequestDispatcher("/views.jsp").forward(request,response);

    }
}