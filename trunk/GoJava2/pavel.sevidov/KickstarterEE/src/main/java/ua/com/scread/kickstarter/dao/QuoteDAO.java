package ua.com.scread.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import ua.com.scread.kickstarter.data.Category;

public class QuoteDAO {

	private Random random = new Random();
	private Connection connection;
	private String quote = "";
	
	public QuoteDAO(Connection connection) {
		this.connection = connection;
	}
	
	public String getQuote() {		
		int index = random.nextInt(size());
		
		return get(index);
	}
	
    public void add(final Category category) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into quote (quote) values (?)");
            statement.setString(2, category.getName());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Something happend while adding new quote", e);
        }
    }

    public String get(final int id) {
        try {
            Statement statement = connection.createStatement(); 

            ResultSet rs = statement.executeQuery("select * from quotes where id = " + id);
            while (rs.next()) {
                return rs.getString("quote");
            }   
            
            throw new RuntimeException("Not found quote by id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException("Something happend while getting quote by id", e);
        }
    }

    public int size() {
        try {
            Statement statement = connection.createStatement(); 

            ResultSet rs = statement.executeQuery("SELECT count(*) FROM quotes");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Something happend while calculationg quotes size", e);
        }
    }

}
