package com.recipe.model;

import com.recipe.interfaces.RatingActions;

public class RecipeExplorer extends User
        implements RatingActions {

    public RecipeExplorer() {
        setRole("EXPLORER");
    }

    public RecipeExplorer(int id, String name,
                          String email, String password) {

        super(id, name, email, password, "EXPLORER");
    }

    @Override
    public void displayDashboard() {

        System.out.println("Recipe Explorer Dashboard");
    }

    public void browseRecipes() {

        System.out.println("Explorer is browsing recipes.");
    }

    @Override
    public void rateRecipe() {

        System.out.println("Explorer rated a recipe.");
    }

    @Override
    public void addReview() {

        System.out.println("Explorer added a review.");
    }

    public void saveRecipe() {

        System.out.println("Explorer saved a recipe.");
    }
}