package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuotePostgreDAO implements QuoteDAO {
    
    private JdbcDispatcher dispatcher;
    
    public QuotePostgreDAO(JdbcDispatcher dispatcher) {
        this.dispatcher = dispatcher;
        System.out.println("QuotePostgreDAO created");
    }

    @Override
    public List<Quote> getAll() {
        String sql = "select text, author from quote";
        List<Quote> result = new ArrayList<>();
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Quote quote = new Quote(
                        resultSet.getString("author"), 
                        resultSet.getString("text"));
                result.add(quote);
            }
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        }
        return result;
    }

    @Override
    public Quote get(int index) {
        String sql = "select text, author from quote limit 1 offset " + index;
        Quote quote = null;
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                quote = new Quote(
                        resultSet.getString("author"), 
                        resultSet.getString("text"));
            }
        } catch (SQLException e) {
            dispatcher.processException(e);
        }
        return quote;
    }

    @Override
    public void add(Quote element) {
        String sql = "insert into quote (text, author) values (?, ?)";
        try(Connection connection = dispatcher.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, element.getText());
            statement.setString(2, element.getAuthor());
            statement.executeUpdate();  
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        } 
    }

    @Override
    public void addAll(List<Quote> elemens) {      
        String sql = "insert into quote (text, author) values (?, ?)";
        try(Connection connection = dispatcher.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Quote element : elemens) {
                statement.setString(1, element.getText());
                statement.setString(2, element.getAuthor());
                statement.executeUpdate(); 
            } 
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        } 
    }

    @Override
    public void clear() {
        String sql = "delete from quote";
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement()) {
            statement.execute(sql);
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        }
    }
}
