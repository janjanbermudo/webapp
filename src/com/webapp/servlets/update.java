package com.webapp.servlets;

import com.webapp.models.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.Part;
import java.io.PrintWriter;

/**
 * Created by Ian on 24/11/2017.
 */
@WebServlet(name = "update")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50

)
public class update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String student_no = request.getParameter("student_no");
        String first_name = request.getParameter("first_name");
        String middle_name = request.getParameter("middle_name");
        String last_name = request.getParameter("last_name");
        String birthdate = request.getParameter("birthdate");
        String email = request.getParameter("email");
        String contact_no = request.getParameter("contact_no");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String course = request.getParameter("course");

        //parse uploaded file
        PrintWriter out = response.getWriter();
        Part uploadedImage = request.getPart("image");
//        out.println(uploadedImage.getHeader("content-disposition"));
        String filename = extractFileName(uploadedImage);

        String savepath = "C:\\Users\\student\\IdeaProjects\\WebApp\\web\\assets\\images" + File.separator + filename;
        File fileSaveDir = new File(savepath);
        uploadedImage.write(savepath + File.separator);

        Students students = new Students();
        Boolean bln = students.updateStudent(
                id,
                student_no,
                first_name,
                middle_name,
                last_name,
                birthdate,
                email,
                contact_no,
                address,
                gender,
                course,
                filename);
        students.Close();
/*        out.println(bln);*/
        if (bln) {
            out.println("Update was Successful");
        } else
            out.println("Update Error Occurred");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentID = Integer.parseInt(request.getParameter("id"));
        Students students = new Students();
        String[] StudentsArr = students.GetStudent(studentID);

        request.setAttribute("id", StudentsArr[0]);
        request.setAttribute("student_no", StudentsArr[1]);
        request.setAttribute("first_name", StudentsArr[2]);
        request.setAttribute("middle_name", StudentsArr[3]);
        request.setAttribute("last_name", StudentsArr[4]);
        request.setAttribute("birthdate", StudentsArr[5]);
        request.setAttribute("email", StudentsArr[6]);
        request.setAttribute("contact_no", StudentsArr[7]);
        request.setAttribute("address", StudentsArr[8]);
        request.setAttribute("gender", StudentsArr[9]);
        request.setAttribute("course", StudentsArr[10]);
        request.setAttribute("image", StudentsArr[11]);


        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}