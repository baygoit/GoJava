package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.goit.gojava7.kickstarter.config.DBConnectionManager;
import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class QuoteDaoSqlImpl implements QuoteDao {
	private DBConnectionManager connectionManager;

	public QuoteDaoSqlImpl(DBConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public Quote getRandomQuote() {
		Quote quote = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = connectionManager.getConnection();
			stmt = conn.prepareStatement("SELECT text, author FROM quote order by random() limit 1 ");
			rset = stmt.executeQuery();

			while (rset.next()) {
				String text = rset.getString("text");
				String author = rset.getString("author");
				quote = new Quote(text, author);
			}
		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		} finally {
            try { if (rset != null) rset.close(); } catch(Exception e) { }
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
		}

		return quote;
	}

}
