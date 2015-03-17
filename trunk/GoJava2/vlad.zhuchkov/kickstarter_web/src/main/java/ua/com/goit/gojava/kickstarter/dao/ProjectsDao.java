package ua.com.goit.gojava.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import ua.com.goit.gojava.kickstarter.data.Categories;
import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.Project;

@Component
public class ProjectsDao extends AbstractDao implements Categories {

	@Override
	public List<Project> getProjects(Category category) {
		try (Connection c = getConnection()) {
			Statement stmt = c.createStatement();
			List<Project> result = new LinkedList<Project>();

			ResultSet rs = stmt
					.executeQuery("select * from project where category_id = "
							+ category.getId());
			while (rs.next()) {
				Project project = new Project(rs.getInt("id"),
						rs.getString("name"), rs.getString("description"),
						rs.getInt("cost"), rs.getInt("collected"),
						rs.getDate("deadline"), rs.getString("history"),
						rs.getString("demo"), rs.getString("faq"));
				project.setCategory(category);
				result.add(project);
			}

			return result;
		} catch (SQLException e) {
			throw new RuntimeException("request error", e);
		}
	}

	@Override
	public Project getProject(int id) {
		try (Connection c = getConnection()){
			Statement stmt = c.createStatement();
				ResultSet rs = stmt
					.executeQuery("select "
							+ "c.id as category_id, "
							+ "p.name as project_name, "
							+ "description, "
							+ "p.id as project_id, "
							+ "c.name as category_name, "
							+ "cost, "
							+ "collected, "
							+ "deadline, "
							+ "history, "
							+ "demo, "
							+ "faq "
							+ " from project p, category c where p.category_id = c.id and p.id = "
							+ id);
			rs.next();
			return new Project(id, rs.getString("project_name"),
					rs.getString("description"), rs.getInt("cost"),
					rs.getInt("collected"), rs.getDate("deadline"),
					rs.getString("history"), rs.getString("demo"),
					rs.getString("faq"));

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

	}

	@Override
	public int size() {
		try (Connection c = getConnection()){
			Statement stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM category;");

			return rs.getInt(1);

		} catch (SQLException e) {
			throw new RuntimeException("statement does not executed", e);

		}
	}

}
