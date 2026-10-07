package com.recipe.servlet;

import com.recipe.dao.RecipeDAO;
import com.recipe.model.Recipe;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddRecipeServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        String ingredients = request.getParameter("ingredients");
        String instructions = request.getParameter("instructions");
        String cookingTime = request.getParameter("cookingTime");
        String difficulty = request.getParameter("difficulty");

        int userId = 2;

        Recipe recipe = new Recipe(
                0,
                userId,
                name,
                category,
                description,
                ingredients,
                instructions,
                cookingTime,
                difficulty,
                "",
                "PENDING"
        );

        RecipeDAO dao = new RecipeDAO();

        boolean result = dao.addRecipe(recipe);

        response.setContentType("text/html");

        if (result) {

            response.getWriter().println(
                "<h2>Recipe Added Successfully!</h2>"
            );

            response.getWriter().println(
                "<p>Your recipe is waiting for admin approval.</p>"
            );

            response.getWriter().println(
                "<a href='dashboard.html'>Back to Dashboard</a>"
            );

        } else {

            response.getWriter().println(
                "<h2>Failed to Add Recipe</h2>"
            );

            response.getWriter().println(
                "<a href='add-recipe.html'>Try Again</a>"
            );
        }
    }
}