package com.go_java4.alex_mirn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;

public class ProjectsDaoImpl implements ProjectsDao{
	private ConnectionPool connectionPool;

	public ProjectsDaoImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public void add(Project project) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Project> getProjectsInCategory(int index) throws SQLException {
		List<Project> projects = new ArrayList<Project>();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select project_id, project.category_id, category.category_name, "); 
		sqlBuilder.append("project_name, project_description, "); 
		sqlBuilder.append("project_total_sum, project_pledged, project_days_left, "); 
		sqlBuilder.append("project_history, project_video_link "); 
		sqlBuilder.append("from project ");
		sqlBuilder.append("natural join category ");
		sqlBuilder.append("where category_id = ?");
		sqlBuilder.append("order by project_id");
		String sql = sqlBuilder.toString();
		PreparedStatement statement = 
				connectionPool.getConnection().prepareStatement(sql);
		statement.setInt(1, index);
		ResultSet resultQuery = statement.executeQuery();
		
		while (resultQuery.next()) {
			int id = resultQuery.getInt("project_id");
			int categoryId = resultQuery.getInt("category_id");
			String  categoryName = resultQuery.getString("category_name");
			String  name = resultQuery.getString("project_name");
			String  description = resultQuery.getString("project_description");
			int  totalAmount = resultQuery.getInt("project_total_sum");
			int  pledged = resultQuery.getInt("project_pledged");
			int  daysLeft = resultQuery.getInt("project_days_left");
			String  history = resultQuery.getString("project_history");
			String  videoLink = resultQuery.getString("project_video_link");
			projects.add(new Project(id, new Category(categoryId, categoryName), 
					name, description, totalAmount, pledged, 
					daysLeft, history, videoLink, null));
		}
		return projects;
	}
	
	@Override
	public Project getProjectIndex(int index) throws SQLException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select project_id, project.category_id, ");
		sqlBuilder.append("category.category_name, project_name, ");
		sqlBuilder.append("project_description, project_total_sum, "); 
		sqlBuilder.append("project_pledged, project_days_left, ");
		sqlBuilder.append("project_history, project_video_link "); 
		sqlBuilder.append("from project ");
		sqlBuilder.append("natural join category ");
		sqlBuilder.append("where project_id = ?");
		String sql = sqlBuilder.toString();
		PreparedStatement statement = connectionPool.getConnection().prepareStatement(sql);
		statement.setInt(1, index);
		ResultSet resultQuery = statement.executeQuery();
		if (resultQuery.next()) {
			int id = resultQuery.getInt("project_id");
			int categoryId = resultQuery.getInt("category_id");
			String  categoryName = resultQuery.getString("category_name");
			String  name = resultQuery.getString("project_name");
			String  description = resultQuery.getString("project_description");
			int  totalAmount = resultQuery.getInt("project_total_sum");
			int  pledged = resultQuery.getInt("project_pledged");
			int  daysLeft = resultQuery.getInt("project_days_left");
			String  history = resultQuery.getString("project_history");
			String  videoLink = resultQuery.getString("project_video_link");
			return new Project(id, new Category(categoryId, categoryName), 
					name, description, totalAmount, pledged, 
					daysLeft, history, videoLink, null);
		} else {
			throw new RuntimeException("Can not get project having index...");
		}
	}
	
	@Override
	public List<Project> getAllProjects() throws SQLException {
		List<Project> projects = new ArrayList<Project>();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select project_id, project.category_id, category.category_name, "); 
		sqlBuilder.append("project_name, project_description, "); 
		sqlBuilder.append("project_total_sum, project_pledged, project_days_left, "); 
		sqlBuilder.append("project_history, project_video_link "); 
		sqlBuilder.append("from project ");
		sqlBuilder.append("natural join category ");
		sqlBuilder.append("order by project_id");
		String sql = sqlBuilder.toString();
		PreparedStatement statement = 
				connectionPool.getConnection().prepareStatement(sql);
		ResultSet resultQuery = statement.executeQuery();
		while (resultQuery.next()) {
			int id = resultQuery.getInt("project_id");
			int categoryId = resultQuery.getInt("category_id");
			String  categoryName = resultQuery.getString("category_name");
			String  name = resultQuery.getString("project_name");
			String  description = resultQuery.getString("project_description");
			int  totalAmount = resultQuery.getInt("project_total_sum");
			int  pledged = resultQuery.getInt("project_pledged");
			int  daysLeft = resultQuery.getInt("project_days_left");
			String  history = resultQuery.getString("project_history");
			String  videoLink = resultQuery.getString("project_video_link");
			projects.add(new Project(id, new Category(categoryId, categoryName), 
					name, description, totalAmount, pledged, 
					daysLeft, history, videoLink, null));
		}
		return projects;
	}
	
	private String getSizeQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(project_id) from project");
		return sql.toString();
	}

	@Override
	public int getProjectsSize() throws SQLException {
		String sql = getSizeQuery();
		PreparedStatement statement = connectionPool.getConnection().prepareStatement(sql);

		ResultSet resultQuery = statement.executeQuery();

		if (resultQuery.next()) {
			return getSizeFromResultQuery(resultQuery);
		} else {
			throw new RuntimeException("Can not get size of project");
		}
	}

	private int getSizeFromResultQuery(ResultSet resultQuery) throws SQLException {
		return resultQuery.getInt("count");
	}
}
