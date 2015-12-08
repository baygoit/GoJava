package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.config.DBConnectionManager;
import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class ProjectDaoSqlImpl implements ProjectDao {
	private DBConnectionManager connectionManager;

	public ProjectDaoSqlImpl(DBConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public List<Project> getProjects(int categoryId) {
		List<Project> projects = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = connectionManager.getConnection();
			stmt = conn.prepareStatement(
					"SELECT id, name, daysToGo, description, goal, owner, videoUrl FROM project WHERE categoryId ="
							+ categoryId);
			rset = stmt.executeQuery();

			Project project;
			while (rset.next()) {
				int id = rset.getInt("id");
				String name = rset.getString("name");
				int daysToGo = rset.getInt("daysToGo");
				String description = rset.getString("description");
				int goal = rset.getInt("goal");
				String owner = rset.getString("owner");
				String linkVideo = rset.getString("videoUrl");

				project = new Project(name, id);
				project.setCategoryId(categoryId);
				project.setDaysToGo(daysToGo);
				project.setDescription(description);
				project.setGoal(goal);
				project.setOwner(owner);
				project.setLinkVideo(linkVideo);

				projects.add(project);
			}
		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		} finally {
			try {
				if (rset != null)
					rset.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return projects;
	}

	@Override
	public Project getProject(int userChoise, int categoryId) {
		if (userChoise == 0) {
			return null;
		} else {
			List<Project> projects = getProjects(categoryId);
			return projects.get(userChoise - 1);
		}
	}

	@Override
	public int size(int categoryId) {
		return getProjects(categoryId).size();
	}

	@Override
	public Project getProject(int projectId) {
		Project project = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = connectionManager.getConnection();
			stmt = conn.prepareStatement(
					"SELECT categoryId, name, daysToGo, description, goal, owner, videoUrl FROM project WHERE id ="
							+ projectId);
			rset = stmt.executeQuery();

			if (rset.next()) {
				int categoryId = rset.getInt("categoryId");
				String name = rset.getString("name");
				int daysToGo = rset.getInt("daysToGo");
				String description = rset.getString("description");
				int goal = rset.getInt("goal");
				String owner = rset.getString("owner");
				String linkVideo = rset.getString("videoUrl");

				project = new Project(name, projectId);
				project.setCategoryId(categoryId);
				project.setDaysToGo(daysToGo);
				project.setDescription(description);
				project.setGoal(goal);
				project.setOwner(owner);
				project.setLinkVideo(linkVideo);

			}
		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		} finally {
			try {
				if (rset != null)
					rset.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return project;
	}

}
