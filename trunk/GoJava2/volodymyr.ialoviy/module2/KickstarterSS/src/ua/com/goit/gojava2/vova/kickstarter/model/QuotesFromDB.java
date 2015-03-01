package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.goit.gojava2.vova.kickstarter.util.ConnectToDB;

public class QuotesFromDB implements Quotes{
	
	@Override
	public String getQuote() {
		StringBuilder s = new StringBuilder();
		int countQuote = 0;
			
		ResultSet result;
		ResultSet result1;
		try {
			result1 = ConnectToDB.statement.executeQuery("SELECT COUNT(*) FROM quotes;");
			while (result1.next()) {
				countQuote = result1.getInt("count");
			}
			int random = random(countQuote);
			result = ConnectToDB.statement.executeQuery("SELECT * FROM quotes WHERE id_quote =" + random);
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
