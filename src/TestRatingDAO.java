package com.recipe;

import com.recipe.dao.RatingDAO;

public class TestRatingDAO {

    public static void main(String[] args) {

        RatingDAO dao = new RatingDAO();

        boolean result = dao.addRating(
                1,
                2,
                5,
                "Very tasty recipe!"
        );

        if (result) {
            System.out.println("Rating added successfully!");
        } else {
            System.out.println("Rating failed!");
        }

        System.out.println("\nReviews:");

        dao.viewReviews(1);

        System.out.println("\nRating Summary:");

        dao.showAverageRating(1);
    }
}