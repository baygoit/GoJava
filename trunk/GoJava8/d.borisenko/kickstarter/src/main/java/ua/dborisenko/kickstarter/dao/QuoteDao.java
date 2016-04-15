package ua.dborisenko.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Quote;

@Repository
public class QuoteDao {

    private final class QuoteRowMapper implements RowMapper<Quote> {
        @Override
        public Quote mapRow(ResultSet rs, int rowNum) throws SQLException {
            Quote quote = new Quote();
            quote.setAuthor(rs.getString("author"));
            quote.setText(rs.getString("text"));
            return quote;
        }
    }

    private static final String QUERY_SELECT_RANDOM_QUOTE = "SELECT id, author, text FROM quotes order by rand() limit 1";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Quote getRandom() {
        return jdbcTemplate.queryForObject(QUERY_SELECT_RANDOM_QUOTE, new QuoteRowMapper());
    }
}
