package kickstarter.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kickstarter.exception.NoSuchDataException;
import kickstarter.model.engine.Quote;

public class QuotesDAOImpl implements QuotesDAO {
	private ConnectionPool connectionPool;

	public QuotesDAOImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public void addQuote(String quote) throws SQLException {
		String sql = getInsertQuery();
		PreparedStatement statement = connectionPool.getConnection().prepareStatement(sql);

		statement.setString(1, quote);

		statement.executeUpdate();
	}

	@Override
	public Quote getRandomQuote() throws NoSuchDataException, SQLException {
		String sql = getSelectQuery();
		PreparedStatement statement = connectionPool.getConnection().prepareStatement(sql);

		ResultSet resultQuery = statement.executeQuery();

		if (resultQuery.next()) {
			return getQuote(resultQuery);
		} else {
			throw new NoSuchDataException("Quote");
		}
	}

	@Override
	public void createTableQuotes() throws SQLException {
		Statement statement = connectionPool.getConnection().createStatement();
		String sql = getCreateQuery();
		statement.execute(sql);
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
