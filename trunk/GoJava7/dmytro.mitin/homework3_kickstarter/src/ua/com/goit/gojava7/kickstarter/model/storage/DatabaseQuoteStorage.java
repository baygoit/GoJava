package ua.com.goit.gojava7.kickstarter.model.storage;

import ua.com.goit.gojava7.kickstarter.model.Quote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DatabaseQuoteStorage implements QuoteStorage {
    public DatabaseQuoteStorage() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/kickstarter","postgres", "password");
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Quote> getQuotes() {
        return null;
    }

    @Override
    public void add(Quote quote) {

    }
}
