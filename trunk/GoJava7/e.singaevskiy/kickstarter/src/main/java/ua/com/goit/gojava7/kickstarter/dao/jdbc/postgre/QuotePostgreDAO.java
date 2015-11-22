package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.DataStorage;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.JdbcDispatcher;

public class QuotePostgreDAO implements DataStorage<Quote> {

    private Connection connection;
    
    public QuotePostgreDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Quote> getAll() {
        List<Quote> result = new ArrayList<>();
        new JdbcDispatcher(connection)  {           
            @Override
            public void executeStatement() throws SQLException {
                String sql = "select text, author from quote";
                statement = connection.createStatement(); 
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Quote quote = new Quote(resultSet.getString("author"), 
                            resultSet.getString("text"));
                    result.add(quote);
                }
            }
        }.execute(); 
        return result;
    }

    @Override
    public Quote get(int index) {      
        List<Quote> result = new ArrayList<>();
        new JdbcDispatcher(connection)  {           
            @Override
            public void executeStatement() throws SQLException {
                String sql = "select text, author from quote limit 1 offset " + index;
                statement = connection.createStatement(); 
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    Quote quote = new Quote(resultSet.getString("author"), 
                            resultSet.getString("text"));
                    result.add(quote);
                }
            }
        }.execute(); 
        
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public void add(Quote element) {
        new JdbcDispatcher(connection)  {           
            @Override
            public void executeStatement() throws SQLException {
                String sql = "insert into quote (text, author) values (?, ?);";
                preparedStatement = connection.prepareStatement(sql); 
                preparedStatement.setString(1, element.getText());
                preparedStatement.setString(2, element.getAuthor());
                preparedStatement.executeUpdate();                
            }
        }.execute();   
    }

    @Override
    public void addAll(List<Quote> elemens) {       
        new JdbcDispatcher(connection)  {           
            @Override
            public void executeStatement() throws SQLException {
                String sql = "insert into quote (text, author) values (?, ?);";
                preparedStatement = connection.prepareStatement(sql); 
                
                for (Quote quote : elemens) {
                    preparedStatement.setString(1, quote.getText());
                    preparedStatement.setString(2, quote.getAuthor());
                    preparedStatement.executeUpdate();
                }  
            }
        }.execute();    
    }

    @Override
    public void clear() {
        new JdbcDispatcher(connection)  {           
            @Override
            public void executeStatement() throws SQLException {
                String sql = "delete from quote";
                statement = connection.createStatement(); 
                statement.execute(sql);              
            }
        }.execute();
    }
}
