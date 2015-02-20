package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuotesFromDB implements Quotes{

	private static final String PASS_DB = "7575";//TODO delete duplicate with ATHER CLASS
	private static final String NAME_DB = "postgres";
	private static final String JDBC_POSTGRESQL_PATH = "jdbc:postgresql://127.0.0.1:5432/kickstarter";
	
	public static void main(String[] args) {
		QuotesFromDB quotes = new QuotesFromDB();

		System.out.println(quotes.getQuote());
	}
	
	@Override
	public String getQuote() {
		String s = "";
		Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            Statement statement = null;
            statement = connection.createStatement();
            int countQuote = 0;
            ResultSet result1 = statement.executeQuery("SELECT COUNT(*) FROM quotes;");
            while (result1.next()) {
            	System.out.println(result1.getInt("count"));
                countQuote = result1.getInt("count");
            }
            
            int random = random(countQuote);
            
            ResultSet result = statement.executeQuery("SELECT * FROM quotes WHERE id_quote =" + random);
            while (result.next()) {
                s += result.getString("quote");
            }
        } catch (Exception ex) {
            Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
		return s;
	}

	@Override
	public int random(int countQuote) {
		return (int) (Math.random() * countQuote + 0.5);
	}

}
