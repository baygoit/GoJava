package kickstarter.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotCreateTableException;
import kickstarter.exception.CannotGetDataException;
import kickstarter.model.engine.Quote;

public class QuotesDAOImpl implements QuotesDAO {

	private Connection connection;

	public QuotesDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void createTableQuotes() throws CannotCreateTableException {
		try {
			Statement statement = connection.createStatement();

			StringBuilder sql = new StringBuilder();
			sql.append("drop table IF EXISTS Quotes; ");
			sql.append("create table Quotes (");
			sql.append("id serial not null PRIMARY KEY, ");
			sql.append("quote varchar(255)");
			sql.append(")");

			statement.execute(sql.toString());

		} catch (SQLException e) {
			throw new CannotCreateTableException(e);
		}
	}

	@Override
	public void addQuote(String quote) throws CannotAddDataException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into Quotes ");
			sql.append("(quote) values(?)");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, quote);

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new CannotAddDataException(e);
		}
	}

	@Override
	public Quote getRandomQuote() throws CannotGetDataException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select id, quote ");
			sql.append("from Quotes ");
			sql.append("order by random() limit 1");

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			ResultSet resultQuery = statement.executeQuery();

			if (resultQuery.next()) {
				return getQuote(resultQuery);
			} else {
				throw new CannotGetDataException("no existing data");
			}
		} catch (SQLException e) {
			throw new CannotGetDataException(e);
		}
	}

	private Quote getQuote(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String qoute = result.getString("quote");

		return new Quote(id, qoute);
	}
}
