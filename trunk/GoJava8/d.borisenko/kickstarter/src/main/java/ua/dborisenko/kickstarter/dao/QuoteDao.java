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

    final class QuoteRowMapper implements RowMapper<Quote> {
        @Override
        public Quote mapRow(ResultSet rs, int rowNum) throws SQLException {
            Quote quote = new Quote();
            quote.setId(rs.getInt("id"));
            quote.setAuthor(rs.getString("author"));
            quote.setText(rs.getString("text"));
            return quote;
        }
    }

    static final String GET_RANDOM_QUERY = "SELECT id, author, text FROM quotes order by rand() limit 1";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private QuoteRowMapper mapper = new QuoteRowMapper();

    public Quote getRandom() {
        return jdbcTemplate.queryForObject(GET_RANDOM_QUERY, mapper);
    }
}
