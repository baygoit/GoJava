package ua.com.sas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.sas.model.*;

@Component
public class CategoriesDAO extends AbstractDAO implements Categories {
	
	private List<Category> categories = new ArrayList<Category>();
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void add(Category category) {
		 Session session = this.sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.persist(category);
	        tx.commit();
	        session.close();
//		try (Connection connection = getConnection()) {
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("INSERT INTO categories (name) VALUES (\'" + category.getName() + "\') RETURNING id");
//			while (rs.next()){
//				category.setId(rs.getInt(1));
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException("Connection Failed! Check output console", e);
//		}
	}

	@Override
	public List<Category> getCategories() {
		Session session = this.sessionFactory.openSession();
        categories = session.createQuery("FROM Category").list();
        session.close();
		return categories;
//		try (Connection connection = getConnection()) {
//			List<Category> categories = new ArrayList<Category>();
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("SELECT * FROM categories");
//			while (rs.next()){
//				categories.add(new Category(rs.getInt(1), rs.getString(2)));
//			}
//			return categories;
//		} catch (SQLException e) {
//			throw new RuntimeException("Connection Failed! Check output console", e);
//		}
	}
	
	@Override
	public Category get(int id) {
		try (Connection connection = getConnection()) {
			Category category = null;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM categories WHERE id = " + id);
			while (rs.next()) {
				category = new Category(rs.getInt(1), rs.getString(2));
			}
			return category;
		} catch (SQLException e) {
			throw new RuntimeException("Connection Failed! Check output console", e);
		}
	}

	@Override
	public int size() {
		return categories.size();
//		try (Connection connection = getConnection()) {
//			int size = 0;
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("select count(*) from categories");
//			while (rs.next()) {
//				size = rs.getInt(1);
//			}
//			return size;
//		} catch (SQLException e) {
//			throw new RuntimeException(
//					"Connection Failed! Check output console", e);
//		}
	}

}
