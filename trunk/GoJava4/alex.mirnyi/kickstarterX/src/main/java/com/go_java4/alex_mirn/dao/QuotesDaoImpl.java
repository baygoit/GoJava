package com.go_java4.alex_mirn.dao;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.go_java4.alex_mirn.data.Quote;

public class QuotesDaoImpl implements QuotesDao {
	private ConnectionPool connectionPool;

	public QuotesDaoImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public void add(Quote quote) throws SQLException {
		String sql = getInsertQuery();
		PreparedStatement statement = connectionPool.getConnection().prepareStatement(sql);

		statement.setString(quote.getId(), quote.toString());

		statement.executeUpdate();
	}

	@Override
	public Quote getRandomQuote() throws SQLException {
		String sql = getSelectRandomQuery();
		PreparedStatement statement = connectionPool.getConnection().prepareStatement(sql);

		ResultSet resultQuery = statement.executeQuery();

		if (resultQuery.next()) {
			return getQuote(resultQuery);
		} else {
			throw new RuntimeException("Can not get any quote");
		}
	}

	@Override
	public void createTableQuotes() throws SQLException {
		Statement statement = connectionPool.getConnection().createStatement();
		String sql = getCreateQuery();
		statement.execute(sql);
	}

	private Quote getQuote(ResultSet result) throws SQLException {
		int id = result.getInt("quote_id");
		String qoute = result.getString("quote_name");

		return new Quote(id, qoute);
	}

	private String getInsertQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into quote ");
		sql.append("(quote) values(?)");
		return sql.toString();
	}

	private String getSelectRandomQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("select quote_id, quote_name ");
		sql.append("from quote ");
		sql.append("order by random() limit 1");
		return sql.toString();
	}

	private String getCreateQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("drop table IF EXISTS quote; ");
		sql.append("create table quote (");
		sql.append("quote_id serial not null PRIMARY KEY, ");
		sql.append("quote_name varchar(255)");
		sql.append(")");
		return sql.toString();
	}
}