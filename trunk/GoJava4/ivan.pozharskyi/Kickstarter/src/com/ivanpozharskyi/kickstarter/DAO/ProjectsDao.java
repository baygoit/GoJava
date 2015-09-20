package com.ivanpozharskyi.kickstarter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.h2.command.ddl.PrepareProcedure;

import com.ivanpozharskyi.kickstarter.entity.Category;
import com.ivanpozharskyi.kickstarter.entity.Project;
import com.ivanpozharskyi.kickstarter.entity.Projects;

public class ProjectsDao implements Projects{
	private Connection con;
	static CategoriesDAO categoriesDAO = new CategoriesDAO();
	
	@Override
	public int getSize() throws SQLException {
		int size;
		con = ConnectionManager.getConnection();
		Statement statement = con.createStatement();
		String query = "SELECT count(*) AS size FROM projects ";
		ResultSet resultSet = statement.executeQuery(query);
		
		while(resultSet.next()){
			return size = resultSet.getInt("size");
		}
		throw new RuntimeException("Table Projects is empty");
	}
	
	public void addProject(String name, int moneyGot, int moneyNeed
			, int daysLeft, int categoryId) throws SQLException{
		con = ConnectionManager.getConnection();
		Statement statement;
		statement = con.createStatement();
		statement.execute("CREATE TABLE IF NOT EXISTS projects (id int(20) AUTO_INCREMENT, "
				+ "name text,moneyGot int,moneyNeed int,daysLeft int,category int,PRIMARY KEY(id))");
		PreparedStatement preparedStatement;
		String query = "INSERT INTO projects (name, moneyGot, MoneyNeed, daysLeft, category)"
				+ "VALUES(?, ?, ?, ?, ?)";
	
		preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, moneyGot);
		preparedStatement.setInt(3, moneyNeed);
		preparedStatement.setInt(4, daysLeft);
		preparedStatement.setInt(5, categoryId);
		preparedStatement.execute();
	}
	public void dropProjects() throws SQLException{
		con = ConnectionManager.getConnection();
		Statement statement = con.createStatement();
		statement.execute("DROP TABLE projects");
		
	}
	public void deleteProject(int id) throws SQLException{
		con = ConnectionManager.getConnection();
		String query = "DELETE FROM projects WHERE id = ?"; 
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
	
	}
	public List<Project> getProjectsInCategory(Category category) throws SQLException{
		
		List<Project> projects = new ArrayList<Project>();
		Project project;
		con = ConnectionManager.getConnection();
//		Statement statement = con.createStatement();
//		statement.executeQuery("")
		String query = "SELECT * FROM projects INNER JOIN categories "
				+ "ON projects.category = categories.id "
				+ "WHERE categories.id = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, category.getCategoryId());				//may not works 
		
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			project = new Project(resultSet.getInt("id"),resultSet.getString("name")
					, resultSet.getInt("moneyGot"), resultSet.getInt("moneyNeed")
					, resultSet.getInt("daysLeft")
					, category);
			
			projects.add(project);
		}
		return projects;
	}
	public List<Project> getProjects() throws SQLException{
		List<Project> projects= new ArrayList<Project>();
		Project project = null;
		con = ConnectionManager.getConnection();
		Statement statement = null;
		statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM projects");
		while(resultSet.next()){
			project = new Project(resultSet.getInt("id"),resultSet.getString("name")
					, resultSet.getInt("moneyGot"), resultSet.getInt("moneyNeed")
					, resultSet.getInt("daysLeft")
					, categoriesDAO.getCategory(resultSet.getInt("category")));
			
			projects.add(project);
		}
		return projects;
	}

	public static void main(String[] args) throws SQLException {
		ProjectsDao dao = new ProjectsDao();
//		dao.dropProjects();
//		dao.addProject("Project1_1",1000,200,15,1);
//		dao.addProject("Project1_2",2000,3000,11,1);
//		dao.addProject("Project1_3",3000,4000,18,1);
//		dao.addProject("Project2_1",5000,2400,25,2);
//		dao.addProject("Project2_2",5500,2300,24,2);
//		dao.addProject("Project2_3",6700,2200,23,2);
//		dao.addProject("Project3_1",3600,3400,35,3);
//		dao.addProject("Project3_2",3700,3200,34,3);
//		dao.addProject("Project13_3",3800,3100,32,3);
		
		System.out.println(dao.getProjectsInCategory(categoriesDAO.getCategory(2)));
	}

	@Override
	public Project getProject(int id) throws SQLException {
		con = ConnectionManager.getConnection();
		String query = "SELECT * FROM projects WHERE id = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()){
			Project project = new Project(resultSet.getInt("id"),resultSet.getString("name")
					, resultSet.getInt("moneyGot"), resultSet.getInt("moneyNeed")
					, resultSet.getInt("daysLeft")
					, categoriesDAO.getCategory(resultSet.getInt("category")));
			return project;
					
		}
		throw new RuntimeException("Table project is empty");
	}


}
