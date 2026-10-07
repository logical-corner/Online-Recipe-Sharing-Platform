package com.recipe;

import com.recipe.dao.CollectionDAO;

public class TestCollectionDAO {

    public static void main(String[] args) {

        CollectionDAO dao = new CollectionDAO();

        boolean result = dao.saveRecipe(2, 1);

        if (result) {
            System.out.println("Recipe saved successfully!");
        } else {
            System.out.println("Recipe save failed!");
        }

        System.out.println("\nSaved Recipes:");

        dao.viewCollection(2);
    }
}