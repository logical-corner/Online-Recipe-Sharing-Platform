package com.recipe.dao;

import com.recipe.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

    // View pending recipes
    public void viewPendingRecipes() {

        String sql = "SELECT * FROM recipes WHERE status='PENDING'";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("----------------------------");
                System.out.println("Recipe ID: " + rs.getInt("id"));
                System.out.println("Recipe Name: " + rs.getString("name"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Status: " + rs.getString("status"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Approve recipe
    public boolean approveRecipe(int recipeId) {

        String sql = "UPDATE recipes SET status='APPROVED' WHERE id=?";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, recipeId);

            int result = ps.executeUpdate();

            con.close();

            return result > 0;

        } catch (Exception e) {
            System.out.println("Approval error: " + e.getMessage());
            return false;
        }
    }

    // Reject recipe
    public boolean rejectRecipe(int recipeId) {

        String sql = "UPDATE recipes SET status='REJECTED' WHERE id=?";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, recipeId);

            int result = ps.executeUpdate();

            con.close();

            return result > 0;

        } catch (Exception e) {
            System.out.println("Rejection error: " + e.getMessage());
            return false;
        }
    }
}