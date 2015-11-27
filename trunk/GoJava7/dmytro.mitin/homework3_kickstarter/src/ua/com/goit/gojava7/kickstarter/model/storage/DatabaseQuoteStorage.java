package ua.com.goit.gojava7.kickstarter.model.storage;

import ua.com.goit.gojava7.kickstarter.model.Quote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQuoteStorage implements QuoteStorage {
    private Connection connection = null;

    public DatabaseQuoteStorage() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/kickstarter", "postgres", "password");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Quote> getQuotes() {
        List<Quote> quotes = new ArrayList<>();

        String query = "SELECT text, author FROM quotes";
        try (PreparedStatement statement = connection.prepareStatement(query))
        {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String text = result.getString("text");
                String author = result.getString("author");
                quotes.add(new Quote(text, author));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quotes;
    }

    @Override
    public void add(Quote quote) {
        String query = "INSERT INTO quotes (text, author) VALUES (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, quote.getText());
            statement.setString(2, quote.getAuthor());
            statement.executeUpdate();
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
