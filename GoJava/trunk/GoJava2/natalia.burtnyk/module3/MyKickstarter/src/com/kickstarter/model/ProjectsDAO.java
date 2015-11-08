package com.kickstarter.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDAO implements Projects {

	private Connection connection;

	public ProjectsDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void add(Project project) {
	}

	@Override
	public Project get(int index) {
        Statement statement = null;
        Project result = null;
        
        try {
                statement = connection.createStatement();
                
                ResultSet resultSet = statement.executeQuery("SELECT *, categories.id AS category_id, categories.name AS category_name "
                                                                                                        + "FROM projects INNER JOIN categories "
                                                                                                        + "ON categories.id = projects.category_id WHERE projects.id = " + index);
                while (resultSet.next()) {
                result = new Project(resultSet.getInt("id"),
                		resultSet.getString("name"), 
                		resultSet.getString("discription"), 
                		resultSet.getString("history"),
                		resultSet.getString("url"), 
                		resultSet.getInt("req_amount"),
                        resultSet.getInt("total"),
                        resultSet.getInt("days"));
                
                Сategory category = new Сategory(resultSet.getInt("category_id"), resultSet.getString("category_name"));
                result.setСategory(category);
                }
        } catch (SQLException e) {
                throw new RuntimeException("Somthing wrong with connection or statement", e);
        } finally {
                try {
                        if(statement != null) {
                        statement.close();
                        }
                } catch (SQLException e) {
                        throw new RuntimeException("Can't close statement", e);
                }
        }
        return result;
	}

	@Override
	public int getSize() {
        int result = 0;
        Statement statement = null;
        try {
                statement = connection.createStatement();
                
                ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS COUNT FROM projects");
                while (resultSet.next()) {
                        result = resultSet.getInt("COUNT");
                }
        } catch (SQLException e) {
                throw new RuntimeException("Somthing wrong with connection or statement", e);
        } finally {
                try {
                        statement.close();
                } catch (SQLException e) {
                        throw new RuntimeException("Can't close statement", e);
                }
        }
        return result;
}

	@Override
	public List<Project> getProjects(Сategory сategory) {
		Statement statement = null;
		List<Project> list = null;
		Project project = null;

		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM projects WHERE category_id = "
														+ сategory.getId());
			list = new ArrayList<Project>();
			while (resultSet.next()) {
				project = new Project(resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getString("discription"),
						resultSet.getString("history"),
						resultSet.getString("url"),
						resultSet.getInt("req_amount"),
						resultSet.getInt("total"),
						resultSet.getInt("days"));
				list.add(project);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Can't get projects", e);
		}
		return list;
	}
}