package edu.kickstarter.DAO.quote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import edu.kickstarter.DAO.Dao;
import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Quote;

public class DBquoteService implements QuoteService {

	@Override
	public Quote getRandomQuote() throws KickstarterException {
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Quote quote = null;
		conn = Dao.getDatabaseService().getConnection();
		try {
			StringBuffer sql = new StringBuffer();
			statement = conn.createStatement();
			sql.append("select id, quote ");
			sql.append("from quotes ");
			sql.append("order by random() limit 1");
			resultSet = statement.executeQuery(sql.toString());
			resultSet.next();
			int id = resultSet.getInt("id");
			quote = new Quote();
			quote.setID(id);
			quote.setQuote(resultSet.getString("quote"));

		} catch (SQLException e) {
			quote = null;
		}

		finally {
			// Always make sure result sets and statements are closed,
			// and the connection is returned to the pool
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					;
				}
				resultSet = null;
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					;
				}
				statement = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					;
				}
				conn = null;
			}
		}

		if (quote == null) {
			throw new KickstarterException("SQLException");
		}
		return quote;
	}

	@Override
	public List<Quote> getAll() {
		return null;
	}
}