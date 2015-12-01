package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class ProjectDaoSqlImpl implements ProjectDao {
	private DaoProvider daoProvider;

	public ProjectDaoSqlImpl(DaoProvider daoProvider) {
		this.daoProvider = daoProvider;
	}

	@Override
	public List<Project> getProjects(int categoryId) {
		List<Project> projects = new ArrayList<>();
		Connection connection = daoProvider.open();
		
		try (PreparedStatement ps = connection
				.prepareStatement("SELECT id, name, daysToGo, description, goal, owner, videoUrl FROM project WHERE categoryId ="
						+ categoryId);
				ResultSet rs = ps.executeQuery()) {

			Project project;
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int daysToGo = rs.getInt("daysToGo");
				String description = rs.getString("description");
				int goal = rs.getInt("goal");
				String owner = rs.getString("owner");
				String linkVideo = rs.getString("videoUrl");

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
			getProjects(categoryId);
			//throw new IODatabaseException("Problem with database", e);
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

}
