package com.recipe;

import com.recipe.dao.AdminDAO;

public class TestAdminDAO {

    public static void main(String[] args) {

        AdminDAO dao = new AdminDAO();

        System.out.println("Pending Recipes:");

        dao.viewPendingRecipes();

        boolean result = dao.approveRecipe(1);

        if (result) {
            System.out.println("Recipe approved successfully!");
        } else {
            System.out.println("Recipe approval failed!");
        }
    }
}