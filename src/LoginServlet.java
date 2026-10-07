package com.recipe.servlet;

import com.recipe.dao.UserDAO;
import com.recipe.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();

        User user = dao.loginUser(email, password);

        if (user != null) {

            // Login successful
            response.sendRedirect("dashboard.html");

        } else {

            // Login failed
            // Go back to the same styled login page
            response.sendRedirect("index.html?error=invalid");

        }
    }
}

