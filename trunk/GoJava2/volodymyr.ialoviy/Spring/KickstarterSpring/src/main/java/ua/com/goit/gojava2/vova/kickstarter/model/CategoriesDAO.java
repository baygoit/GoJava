package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class CategoriesDAO extends AbstractDAO implements CategoriesInt{
	
//	private static Logger log = Logger.getLogger(CategoriesDAO.class.getName());
	
	@Override
	public List<Category> getCategories() {

        return (List<Category>) getSession().createQuery("from ua.com.goit.gojava2.vova.kickstarter.model.Category").list();
    }
	
//	@Override
//	public List<Category> getCategories() {
//
//		getSession().beginTransaction();
//	    List<Category> result = (List<Category>) getSession().createQuery("from ua.com.goit.gojava2.vova.kickstarter.model.Category").list();
//	    getSession().getTransaction().commit();
//	    return result;
//    }
	
	 
	    
	    
//	@Override
//	public List<Category> getCategories() {
//		List<Category> categories = new ArrayList<Category>();
//		try (Connection connection = getConnection()){
//			Statement statement = connection.createStatement();
//			ResultSet result = statement.executeQuery("SELECT * FROM categories ORDER BY id_category");
//			while (result.next()) {
//			    categories.add(new Category(result.getInt("id_category"), result.getString("name_category")));
//			}
//		} catch (SQLException e) {
//			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//			log.log(Level.SEVERE, null, e);
//		}
//		return categories;
//	}
	
//	@Override
//	public List<Category> getCategories() {
//		List<Category> categories = new ArrayList<Category>();
//		try (Connection connection = getConnection()){
//			Statement statement = connection.createStatement();
//			ResultSet result = statement.executeQuery("SELECT * FROM categories ORDER BY id_category");
//			while (result.next()) {
//			    categories.add(new Category(result.getInt("id_category"), result.getString("name_category")));
//			}
//		} catch (SQLException e) {
//			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//			log.log(Level.SEVERE, null, e);
//		}
//		return categories;
//	}
}