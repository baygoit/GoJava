package ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteDaoMySqlImpl implements QuoteDao {
	private Connection connection;

	public QuoteDaoMySqlImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Quote getRandomQuote() {
		Quote quote = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection
					.prepareStatement("SELECT text, author FROM quote order by rand() limit 1 ");
			rs = ps.executeQuery();

			while (rs.next()) {
				String text = rs.getString("text");
				String author = rs.getString("author");
				quote = new Quote(text, author);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return quote;
	}

}
