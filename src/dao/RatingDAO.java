package com.recipe.dao;

import com.recipe.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RatingDAO {

    // Add rating and review
    public boolean addRating(int recipeId, int userId,
                             int rating, String review) {

        String sql = "INSERT INTO ratings " +
                "(recipe_id, user_id, rating, review) " +
                "VALUES (?, ?, ?, ?)";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, recipeId);
            ps.setInt(2, userId);
            ps.setInt(3, rating);
            ps.setString(4, review);

            int result = ps.executeUpdate();

            con.close();

            return result > 0;

        } catch (Exception e) {
            System.out.println("Rating error: " + e.getMessage());
            return false;
        }
    }

    // View reviews of a recipe
    public void viewReviews(int recipeId) {

        String sql = "SELECT * FROM ratings WHERE recipe_id=?";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, recipeId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("----------------------------");
                System.out.println("User ID: " + rs.getInt("user_id"));
                System.out.println("Rating: " + rs.getInt("rating"));
                System.out.println("Review: " + rs.getString("review"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Review error: " + e.getMessage());
        }
    }

    // Calculate average rating
    public void showAverageRating(int recipeId) {

        String sql = "SELECT AVG(rating) AS average_rating " +
                     "FROM ratings WHERE recipe_id=?";

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, recipeId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                double average = rs.getDouble("average_rating");

                System.out.println(
                        "Average Rating: " + average
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Average rating error: " + e.getMessage());
        }
    }
}