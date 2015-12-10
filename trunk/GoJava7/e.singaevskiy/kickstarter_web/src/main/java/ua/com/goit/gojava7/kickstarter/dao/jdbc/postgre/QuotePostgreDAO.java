package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDataSource;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuotePostgreDAO implements QuoteDAO, JdbcDataSource<Quote>  {
    
    private JdbcDispatcher dispatcher;
    
    public QuotePostgreDAO(JdbcDispatcher dispatcher) {
        this.dispatcher = dispatcher;
        System.out.println("QuotePostgreDAO created");
    }

    @Override
    public List<Quote> getAll() {
        String sql = "select text, author from quote";       
        List<Quote> result = dispatcher.get(sql, this);
        return result;
    }

    @Override
    public Quote get(int index) {
        String sql = "select text, author from quote limit 1 offset " + index;
        Quote quote = null;
        List<Quote> list = dispatcher.get(sql, this);
		if (!list.isEmpty()) {
			quote = list.get(0);
		}
        return quote;
    }

    @Override
    public void add(Quote element) {
        String sql = "insert into quote (text, author) values (?, ?)";
        dispatcher.add(sql, element, this);
    }

    @Override
    public void addAll(List<Quote> elemens) {      
        String sql = "insert into quote (text, author) values (?, ?)";
        dispatcher.add(sql, elemens, this); 
    }

    @Override
    public void clear() {
        String sql = "delete from quote";
        dispatcher.clear(sql);
    }

	@Override
	public Quote read(ResultSet resultSet) throws SQLException {
		Quote quote = new Quote(
                resultSet.getString("author"), 
                resultSet.getString("text"));
		return quote;
	}

	@Override
	public void prepare(Quote element, PreparedStatement statement) throws SQLException {
		 statement.setString(1, element.getText());
         statement.setString(2, element.getAuthor());
	}
}
