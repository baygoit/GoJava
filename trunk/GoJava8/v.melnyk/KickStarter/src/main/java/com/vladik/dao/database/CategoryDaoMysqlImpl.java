package com.vladik.dao.database;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vladik.dao.ConnectionProvider;
import com.vladik.model.Category;
import com.vladik.dao.AbstractCategoryDao;

public class CategoryDaoMysqlImpl extends AbstractCategoryDao {
    private static final String INSERT_CATEGORY = "INSERT INTO Categories (name) VALUES (?)";
    private static final String DELETE_CATEGORY = "DELETE FROM Categories WHERE id = ?";
    private static final String SELECT_ALL_CATEGORIES = "SELECT id, name FROM Categories";
    private static final String COUNT_ALL_CATEGORIES = "SELECT count(*) FROM Categories";

    @Override
    public void add(Category category) {
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_CATEGORY);
            statement.setString(2, category.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Category category) {
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY);
            statement.setInt(1, category.getUniqueID());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();

        try {
            Connection connection = ConnectionProvider.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CATEGORIES);

            while (resultSet.next()) {
                Category category = new Category();
                category.setUniqueID(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public int getSize() {
        int amountOfCatrgories = 0;

        try {Connection connection = ConnectionProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(COUNT_ALL_CATEGORIES);
            while (resultSet.next()) {
                amountOfCatrgories = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amountOfCatrgories;
    }
}
