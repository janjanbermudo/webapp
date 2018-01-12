package com.webapp.servlets;

import com.webapp.models.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        request.setAttribute("name", StudentArr[1]);
        request.setAttribute("recipe", StudentArr[2]);
        request.setAttribute("image", StudentArr[3]);

        request.getRequestDispatcher("/views.jsp").forward(request,response);

    }
}