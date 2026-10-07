package com.recipe.model;

public class Admin extends User {

    public Admin() {
        setRole("ADMIN");
    }

    public Admin(int id, String name, String email, String password) {

        super(id, name, email, password, "ADMIN");
    }

    @Override
    public void displayDashboard() {

        System.out.println("Admin Dashboard");
    }

    public void manageUsers() {

        System.out.println("Admin is managing users.");
    }

    public void approveRecipe() {

        System.out.println("Admin approved the recipe.");
    }

    public void rejectRecipe() {

        System.out.println("Admin rejected the recipe.");
    }
}