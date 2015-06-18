package kickstarter.model.dao.sub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kickstarter.exception.DataBaseException;
import kickstarter.model.dao.connection.ConnectionPool;
import kickstarter.model.entity.Quote;

public class QuotesDAOImpl implements QuotesDAO {
	private ConnectionPool connectionPool;

	public QuotesDAOImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public void addQuote(String quote) throws SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			String sql = getInsertQuery();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, quote);

			statement.executeUpdate();
		}
	}

	@Override
	public Quote getRandomQuote() throws DataBaseException, SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			String sql = getSelectQuery();
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultQuery = statement.executeQuery();

			if (resultQuery.next()) {
				return getQuote(resultQuery);
			} else {
				throw new DataBaseException("no any Quote");
			}
		}
	}

	@Override
	public void createTableQuotes() throws SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			Statement statement = connection.createStatement();
			String sql = getCreateQuery();
			statement.execute(sql);
		}
	}

	private Quote getQuote(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String qoute = result.getString("quote");

		return new Quote(id, qoute);
	}

	private String getInsertQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into Quotes ");
		sql.append("(quote) values(?)");
		return sql.toString();
	}

	private String getSelectQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, quote ");
		sql.append("from Quotes ");
		sql.append("order by random() limit 1");
		return sql.toString();
	}

	private String getCreateQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("drop table IF EXISTS Quotes; ");
		sql.append("create table Quotes (");
		sql.append("id serial not null PRIMARY KEY, ");
		sql.append("quote varchar(255)");
		sql.append(")");
		return sql.toString();
	}
}
