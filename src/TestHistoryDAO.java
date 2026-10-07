package com.recipe;

import com.recipe.dao.HistoryDAO;

public class TestHistoryDAO {

    public static void main(String[] args) {

        HistoryDAO dao = new HistoryDAO();

        boolean result = dao.addHistory(2, 1);

        if (result) {
            System.out.println("Browsing history added successfully!");
        } else {
            System.out.println("Failed to add browsing history!");
        }

        System.out.println("\nBrowsing History:");

        dao.viewHistory(2);
    }
}