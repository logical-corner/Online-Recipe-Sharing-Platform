package com.recipe.model;

import com.recipe.interfaces.RecipeActions;

public class RecipeContributor extends User
        implements RecipeActions {

    public RecipeContributor() {
        setRole("CONTRIBUTOR");
    }

    public RecipeContributor(int id, String name,
                             String email, String password) {

        super(id, name, email, password, "CONTRIBUTOR");
    }

    @Override
    public void displayDashboard() {

        System.out.println("Recipe Contributor Dashboard");
    }

    @Override
    public void addRecipe() {

        System.out.println("Contributor added a recipe.");
    }

    @Override
    public void updateRecipe() {

        System.out.println("Contributor updated a recipe.");
    }

    @Override
    public void deleteRecipe() {

        System.out.println("Contributor deleted a recipe.");
    }
}