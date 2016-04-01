package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.dborisenko.kickstarter.domain.Quote;

public class QuoteDaoSql extends DaoSql implements QuoteDao {

    @Override
    public Quote getRandomQuote() {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, author, text FROM quotes order by rand() limit 1");
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
