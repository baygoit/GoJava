package ua.nenya.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import ua.nenya.dao.QuoteDao;
import ua.nenya.project.Quote;

public class QuoteDaoDbImpl implements QuoteDao {
	private Quote quote;

	@Override
	public Quote getRandomQuote(Random random) {
		String query = "SELECT * FROM quotes ORDER BY random()";
		String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
		String user = "postgres";
		String password = "111111";
		
		
		try(Connection connection = DriverManager.getConnection(url, user, password)) {
			
			Statement st = connection.createStatement();
			ResultSet set = st.executeQuery(query);

			while (set.next()) {
				 quote = new Quote(set.getString("quote"));
				 break;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quote;
	}

	@Override
	public void initQuotes() {
		quote = new Quote();
	}

}
