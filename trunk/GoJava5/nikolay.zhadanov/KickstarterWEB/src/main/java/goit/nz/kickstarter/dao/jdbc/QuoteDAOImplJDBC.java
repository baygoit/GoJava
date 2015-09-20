package goit.nz.kickstarter.dao.jdbc;

import goit.nz.kickstarter.dao.QuoteDAO;
import goit.nz.kickstarter.domain.Quote;
import goit.nz.kickstarter.storage.DataProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuoteDAOImplJDBC implements QuoteDAO {
	private DataProvider storage;

	public QuoteDAOImplJDBC(DataProvider storage) {
		this.storage = storage;
	}

	@Override
	public List<Quote> getQuotes() {
		List<Quote> allQuotes = new ArrayList<>();
		String sql = "SELECT text, author FROM quotes";
		try (Connection conn = storage.getConnection()) {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String quoteText = resultSet.getString("text");
				String quoteAuthor = resultSet.getString("author");
				allQuotes.add(new Quote(quoteText, quoteAuthor));
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allQuotes;
	}
}
