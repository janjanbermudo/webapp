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

@WebServlet
        (name = "search")
public class search extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String search = request.getParameter("search");
        Students students = new Students();
        ResultSet rs = students.searchStudent(search);
        String studentsData = "";
        try {
            while (rs.next()) {
                studentsData +=
                        "<tr>" +
                                "<td>" + rs.getString("id") + "</td>" +
                                "<td>" + rs.getString("name") + "</td>" +
                                "<td>" +
                                "<img class=\"profile-img\"" +
                                "src=\"assets/images/" + rs.getString("image")+"\">" +
                                "</td>" +
                                "<td>" +
                                "<a href=\"view?id="+rs.getString("id")+"\">" +
                                "<i class=\"fa fa-eye\" aria-hidden=\"true\"></i>" +
                                "</a>" +
                                "<a href=\"update?id="+rs.getString("id")+"\">" +
                                "<i class=\"fa fa-pencil\" aria-hidden=\"true\"></i>" +
                                "</a>" +
                                "&nbsp;" +
                                "<i class=\"fa fa-trash-o\" aria-hidden=\"true\"></i>" +
                                "</td>" +
                                "</tr>";
            }
            rs.close();
        } catch(Exception e) { }
        students.Close();
        request.setAttribute("studentsData", studentsData);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}