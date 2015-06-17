package dao.quote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.pool.KickstarterException;

public class DBquoteService implements QuoteService {
	Connection conn;

	public DBquoteService(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Quote getRandomQuote() throws KickstarterException {
		Statement statement = null;
		ResultSet resultSet = null;
		Quote quote = null;
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

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (quote == null) {
				throw new KickstarterException("quote not found");
			}
		}

		return quote;
	}
}