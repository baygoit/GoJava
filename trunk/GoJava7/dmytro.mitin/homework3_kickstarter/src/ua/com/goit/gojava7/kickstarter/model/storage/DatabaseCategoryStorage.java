package ua.com.goit.gojava7.kickstarter.model.storage;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseCategoryStorage implements CategoryStorage {
    private Connection connection;

    private String categoryTable;

    private String projectTable;

    public DatabaseCategoryStorage(String categoryTable, String projectTable) {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/kickstarter", "postgres", "password");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.categoryTable = categoryTable;
        this.projectTable = projectTable;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();

        String categoryQuery = "SELECT name FROM " + categoryTable;
        try (PreparedStatement statement = connection.prepareStatement(categoryQuery))
        {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                categories.add(new Category(name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String projectQuery = "SELECT name, category, \"shortDescription\", description, history, \"videoUrl\"," +
                " \"moneyNeeded\", \"daysLeft\" FROM " + projectTable;
        try (PreparedStatement statement = connection.prepareStatement(projectQuery))
        {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String projectName = result.getString("name");
                String projectCategoryName = result.getString("category");
                String shortDescription = result.getString("shortDescription");
                String description = result.getString("description");
                String history = result.getString("history");
                String videoUrl = result.getString("videoUrl");
                int moneyNeeded = result.getInt("moneyNeeded");
                int daysLeft = result.getInt("daysLeft");

                Category category = null;
                for (Category currentCategory : categories) {
                    if (currentCategory.getName().equals(projectCategoryName)) {
                        category = currentCategory;
                        break;
                    }
                }

                if (category == null) {
                    category = new Category(projectCategoryName);
                    categories.add(category);
                }

                new Project(projectName, category, shortDescription, description,
                        history, videoUrl, moneyNeeded, daysLeft);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public void add(Category category) {
        String categoryQuery = "INSERT INTO " + categoryTable + " (name) VALUES (?)";
        try {
            PreparedStatement statement = connection.prepareStatement(categoryQuery);
            statement.setString(1, category.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            List<Project> projects = category.getProjects();

            for (Project project : projects) {
                String projectQuery = "INSERT INTO " + projectTable + " (name, category, \"shortDescription\", " +
                        "description, history, \"videoUrl\", \"moneyNeeded\", \"daysLeft\") VALUES (?,?,?,?,?,?,?,?)";

                PreparedStatement statement = connection.prepareStatement(projectQuery);
                statement.setString(1, project.getName());
                statement.setString(2, project.getCategory().getName());
                statement.setString(3, project.getShortDescription());
                statement.setString(4, project.getDescription());
                statement.setString(5, project.getHistory());
                statement.setString(6, project.getVideoUrl());
                statement.setInt(7, project.getMoneyNeeded());
                statement.setInt(8, project.getDaysLeft());
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void shutDown() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
