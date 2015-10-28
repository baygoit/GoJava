package com.ivanpozharskyi.kickstarter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.ivanpozharskyi.kickstarter.entity.Category;
import com.ivanpozharskyi.kickstarter.entity.Project;
import com.ivanpozharskyi.kickstarter.entity.Projects;

public class ProjectsDao implements Projects{
	private Connection connection;
	@Autowired
	CategoriesDAO categories;
	@Autowired
	ConnectionManager connectionManager;
	
	public ProjectsDao(ConnectionManager connectionManager, CategoriesDAO categories) {
	
		this.connection = connectionManager.getConnection();
//		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
//        final AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
//        beanFactory.autowireBean(this);
	}

//	public ProjectsDao() {
//		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
//        final AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
//        beanFactory.autowireBean(this);
//	
//	}

	
//	static CategoriesDAO categoriesDAO = new CategoriesDAO(connection);
	
	@Override
	public int getSize() throws SQLException {
		int size;
		connection = ConnectionManager.getConnection();
		Statement statement = connection.createStatement();
		String query = "SELECT count(*) AS size FROM projects ";
		ResultSet resultSet = statement.executeQuery(query);
		
		while(resultSet.next()){
			return size = resultSet.getInt("size");
		}
		throw new RuntimeException("Table Projects is empty");
	}
	
	public void addProject(String name, int moneyGot, int moneyNeed
			, int daysLeft, int categoryId) throws SQLException{
		connection = ConnectionManager.getConnection();
		Statement statement;
		statement = connection.createStatement();
		statement.execute("CREATE TABLE IF NOT EXISTS projects (id int(20) AUTO_INCREMENT, "
				+ "name text,moneyGot int,moneyNeed int,daysLeft int,category int,PRIMARY KEY(id))");
		PreparedStatement preparedStatement;
		String query = "INSERT INTO projects (name, moneyGot, MoneyNeed, daysLeft, category)"
				+ "VALUES(?, ?, ?, ?, ?)";
	
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, moneyGot);
		preparedStatement.setInt(3, moneyNeed);
		preparedStatement.setInt(4, daysLeft);
		preparedStatement.setInt(5, categoryId);
		preparedStatement.execute();
	}
	public void dropProjects() throws SQLException{
		connection = ConnectionManager.getConnection();
		Statement statement = connection.createStatement();
		statement.execute("DROP TABLE projects");
		
	}
	public void deleteProject(int id) throws SQLException{
		connection = ConnectionManager.getConnection();
		String query = "DELETE FROM projects WHERE id = ?"; 
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
	
	}
	public List<Project> getProjectsInCategory(int categoryId) throws SQLException{
		
		List<Project> projects = new ArrayList<Project>();
		Project project;
		connection = ConnectionManager.getConnection();
//		Statement statement = con.createStatement();
//		statement.executeQuery("")
		String query = "SELECT * FROM projects INNER JOIN categories "
				+ "ON projects.category = categories.id "
				+ "WHERE categories.id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, categoryId );				//may not works 
		
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			project = new Project(resultSet.getInt("id"),resultSet.getString("name")
					, resultSet.getInt("moneyGot"), resultSet.getInt("moneyNeed")
					, resultSet.getInt("daysLeft")
					,categories.getCategory(categoryId) );
			
			projects.add(project);
		}
		return projects;
	}
	public List<Project> getProjects() throws SQLException{
		List<Project> projects= new ArrayList<Project>();
		Project project = null;
		connection = ConnectionManager.getConnection();
		Statement statement = null;
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM projects");
		while(resultSet.next()){
			project = new Project(resultSet.getInt("id"),resultSet.getString("name")
					, resultSet.getInt("moneyGot"), resultSet.getInt("moneyNeed")
					, resultSet.getInt("daysLeft")
					, categories.getCategory(resultSet.getInt("category")));
			
			projects.add(project);
		}
		return projects;
	}



	@Override
	public Project getProject(int id) throws SQLException {
		connection = ConnectionManager.getConnection();
		String query = "SELECT * FROM projects WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()){
			Project project = new Project(resultSet.getInt("id"),resultSet.getString("name")
					, resultSet.getInt("moneyGot"), resultSet.getInt("moneyNeed")
					, resultSet.getInt("daysLeft")
					, categories.getCategory(resultSet.getInt("category")));
			return project;
					
		}
		throw new RuntimeException("Table project is empty");
	}


}
