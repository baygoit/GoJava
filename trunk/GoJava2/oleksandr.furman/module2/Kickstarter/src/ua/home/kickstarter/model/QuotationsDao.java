package ua.home.kickstarter.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.home.kickstarter.content.Quote;

public class QuotationsDao {

	private Connection connection;

	public Quote getQuoteById(int quoteId) throws SQLException {
		Quote quote = new Quote();
		String sql = "SELECT * FROM quotations WHERE id = ?";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, quoteId);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			quote.setQuote(rs.getString("quote"));
		}
		return quote;
	}
	public QuotationsDao(Connection connection) {
		this.connection = connection;
	}
	public long size() throws SQLException {
		long count = 0;
		String sql = "SELECT COUNT(*) AS count FROM quotations";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			count = rs.getLong("count");
		}
		return count;
	}

}
