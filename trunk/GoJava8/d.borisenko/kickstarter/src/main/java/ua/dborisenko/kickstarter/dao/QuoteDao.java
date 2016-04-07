package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import ua.dborisenko.kickstarter.domain.Quote;

public class QuoteDao extends DaoSql {
    private static final String QUERY_SELECT_RANDOM_QUOTE = "SELECT id, author, text FROM quotes order by rand() limit 1";

    public Quote getRandomQuote() {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_SELECT_RANDOM_QUOTE);
            ResultSet rs = statement.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            String author = rs.getString("author");
            String text = rs.getString("text");
            Quote quote = new Quote();
            quote.setId(id);
            quote.setAuthor(author);
            quote.setText(text);
            closeStatement(statement);
            return quote;
        } catch (SQLException | NullPointerException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}
