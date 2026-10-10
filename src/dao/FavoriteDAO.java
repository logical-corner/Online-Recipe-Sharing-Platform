package com.recipe.dao;

import com.recipe.util.DBConnection;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class FavoriteDAO {

    public Set<Integer> getUserFavoriteRecipeIds(int userId) {
        Set<Integer> favIds = new HashSet<>();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "select recipe_id from favorites where user_id=?"
            );

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                favIds.add(rs.getInt(1));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return favIds;
    }

    public boolean addFavorite(int userId, int recipeId) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "insert into favorites(user_id, recipe_id) values(?, ?)"
            );

            ps.setInt(1, userId);
            ps.setInt(2, recipeId);

            int result = ps.executeUpdate();
            con.close();

            return result > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean removeFavorite(int userId, int recipeId) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "delete from favorites where user_id=? and recipe_id=?"
            );

            ps.setInt(1, userId);
            ps.setInt(2, recipeId);

            int result = ps.executeUpdate();
            con.close();

            return result > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}