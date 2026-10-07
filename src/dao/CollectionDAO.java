package com.recipe.dao;

import com.recipe.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CollectionDAO {

    // Save recipe
    public boolean saveRecipe(int userId, int recipeId) {

        String sql = "INSERT INTO collections (user_id, recipe_id) VALUES (?, ?)";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, recipeId);

            int result = ps.executeUpdate();

            con.close();

            return result > 0;

        } catch (Exception e) {
            System.out.println("Save recipe error: " + e.getMessage());
            return false;
        }
    }

    // View saved recipes
    public void viewCollection(int userId) {

        String sql = "SELECT r.id, r.name, r.category " +
                     "FROM collections c " +
                     "JOIN recipes r ON c.recipe_id = r.id " +
                     "WHERE c.user_id = ?";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("----------------------------");
                System.out.println("Recipe ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Category: " + rs.getString("category"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Collection error: " + e.getMessage());
        }
    }

    // Remove saved recipe
    public boolean removeRecipe(int userId, int recipeId) {

        String sql = "DELETE FROM collections " +
                     "WHERE user_id=? AND recipe_id=?";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, recipeId);

            int result = ps.executeUpdate();

            con.close();

            return result > 0;

        } catch (Exception e) {
            System.out.println("Remove recipe error: " + e.getMessage());
            return false;
        }
    }
}