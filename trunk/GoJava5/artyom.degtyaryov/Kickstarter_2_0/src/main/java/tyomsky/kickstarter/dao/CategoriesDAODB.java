package tyomsky.kickstarter.dao;

import org.junit.experimental.categories.Categories;
import tyomsky.kickstarter.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAODB implements CategoriesDAO {

    @Override
    public int size() {
        int result = 0;
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:kickstarter;DB_CLOSE_DELAY=-1", "sa", "")) {
            Statement statement = connection.createStatement();
            statement.execute("SELECT COUNT(1) AS count FROM Categories");
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                result = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Category get(int index) {
        Category result = null;
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:kickstarter;DB_CLOSE_DELAY=-1", "sa", "")) {
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FROM Categories WHERE id = " + String.valueOf(index+1));
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                result = new Category(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Category> getAll() {
        List <Category> result = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:kickstarter;DB_CLOSE_DELAY=-1", "sa", "")) {
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FROM Categories");
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                result.add(new Category(rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void add(Category category) {
        String name = category.getName();
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:kickstarter;DB_CLOSE_DELAY=-1", "sa", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Categories (name) values (\'"+ name +"\')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

