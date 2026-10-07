package com.recipe.dao;

import com.recipe.model.Recipe;
import com.recipe.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RecipeDAO {

    // Add recipe
    public boolean addRecipe(Recipe recipe) {

        String sql = "INSERT INTO recipes " +
                "(user_id, name, category, description, ingredients, instructions, cooking_time, difficulty, image, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, recipe.getUserId());
            ps.setString(2, recipe.getName());
            ps.setString(3, recipe.getCategory());
            ps.setString(4, recipe.getDescription());
            ps.setString(5, recipe.getIngredients());
            ps.setString(6, recipe.getInstructions());
            ps.setString(7, recipe.getCookingTime());
            ps.setString(8, recipe.getDifficulty());
            ps.setString(9, recipe.getImage());
            ps.setString(10, recipe.getStatus());

            int result = ps.executeUpdate();

            con.close();

            return result > 0;

        } catch (Exception e) {
            System.out.println("Add recipe error: " + e.getMessage());
            return false;
        }
    }

    // View all recipes
    public void viewRecipes() {

        String sql = "SELECT * FROM recipes";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("----------------------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Cooking Time: " + rs.getString("cooking_time"));
                System.out.println("Difficulty: " + rs.getString("difficulty"));
                System.out.println("Status: " + rs.getString("status"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println("View recipes error: " + e.getMessage());
        }
    }

    // Update recipe
    public boolean updateRecipe(Recipe recipe) {

        String sql = "UPDATE recipes SET name=?, category=?, description=?, " +
                "ingredients=?, instructions=?, cooking_time=?, difficulty=? " +
                "WHERE id=?";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, recipe.getName());
            ps.setString(2, recipe.getCategory());
            ps.setString(3, recipe.getDescription());
            ps.setString(4, recipe.getIngredients());
            ps.setString(5, recipe.getInstructions());
            ps.setString(6, recipe.getCookingTime());
            ps.setString(7, recipe.getDifficulty());
            ps.setInt(8, recipe.getId());

            int result = ps.executeUpdate();

            con.close();

            return result > 0;

        } catch (Exception e) {
            System.out.println("Update recipe error: " + e.getMessage());
            return false;
        }
    }

    // Delete recipe
    public boolean deleteRecipe(int id) {

        String sql = "DELETE FROM recipes WHERE id=?";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            con.close();

            return result > 0;

        } catch (Exception e) {
            System.out.println("Delete recipe error: " + e.getMessage());
            return false;
        }
    }
}