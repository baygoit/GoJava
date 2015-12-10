package com.kickstarter.dao.interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.kickstarter.model.Project;

public class DbProjectDaoImpl extends DBCon implements ProjectDaoInterface {

	public List<Project> getAll(String categoryTitle) {
		ResultSet rs = null;
		List<Project> list = new ArrayList<>();

		try (PreparedStatement pStatement = getConnection()
				.prepareStatement("select * from projects where categoryTitle = ? ")) {
			pStatement.setString(1, categoryTitle);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				Project project = fill(rs);
				list.add(project);
			}
		} catch (SQLException e) {

			System.out.println("Project getAll MySql connection problem");
		}
		return list;
	}

	public Project getOne(int projectNumber) {
		ResultSet rs = null;
		Project project = new Project();

		try (PreparedStatement pStatement = getConnection()
				.prepareStatement("select * from projects where projectId =  ? ")) {
			pStatement.setInt(1, projectNumber);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				project = fill(rs);
			}
		} catch (SQLException e) {
			System.out.println(" Project getOne MySql connection problem");
		}
		return project;
	}

	public void update(Project p) {

		try (PreparedStatement pStatement = getConnection().prepareStatement(
				"update projects set discription = ? , daysLeft = ?, requiredSum = ?, gainedSum = ?, projectHistory = ?, videoLink = ? where projectId = ? ")) {
			pStatement.setString(1, p.getDiscription());
			pStatement.setInt(2, p.getDaysLeft());
			pStatement.setInt(3, p.getRequiredSum());
			pStatement.setInt(4, p.getGainedSum());
			pStatement.setString(5, p.getProjectHistory());
			pStatement.setString(6, p.getVideoLink());
			pStatement.setInt(7, p.getId());

			pStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(" Project update MySql connection problem");
		}
	}

	public List<Project> getAllList() {
		ResultSet rs = null;
		List<Project> list = new ArrayList<>();

		try (PreparedStatement pStatement = getConnection().prepareStatement("select * from projects")) {

			rs = pStatement.executeQuery();

			while (rs.next()) {
				Project project = fill(rs);
				list.add(project);
			}
		} catch (SQLException e) {
			System.out.println("Project getAllList MySql connection problem");
		}
		return list;
	}

	public Project fill(ResultSet rs) throws SQLException {

		Project project = new Project();

		project.setId(rs.getInt("projectId"));
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
