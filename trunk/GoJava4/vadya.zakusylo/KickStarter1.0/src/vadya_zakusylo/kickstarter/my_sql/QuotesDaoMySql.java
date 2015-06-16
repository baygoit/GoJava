package vadya_zakusylo.kickstarter.my_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vadya_zakusylo.kickstarter.model.Quote;
import vadya_zakusylo.kickstarter.model.dao.QuotesDao;

public class QuotesDaoMySql extends QuotesDao {
	private Connection connection;
	private List<Quote> quotes = new ArrayList<Quote>();

	public QuotesDaoMySql(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Quote> getQuotesList() {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuotes());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				quotes.add(new Quote(resultSet.getString("quotes_q.quote"), resultSet
						.getString("quotes_a.autor")));
			}
		} catch (SQLException e) {
			System.out.println("Can't connect to table \"Quotes\"");
		}
		return quotes;
	}

	private String selectQuotes() {
		StringBuilder sql = new StringBuilder();
		sql.append("select quotes_q.quote,  quotes_a.autor ");
		sql.append("from quotes_q natural join quotes_a;");
		return sql.toString();
	}
}
