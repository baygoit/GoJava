package ua.com.goit.gojava.kickstarter.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.Project;
import ua.com.goit.gojava.kickstarter.exceptions.IlligalInputException;

public class CategoryDao implements Category {
	private int id;
	private Connection c;
	private int size = 0;

	public CategoryDao(Connection c, int i) {
		this.c = c;
		this.id = i;
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT id FROM project WHERE category_id="
							+ this.id + ";");
			while (rs.next()) {
				size++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getName() {
		ResultSet rs;
		Statement stmt = null;
		String name = "";
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT name FROM category WHERE id="
					+ this.id + ";");
			while (rs.next()) {
				name = rs.getString("name");
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return name;
	}

	@Override
	public List<String> getProjectCatalog() {
		List<String> list = new LinkedList<>();
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT name FROM project WHERE category_id="
							+ this.id + ";");
			while (rs.next()) {
				list.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Project getProject(int id) throws IlligalInputException {
		Project project = null;
		Statement stmt = null;
		try {
			stmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM project WHERE category_id="
							+ this.id + ";");
			// TODO need refactor
			rs.relative(id + 1);
			String name = rs.getString("name");
			String description = rs.getString("description");
			int cost = rs.getInt("cost");
			int collected = rs.getInt("collected");
			Date date = rs.getDate("Deadline");
			String history = rs.getString("history");
			String demo = rs.getString("demo");
			String faq = rs.getString("faq");
			project = new Project(id, name, description, cost, collected, date,
					history, demo, faq);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return project;
	}

	@Override
	public int size() {

		return size;
	}

}
