package goit.nz.kickstarter.dao;

import goit.nz.kickstarter.domain.FAQ;
import goit.nz.kickstarter.domain.Project;
import goit.nz.kickstarter.domain.ProjectEvent;
import goit.nz.kickstarter.domain.RewardOption;
import goit.nz.kickstarter.storage.DataProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectDAO {
	private DataProvider storage;

	public ProjectDAO(DataProvider storage) {
		this.storage = storage;
	}

	public List<Project> getProjects(long categoryId) {
		List<Project> result = new ArrayList<>();
		String sql = "SELECT id, name, coalesce(description, '') AS desc, amount_goal, "
				+ "amount_pledged, deadline, category_id "
				+ "FROM projects WHERE category_id = ? " + "ORDER BY id";
		try (Connection conn = storage.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, categoryId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result.add(createInMemoryBaseProject(resultSet));
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private Project createInMemoryBaseProject(ResultSet resultSet)
			throws SQLException {
		long id = resultSet.getLong("id");
		String name = resultSet.getString("name");
		String desc = resultSet.getString("desc");
		int amountGoal = resultSet.getInt("amount_goal");
		int amountPledged = resultSet.getInt("amount_pledged");
		Date endDate = resultSet.getDate("deadline");
		long categoryId = resultSet.getLong("category_id");
		if (endDate == null) {
			endDate = new Date();
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String deadline = dateFormat.format(endDate);
		Project result = new Project(id, name, desc, amountGoal, amountPledged,
				deadline);
		result.setCategory(categoryId);
		return result;
	}

	private Project createInMemoryFullProject(ResultSet resultSet)
			throws SQLException {
		Project result = createInMemoryBaseProject(resultSet);
		result.setLink(resultSet.getString("link"));
		addFaqs(result);
		addEvents(result);
		addRewards(result);
		return result;
	}

	private void addFaqs(Project project) {
		String sql = "SELECT question, coalesce(answer, '') AS answer "
				+ "FROM faqs WHERE project_id = ? ORDER BY id";
		try (Connection conn = storage.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, project.getId());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String question = resultSet.getString("question");
				String answer = resultSet.getString("answer");
				FAQ faq = new FAQ(question, answer);
				project.addFAQ(faq);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addEvents(Project project) {
		String sql = "SELECT description, event_date "
				+ "FROM events WHERE project_id = ? ORDER BY event_date";
		try (Connection conn = storage.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, project.getId());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String desc = resultSet.getString("description");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
				Date eventDate = resultSet.getDate("event_date");
				String date = dateFormat.format(eventDate);
				ProjectEvent event = new ProjectEvent(desc, date);
				project.addEvent(event);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addRewards(Project project) {
		String sql = "SELECT amount, description "
				+ "FROM reward_options WHERE project_id = ? "
				+ "ORDER BY amount";
		try (Connection conn = storage.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, project.getId());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int amount = resultSet.getInt("amount");
				String desc = resultSet.getString("description");
				RewardOption rewardOption = new RewardOption(amount, desc);
				project.addRewardOption(rewardOption);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Project getProject(long id) {
		Project found = null;
		String sql = "SELECT id, name, coalesce(description, '') AS desc, amount_goal, "
				+ "amount_pledged, deadline, category_id, coalesce(link_to_video, '') AS link "
				+ "FROM projects WHERE id = ?";
		try (Connection conn = storage.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				found = createInMemoryFullProject(resultSet);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	public void updatePledgedAmount(long projectId, int pledgedAmount) {
		String sql = "UPDATE projects SET amount_pledged = amount_pledged + ? "
				+ "WHERE id = ?";
		try (Connection conn = storage.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, pledgedAmount);
			statement.setLong(2, projectId);
			statement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addQuestion(long projectId, String question) {
		String sql = "INSERT INTO faqs (question, project_id) VALUES (?, ?)";
		try (Connection conn = storage.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, question);
			statement.setLong(2, projectId);
			statement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
