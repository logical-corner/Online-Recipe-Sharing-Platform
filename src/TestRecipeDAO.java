package com.recipe;

import com.recipe.dao.RecipeDAO;
import com.recipe.model.Recipe;

public class TestRecipeDAO {

    public static void main(String[] args) {

        RecipeDAO dao = new RecipeDAO();

        Recipe recipe = new Recipe(
                0,
                1,
                "Paneer Butter Masala",
                "Indian",
                "A creamy and delicious paneer dish.",
                "Paneer, Butter, Tomato, Cream, Spices",
                "Cook tomato gravy, add spices and paneer, then add cream.",
                "40 minutes",
                "Medium",
                "",
                "PENDING"
        );

        boolean result = dao.addRecipe(recipe);

        if (result) {
            System.out.println("Recipe added successfully!");
        } else {
            System.out.println("Recipe addition failed!");
        }
    }
}