package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Quote;

@Repository
public class QuoteDao {
    private static final String QUERY_SELECT_RANDOM_QUOTE = "SELECT id, author, text FROM quotes order by rand() limit 1";
    @Autowired
    private DataSource dataSource;

    public Quote getRandomQuote() {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(QUERY_SELECT_RANDOM_QUOTE)) {
            ResultSet rs = statement.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            String author = rs.getString("author");
            String text = rs.getString("text");
            Quote quote = new Quote();
            quote.setId(id);
            quote.setAuthor(author);
            quote.setText(text);
            return quote;
        } catch (SQLException | NullPointerException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}
