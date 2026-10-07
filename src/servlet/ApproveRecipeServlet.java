package com.recipe.servlet;

import com.recipe.dao.AdminDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ApproveRecipeServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int recipeId = Integer.parseInt(
                request.getParameter("recipeId")
        );

        AdminDAO dao = new AdminDAO();

        boolean result = dao.approveRecipe(recipeId);

        response.setContentType("text/html");

        if (result) {

            response.getWriter().println(
                "<h2>Recipe Approved Successfully!</h2>"
            );

            response.getWriter().println(
                "<a href='admin-dashboard.html'>Back to Admin Dashboard</a>"
            );

        } else {

            response.getWriter().println(
                "<h2>Failed to Approve Recipe</h2>"
            );

            response.getWriter().println(
                "<a href='admin-dashboard.html'>Back to Admin Dashboard</a>"
            );
        }
    }
}