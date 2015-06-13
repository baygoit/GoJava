package edu.kickstarter.DAO.quote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import edu.kickstarter.DAO.Dao;
import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Quote;

public class DBquoteService implements QuoteService {

	@Override
	public Quote getRandomQuote() throws KickstarterException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Quote quote = null;
		Dao.getInstance();
		connection = Dao.getDatabaseService().getConnection();
		try {
			StringBuffer sql = new StringBuffer();
			statement = connection.createStatement();
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
			throw new KickstarterException(
					"getRandomQuote exception", e);
		}
		try {
			Dao.getDatabaseService().closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return quote;
	}
}