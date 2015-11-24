package com.kickstarter.dao.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kickstarter.model.Category;
import com.kickstarter.model.Project;

public class DbProjectDaoImpl extends DbConnector implements ProjectDaoInterface {

	public List<Project> getAll(Category category) {
		ResultSet rs = null;
		Statement statement = null;
		List<Project> list = new ArrayList<>();

		try (Connection conection = getConnection();) {
			statement = conection.createStatement();
			rs = statement
					.executeQuery("select * from projects where categoryTitle =" + "'" + category.getTitle() + "'");

			while (rs.next()) {
				Project project = filler(rs);
				list.add(project);
			}
		} catch (SQLException e) {

			System.out.println("Project getAll MySql connection problem");
		}
		return list;
	}

	public Project getOne(int projectNumber) {
		ResultSet rs = null;
		Statement statement = null;
		Project project = new Project();

		try (Connection conection = getConnection()) {
			statement = conection.createStatement();
			rs = statement.executeQuery("select * from projects where id = " + "'" + projectNumber + "'");
			while (rs.next()) {
				project = filler(rs);
			}
		} catch (SQLException e) {
			System.out.println(" Project getOne MySql connection problem");
		}
		return project;
	}

	public void update(Project p) {
		Statement statement = null;

		try (Connection conection = getConnection()) {
			statement = conection.createStatement();
			statement.executeUpdate("update projects set discription = '" + p.getDiscription() + "'," + " daysLeft = '"
					+ p.getDaysLeft() + "'," + " requiredSum = '" + p.getRequiredSum() + "'," + " gainedSum = '"
					+ p.getGainedSum() + "'," + " projectHistory = '" + p.getProjectHistory() + "'," + " videoLink = '"
					+ p.getVideoLink() + "'" + " where id = '" + p.getId() + "'");

		} catch (SQLException e) {
			System.out.println(" Project update MySql connection problem");
		}
	}

	public List<Project> getAllList() {
		ResultSet rs = null;
		Statement statement = null;
		List<Project> list = new ArrayList<>();

		try (Connection conection = getConnection()) {
			statement = conection.createStatement();
			rs = statement.executeQuery("select * from projects");

			while (rs.next()) {
				Project project = filler(rs);
				list.add(project);
			}

		} catch (SQLException e) {
			System.out.println("Project getAllList MySql connection problem");
		}
		return list;
	}

	public Project filler(ResultSet rs) throws SQLException {

		Project project = new Project();

		project.setId(rs.getInt("id"));
		project.setTitle(rs.getString("title"));
		project.setDiscription(rs.getString("discription"));
		project.setDaysLeft(rs.getInt("daysLeft"));
		project.setRequiredSum(rs.getInt("requiredSum"));
		project.setGainedSum(rs.getInt("gainedSum"));
		project.setProjectHistory(rs.getString("projectHistory"));
		project.setVideoLink(rs.getString("videoLink"));
		project.setCategoryName(rs.getString("categoryTitle"));

		return project;

	}

}
