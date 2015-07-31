package ua.goit.kyrychok.kickstarter.dao.database;

import ua.goit.kyrychok.kickstarter.dao.CategoryDao;
import ua.goit.kyrychok.kickstarter.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbCategoryDao implements CategoryDao {
    private DbDataSourceProvider dbDataSourceProvider;
    private DbProjectDao dbProjectDao;

    public DbCategoryDao(DbDataSourceProvider dbDataSourceProvider, DbProjectDao dbProjectDao) {
        this.dbDataSourceProvider = dbDataSourceProvider;
        this.dbProjectDao = dbProjectDao;
    }

    @Override
    public String getWelcomeMessage() {
        String result = "";
        String sql = "SELECT m.text AS message " +
                "FROM message m " +
                "WHERE rownum = 1 ";
        try (Connection connection = dbDataSourceProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result = resultSet.getString("message");
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Category> fetch() {
        List<Category> result = new ArrayList<>();
        String sql = "SELECT c.category_id AS id, " +
                "c.name AS NAME " +
                " FROM category c " +
                " ORDER BY c.name ";
        try (Connection connection = dbDataSourceProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Category category = new Category(resultSet.getString("name"));
                category.setId(resultSet.getInt("id"));
                result.add(category);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Category get(int id) {
        Category result = null;
        String sql = "SELECT c.category_id AS category_id, " +
                "c.name AS category_name " +
                "FROM category c " +
                "WHERE c.category_id = ? ";
        try (Connection connection = dbDataSourceProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = new Category(resultSet.getString("category_name"));
                result.setId(resultSet.getInt("category_id"));
                result.setProjects(dbProjectDao.fetch(id, connection));
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
