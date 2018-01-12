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

@WebServlet(
        name = "add"
)
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50

)
public class add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String recipe = request.getParameter("recipe");

        //parse uploaded file
        PrintWriter out = response.getWriter();
        Part uploadedImage = request.getPart("image");
        String filename = extractFileName(uploadedImage);

        String savepath = "C:\\Users\\student\\IdeaProjects\\WebApp\\web\\assets\\images" + File.separator + filename;
        File fileSaveDir = new File(savepath);
        uploadedImage.write(savepath + File.separator);

        Students students = new Students();
        Boolean bln = students.addStudent(
                id,
                name,
                recipe,
                filename);
        students.Close();
/*        out.println(bln);*/
        if (bln) {
            out.println("Add Successfull");
        } else {
            String errorMessage =
                    "<div class=\"alert alert-danger alert-dismissable alert-login\" role=\"alert\">\n" +
                            "   <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">" +
                            "<span aria-hidden=\"true\">&times;</span>" +
                            "   </button>" +
                            "  <strong>Error!</strong> Student number already exist.\n" +
                            "</div>";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/add");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentID = Integer.parseInt(request.getParameter("id"));
        Students students = new Students();
        String[] StudentsArr = students.GetStudent(studentID);

        request.setAttribute("id", StudentsArr[0]);
        request.setAttribute("name", StudentsArr[1]);
        request.setAttribute("recipe", StudentsArr[2]);
        request.setAttribute("image", StudentsArr[3]);


        request.getRequestDispatcher("/add.jsp").forward(request, response);
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