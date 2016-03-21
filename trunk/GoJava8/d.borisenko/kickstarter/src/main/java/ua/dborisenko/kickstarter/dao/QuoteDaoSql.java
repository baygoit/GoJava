package ua.dborisenko.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.dborisenko.kickstarter.domain.Quote;

public class QuoteDaoSql extends DaoSql implements QuoteDao {

    @Override
    public Quote getRandomQuote() {
        try (Statement statement = getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT id, author, text FROM quotes order by rand() limit 1");
            rs.next();
            int id = rs.getInt("id");
            String author = rs.getString("author");
            String text = rs.getString("text");
            return new Quote(id, author, text);
        } catch (SQLException | NullPointerException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}
