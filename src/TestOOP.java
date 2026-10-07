package com.recipe;

import com.recipe.model.Admin;
import com.recipe.model.RecipeContributor;
import com.recipe.model.RecipeExplorer;
import com.recipe.model.User;

public class TestOOP {

    public static void main(String[] args) {

        User user;

        user = new Admin();
        user.displayDashboard();

        user = new RecipeContributor();
        user.displayDashboard();

        user = new RecipeExplorer();
        user.displayDashboard();
    }
}