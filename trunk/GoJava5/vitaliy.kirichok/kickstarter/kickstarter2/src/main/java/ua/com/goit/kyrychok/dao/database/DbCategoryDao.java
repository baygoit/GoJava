package ua.com.goit.kyrychok.dao.database;

import ua.com.goit.kyrychok.dao.CategoryDao;
import ua.com.goit.kyrychok.domain.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbCategoryDao implements CategoryDao {
    private DbDataSourceProvider dbDataSourceProvider;
    private DbProjectDao dbProjectDao;
    private CategorySqlProvider sqlProvider;

    public DbCategoryDao(DbDataSourceProvider dbDataSourceProvider, DbProjectDao dbProjectDao, CategorySqlProvider sqlProvider) {
        this.dbDataSourceProvider = dbDataSourceProvider;
        this.dbProjectDao = dbProjectDao;
        this.sqlProvider = sqlProvider;
    }

    @Override
    public String getWelcomeMessage() {
        String result = "";
        try (Connection connection = dbDataSourceProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlProvider.get4GetWelcomeMessage())) {
            if (resultSet.next()) {
                result = resultSet.getString("message");
            }
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Category> fetch() {
        List<Category> result = new ArrayList<>();
        try (Connection connection = dbDataSourceProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlProvider.get4Fetch())) {
            while (resultSet.next()) {
                Category category = new Category(resultSet.getString("name"));
                category.setId(resultSet.getInt("id"));
                result.add(category);
            }
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Category get(int id) {
        Category result = null;
        try (Connection connection = dbDataSourceProvider.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sqlProvider.get4Get())) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    result = new Category(resultSet.getString("category_name"));
                    result.setId(id);
                }
            }
            result.setProjects(dbProjectDao.fetch(id, connection));
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void add(Category category) {
        try (Connection connection = dbDataSourceProvider.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sqlProvider.get4Add(), new String[]{"category_id"})) {
                statement.setString(1, category.getName());
                statement.executeUpdate();
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        category.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Can't receive category ID.");
                    }
                }
            }
            dbProjectDao.addList(category.getId(), category.getProjects(), connection);
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
