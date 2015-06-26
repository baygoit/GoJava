package com.ivanpozharskyi.kickstarter.DAO;

import java.sql.*;
import java.util.Random;

import com.ivanpozharskyi.kickstarter.entity.Quote;
import com.ivanpozharskyi.kickstarter.entity.Quotes;

public class QuotesDao  implements Quotes{
	private Connection con;
	private Quote quote;
	
	public void deleteQuote(int id) throws SQLException{
		con = ConnectionManager.getConnection();
		String query = "DELETE FROM quotes WHERE id = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		
	}
	public void addQuote(Quote quote) throws SQLException{
		con = ConnectionManager.getConnection();
		String query = "INSERT INTO quotes (name) VALUES (?)";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, quote.getName());
		preparedStatement.execute();
		
	}
	public Quote getRandom() throws SQLException {
		
		con = ConnectionManager.getConnection();
		String query = "SELECT name FROM quotes ORDER BY RANDOM() LIMIT 1";
		Statement statement = con.createStatement();

		ResultSet resultSet = statement.executeQuery(query);
		while(resultSet.next()){
			String quoteName = resultSet.getString("name");
			 quote = new Quote(quoteName);
		}

		return quote;
	}
	public int getSize() throws SQLException{
		int size;
		con = ConnectionManager.getConnection();
		String query = "SELECT count(*) AS size FROM quotes  ";
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while(resultSet.next()){
			return size = resultSet.getInt("size");
		}
		throw new RuntimeException("Quotes is empty");
	}
//	public static void main(String[] args) throws SQLException {
//		QuotesDao quotesDao = new QuotesDao();
//		System.out.println(quotesDao.getRandom().toString());
//		quotesDao.deleteQuote(6);
//		System.out.println(quotesDao.getSize());
//		
//		
//	}


	
}
