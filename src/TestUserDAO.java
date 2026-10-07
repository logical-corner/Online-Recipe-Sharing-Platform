package com.recipe;

import com.recipe.dao.UserDAO;
import com.recipe.model.User;

public class TestUserDAO {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        User user = new User(
                0,
                "Rahul",
                "rahul@gmail.com",
                "12345",
                "EXPLORER"
        );

        boolean result = dao.registerUser(user);

        if (result) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("User registration failed!");
        }
    }
}