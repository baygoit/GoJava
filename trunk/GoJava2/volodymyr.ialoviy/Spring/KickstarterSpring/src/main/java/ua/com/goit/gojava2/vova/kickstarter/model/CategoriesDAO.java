package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class CategoriesDAO extends AbstractDAO implements Categories{
	
	private static Logger log = Logger.getLogger(CategoriesDAO.class.getName());
	
	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		try (Connection connection = getConnection()){
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM categories ORDER BY id_category");
			while (result.next()) {
			    categories.add(new Category(result.getInt("id_category"), result.getString("name_category")));
			}
		} catch (SQLException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			log.log(Level.SEVERE, null, e);
		}
		return categories;
	}
}