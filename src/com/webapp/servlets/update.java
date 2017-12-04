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

@WebServlet(name = "update")
public class update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String student_no = request.getParameter("  student_no");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String middle_name = request.getParameter("middle_name");
        String birthdate = request.getParameter("birthdate");
        String email = request.getParameter("email");
        String contact_no = request.getParameter("contact_no");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String course = request.getParameter("course");

        Students students = new Students();
        Boolean bln = students.updateStudent(
                id,
                student_no,
                first_name,
                last_name,
                middle_name,
                birthdate,
                email,
                contact_no,
                address,
                gender,
                course);

        students.Close();
        PrintWriter out = response.getWriter();
        if(bln) {
            out.println("Update successful.");
        } else {
            out.println("Update was not successful.");
        }
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

        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }
}