package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.dao.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.JdbcDispatcher;

public class CategoryPostgreDAO implements CategoryStorage {

    private Connection connection;
    
    public CategoryPostgreDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void clear() {
        new JdbcDispatcher(connection)  {           
            @Override
            public void executeStatement() throws SQLException {
                String sql = "delete from category";
                statement = connection.createStatement(); 
                statement.execute(sql);              
            }
        }.execute();
    }

    @Override
    public Category get(int index) {
        List<Category> result = new ArrayList<>();
        new JdbcDispatcher(connection)  {           
            @Override
            public void executeStatement() throws SQLException {
                String sql = "select id, name from category where id = ?";
                preparedStatement = connection.prepareStatement(sql); 
                preparedStatement.setInt(1, index);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Category category = new Category(resultSet.getInt("id"), 
                            resultSet.getString("name"));
                    result.add(category);
                }
            }
        }.execute(); 
        
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public void add(Category element) {
        new JdbcDispatcher(connection)  {           
            @Override
            public void executeStatement() throws SQLException {
                String sql = "insert into category (id, name) values (?, ?);";
                preparedStatement = connection.prepareStatement(sql); 
                preparedStatement.setInt(1, element.getId());
                preparedStatement.setString(2, element.getName());
                preparedStatement.executeUpdate();                
            }
        }.execute();
    }

    @Override
    public void addAll(List<Category> elemens) {
        new JdbcDispatcher(connection)  {           
            @Override
            public void executeStatement() throws SQLException {
                String sql = "insert into category (id, name) values (?, ?);";
                preparedStatement = connection.prepareStatement(sql); 
                
                for (Category category : elemens) {
                    preparedStatement.setInt(1, category.getId());
                    preparedStatement.setString(2, category.getName());
                    preparedStatement.executeUpdate();
                }  
            }
        }.execute();    
    }

    @Override
    public List<Category> getAll() {
        List<Category> result = new ArrayList<>();
        new JdbcDispatcher(connection)  {           
            @Override
            public void executeStatement() throws SQLException {
                String sql = "select id, name from category";
                statement = connection.createStatement(); 
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Category quote = new Category(resultSet.getInt("id"), 
                            resultSet.getString("name"));
                    result.add(quote);
                }
            }
        }.execute(); 
        return result;
    }
}
