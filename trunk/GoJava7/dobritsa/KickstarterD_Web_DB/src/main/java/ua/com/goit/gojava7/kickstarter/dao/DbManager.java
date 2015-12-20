package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Category;
import ua.com.goit.gojava7.kickstarter.models.Project;
import ua.com.goit.gojava7.kickstarter.models.Quote;

@Component
public class DbManager {

	private static final Logger log = LoggerFactory.getLogger(DbManager.class);

	@Autowired
	protected BasicDataSource basicDataSource;

	public DbManager() {
		log.info("Constructor QuoteDbDao()...");
	}
	
	public int size(String query) {
		log.info("<int> size({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				//TODO find cnt
				return resultSet.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Quote getQuote(String query) {
		log.info("<Quote> getQuote({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return readQuote(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Quote readQuote(ResultSet resultSet) throws SQLException {
		log.info("<Quote> readElement()...");
		Quote quote = new Quote();
		quote.setText(resultSet.getString("text"));
		quote.setAuthor(resultSet.getString("author"));
		log.debug("readElement() returned quote: {}", quote);
		return quote;
	}

	public List<Category> getCategories(String query) {
		List<Category> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readCategory(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public Category getCategory(String query) {
		log.info("<Category> getCategory({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return readCategory(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	private Category readCategory(ResultSet resultSet) throws SQLException {
		log.info("<Category> readElement()...");
		Category category = new Category();
		category.setId(resultSet.getInt("id"));
		category.setName(resultSet.getString("name"));
		log.debug("readElement() returned category: {}", category);
		return category;
	}	
	
	public List<Project> getProjects(String query) {
		List<Project> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readProject(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public Project getProject(String query) {
		log.info("<Project> getProject({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return readProject(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Project readProject(ResultSet resultSet) throws SQLException {
		log.info("<Project> readProject()...");			
		Project project = new Project();
		project.setId(resultSet.getInt("id"));
		project.setName(resultSet.getString("name"));
		project.setDescription(resultSet.getString("description"));
		project.setGoal(resultSet.getInt("goal"));
		project.setPledged(resultSet.getInt("pledged"));
		project.setDaysToGo(resultSet.getInt("daysToGo"));
		project.setHistory(resultSet.getString("history"));
		project.setLink(resultSet.getString("link"));
		project.setCategoryId(resultSet.getInt("category_id"));
		log.debug("readElement() returned project: {}", project);
		return project;
	}
	
	public void updatePledged(Project project, String query) {
		log.info("updatePledged({})...", query);		
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	private String prepareStringForDb(String original) {
		log.info("prepareStringForDb({original})...");	
		return original.replace("'", "\\'");
	}	*/

	

	
}
