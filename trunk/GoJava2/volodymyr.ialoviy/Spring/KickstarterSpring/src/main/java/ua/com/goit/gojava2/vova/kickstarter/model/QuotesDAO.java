package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;


public class QuotesDAO implements Quotes{
	
	private DataSource dataSource;
	
	public QuotesDAO(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	private Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	@Override
	public String getQuote() {
		StringBuilder s = new StringBuilder();
		int countQuote = 0;
		ResultSet result;
		ResultSet result1;
		try {
			Statement statement = getConnection().createStatement();
			result1 = statement.executeQuery("SELECT COUNT(*) FROM quotes;");
			while (result1.next()) {
				countQuote = result1.getInt("count");
			}
			int random = random(countQuote);
			result = statement.executeQuery("SELECT * FROM quotes WHERE id_quote =" + random);
			while (result.next()) {
				s.append(result.getString("quote")).toString();
			}
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}

		return s.toString();
	}

	@Override
	public int random(int countQuote) {
		return (int) (Math.random() * countQuote + 0.5);
	}

}
