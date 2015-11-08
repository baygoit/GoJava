package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import ua.com.goit.gojava2.vova.kickstarter.util.Random;

@Component
public class QuotesDAO extends AbstractDAO implements Quotes{
	
	private static Logger log = Logger.getLogger(QuotesDAO.class.getName());
	
	@Override
	public String getQuote() {
		StringBuilder s = new StringBuilder();
//		int random = Random.random(getCountQuote());
//		
//		try (Connection connection = getConnection()){
//			Statement statement = connection.createStatement();
//			ResultSet result = statement.executeQuery("SELECT * FROM quotes WHERE id_quote =" + random);
//			while (result.next()) {
//				s.append(result.getString("quote")).toString();
//			}
//		} catch (SQLException e) {
//			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//			log.log(Level.SEVERE, null, e);
//		}
		return s.toString();
	}
	
	public int getCountQuote() {
		int countQuote = 0;
//		try (Connection connection = getConnection()){
//			Statement statement = connection.createStatement();
//			ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM quotes;");
//			while (result.next()) {
//				countQuote = result.getInt("count");
//			}
//		} catch (SQLException e) {
//			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//			log.log(Level.SEVERE, null, e);
//		}
		return countQuote;
	}
}
