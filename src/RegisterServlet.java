package com.recipe.servlet;

import com.recipe.dao.UserDAO;
import com.recipe.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Create User object
        User user = new User(
                0,
                name,
                email,
                password,
                role
        );

        // Save user to database
        UserDAO dao = new UserDAO();

        boolean result = dao.registerUser(user);

        if (result) {

            // Registration successful
            response.sendRedirect("registration-success.html");

        } else {

            // Registration failed
            response.setContentType("text/html");

            response.getWriter().println(
                "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>Registration Failed</title>" +
                "</head>" +
                "<body style='font-family:Arial;text-align:center;padding:60px;'>" +
                "<h2>Registration Failed</h2>" +
                "<p>This email may already be registered.</p>" +
                "<a href='register.html'>Try Again</a>" +
                "</body>" +
                "</html>"
            );
        }
    }
}