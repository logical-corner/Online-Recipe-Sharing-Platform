package com.recipe.dao;

import com.recipe.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HistoryDAO {

    // Add browsing history
    public boolean addHistory(int userId, int recipeId) {

        String sql = "INSERT INTO browsing_history " +
                     "(user_id, recipe_id) VALUES (?, ?)";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, recipeId);

            int result = ps.executeUpdate();

            con.close();

            return result > 0;

        } catch (Exception e) {
            System.out.println("History error: " + e.getMessage());
            return false;
        }
    }

    // View browsing history
    public void viewHistory(int userId) {

        String sql = "SELECT r.id, r.name, r.category, bh.viewed_at " +
                     "FROM browsing_history bh " +
                     "JOIN recipes r ON bh.recipe_id = r.id " +
                     "WHERE bh.user_id = ? " +
                     "ORDER BY bh.viewed_at DESC";

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
                System.out.println("Viewed At: " + rs.getTimestamp("viewed_at"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println("View history error: " + e.getMessage());
        }
    }
}