package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDataSource;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryPostgreDAO implements CategoryDAO, JdbcDataSource<Category> {

    private JdbcDispatcher dispatcher;
    
    public CategoryPostgreDAO(JdbcDispatcher dispatcher) {
        this.dispatcher = dispatcher;
        System.out.println("CategoryPostgreDAO created");
    }

    @Override 
    public void clear() {
        String sql = "delete from category";
        dispatcher.clear(sql);       
    }

    @Override 
    public Category get(int index) {
        String sql = "select id, name from category where id = " + index;
        List<Category> result = dispatcher.get(sql, this);
        Category category = null;
		if (!result.isEmpty()) {
        	category = result.get(0);
		}
        return category;
    }

    @Override    
    public void add(Category element) {
        String sql = "insert into category (id, name) values (?, ?)";
        dispatcher.add(sql, element, this);
    }

    @Override
    public void addAll(List<Category> elemens) {
        String sql = "insert into category (id, name) values (?, ?)";
        dispatcher.add(sql, elemens, this);        
    }

    @Override
    public List<Category> getAll() {
        String sql = "select id, name from category";
        List<Category> result = dispatcher.get(sql, this);               
        return result;
    }

	@Override
	public Category read(ResultSet resultSet) throws SQLException {
		Category category = new Category(
                resultSet.getInt("id"), 
                resultSet.getString("name"));
		return category;
	}

	@Override
	public void prepare(Category element, PreparedStatement statement) throws SQLException {
		statement.setInt(1, element.getId());
		statement.setString(2, element.getName());
	}
}
