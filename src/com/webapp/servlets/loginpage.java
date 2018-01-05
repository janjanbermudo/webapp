package com.webapp.servlets;

import javax.imageio.metadata.IIOMetadataNode;
 import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.sql.*;
        import java.util.ArrayList;

        import com.webapp.models.Students;
        import com.webapp.models.Users;

@WebServlet(
        name = "loginpage",
        urlPatterns = { "/servlet/loginpage" }
)
public class loginpage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}