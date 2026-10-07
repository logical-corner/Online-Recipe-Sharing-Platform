package com.recipe;

import com.recipe.dao.UserDAO;
import com.recipe.model.User;

public class TestLogin {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        User user = dao.loginUser(
                "rahul@gmail.com",
                "12345"
        );

        if (user != null) {
            System.out.println("Login successful!");
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Role: " + user.getRole());
        } else {
            System.out.println("Invalid email or password!");
        }
    }
}