package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.dao.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.JdbcDispatcher;

public class CategoryPostgreDAO implements CategoryStorage {

    private JdbcDispatcher dispatcher;
    
    public CategoryPostgreDAO(JdbcDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void clear() {
        String sql = "delete from category";
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement()) {
            statement.execute(sql);
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        }
    }

    @Override
    public Category get(int index) {
        String sql = "select id, name from category where id = " + index;
        Category category = null;
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);) {    
            if (resultSet.next()) {
                category = new Category(
                        resultSet.getInt("id"), 
                        resultSet.getString("name"));
            }
        } catch (SQLException e) {
            dispatcher.processException(e);
        }
        return category;
    }

    @Override
    public void add(Category element) {
        String sql = "insert into category (id, name) values (?, ?)";
        try(Connection connection = dispatcher.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, element.getId());
            statement.setString(2, element.getName());
            statement.executeUpdate();  
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        }
    }

    @Override
    public void addAll(List<Category> elemens) {
        String sql = "insert into category (id, name) values (?, ?)";
        try(Connection connection = dispatcher.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Category category : elemens) {
                statement.setInt(1, category.getId());
                statement.setString(2, category.getName());
                statement.executeUpdate();
            } 
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        } 
    }

    @Override
    public List<Category> getAll() {
        String sql = "select id, name from category";
        List<Category> result = new ArrayList<>();
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Category category = new Category(
                        resultSet.getInt("id"), 
                        resultSet.getString("name"));
                result.add(category);
            }
        } catch (SQLException e) {
            dispatcher.processException(e);
        }       
        return result;
    }
}
