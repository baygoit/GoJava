package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.dao.DatabaseDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
@Component
public class QuoteDatabaseDao extends DatabaseDao<Quote> {

    private static String table  = "quotes";
    private static String fields = "text, author";

public QuoteDatabaseDao(DataSource dataSource) {
    this.dataSource = dataSource;
}public QuoteDatabaseDao() {
    // TODO Auto-generated constructor stub
}

    public Quote getRandomQuote() {
        String query = "SELECT " + fields + " FROM " + table + " order by rand() limit 1 ";
        if(dataSource != null){
            System.out.println("Not null"); 
        }else{
            System.out.println("Fucking null");
        }
        try (PreparedStatement ps = getConnection().prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                return readElement(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NoSuchElementException();
    }
    
    
    @Override
    protected Quote readElement(ResultSet resultSet) throws SQLException {
        Quote quote = new Quote();
        quote.setText(resultSet.getString("text"));
        quote.setAuthor(resultSet.getString("author"));
        return quote;
    }

    public void add(Quote element) {
        String query = "insert into quote (text, author) values (?, ?)";
        try (PreparedStatement ps = dataSource.getConnection().prepareStatement(query)) {
            ps.setString(1, element.getText());
            ps.setString(2, element.getAuthor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }


    @Override
    public Quote getByNumber(int number) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void setAll(List<Quote> data) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public List<Quote> getAll() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Quote get(int index) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

}
