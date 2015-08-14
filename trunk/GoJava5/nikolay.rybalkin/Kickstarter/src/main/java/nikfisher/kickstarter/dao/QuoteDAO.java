package nikfisher.kickstarter.dao;

import nikfisher.kickstarter.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class QuoteDAO {

    final private Random RANDOM;
    Connection connection = ConnectDB.getDBConnection();

    private ResultSet getResultSet() throws SQLException {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        return statement.executeQuery("SELECT * FROM quote");
    }

    public QuoteDAO(Random random) {
        this.RANDOM = random;
    }

    public String quoteGenerate() {

        List<String> motivators = new ArrayList<>();

        try {
            ResultSet rs = getResultSet();
            while (rs.next()) {
                motivators.add(rs.getString("quote"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error query! (method getCategories()", e);
        }

        int index = RANDOM.nextInt(motivators.size());

        return motivators.get(index);
    }

}