package ua.home.kickstarter.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import ua.home.kickstarter.model.Quote;

public class QuotationsDao {

	private Connection connection;

	public Quote getSpecificQuoteFromDB(Random random) throws SQLException {
		int index = random.nextInt((int) size());
		Quote quote = new Quote();
		String sql = "SELECT * FROM quotations WHERE id = ?";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, index+1);
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
