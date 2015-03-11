package ua.goit.goitjava.kickstarter.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.goit.goitjava.kickstarter.model.Project;

public class ProjectDAO {

	public List<Project> getListProjectByCategoryId(int categoryId) {
		Connection c = null;
		Statement st = null;
		Project proj = null;
		List<Project> arr = new ArrayList<Project>();
		try {
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/kickstarterdb",
					"postgres", "12345");

			st = c.createStatement();
			String string = "SELECT * FROM projects WHERE id_category ='"
					+ categoryId + "';";
			ResultSet rs = st.executeQuery(string);
			String name = null;
			String description = null;
			int needMoney = 0;
			int haveMoney = 0;
			int endProject = 0;
			String projectHistory = null;
			String demoLink = null;

			while (rs.next()) {
				name = rs.getString("name");
				description = rs.getString("description");
				needMoney = rs.getInt("need_money");
				haveMoney = rs.getInt("have_money");
				endProject = rs.getInt("end_project");
				projectHistory = rs.getString("project_history");
				demoLink = rs.getString("demo_link");

				proj = new Project(name, description, null, needMoney,
						haveMoney, endProject, projectHistory, demoLink);
				arr.add(proj);
			}

			st.close();
			c.close();
		} catch (Exception e) {

			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("Problems with getProject DB");
		}
		return arr;

	}

	public void createProject(Project project) {
		Connection c = null;
		Statement st = null;
		try {
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/kickstarterdb",
					"postgres", "12345");
			c.setAutoCommit(false);
			st = c.createStatement();
			String string = "INSERT INTO projects (name,description,need_money,have_money,"
					+ "end_project,project_history,demo_link,id_category)"
					+ "VALUES('"
					+ project.getName()
					+ "','"
					+ project.getDescription()
					+ "',"
					+ project.getNeedMoney()
					+ ","
					+ project.getHaveMoney()
					+ ","
					+ project.getDaysBeforeEnd()
					+ ",'"
					+ project.getProjectHistory()
					+ "','"
					+ project.getLinkToDemoVideo()
					+ "',"
					+ project.getCategory().getId() + ")";
			st.executeUpdate(string);
			st.close();
			c.commit();
			c.close();
		} catch (Exception e) {

			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("Problems with createProject DB");
		}
	}

	public void updateProjectHaveMoney(Project project) {
		int haveMoney = project.getHaveMoney();
		String name = project.getName();
		Connection c = null;
		Statement st = null;
		try {
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/kickstarterdb",
					"postgres", "12345");
			c.getAutoCommit();
			st = c.createStatement();
			String s = "UPDATE projects SET have_money =" + haveMoney
					+ " WHERE name ='" + name + "';";
			st.executeUpdate(s);
			st.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("Problems with updateProject DB");
		}
	}

	public void deleteProject(Project project) {
		Connection c = null;
		Statement st = null;
		try {
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/kickstarterdb",
					"postgres", "12345");
			c.setAutoCommit(false);
			st = c.createStatement();
			String string = "DELETE FROM projects WHERE name ='"
					+ project.getName() + "';";
			st.executeUpdate(string);
			c.commit();
			st.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("Problems with deleteProject DB");

		}
	}

	/*
	 * public Project getProjectById(int projectId, int categoryId) { Connection
	 * c = null; Statement st = null; Project proj = null; List<Project> arr =
	 * new ArrayList<Project>(); try { c = DriverManager.getConnection(
	 * "jdbc:postgresql://localhost:5432/kickstarterdb", "postgres", "12345");
	 * 
	 * st = c.createStatement(); String string =
	 * "SELECT * FROM projects WHERE id_category ='" + categoryId + "';";
	 * ResultSet rs = st.executeQuery(string); String name = null; String
	 * description = null; int needMoney = 0; int haveMoney = 0; int endProject
	 * = 0; String projectHistory = null; String demoLink = null;
	 * 
	 * while (rs.next()) { name = rs.getString("name"); description =
	 * rs.getString("description"); needMoney = rs.getInt("need_money");
	 * haveMoney = rs.getInt("have_money"); endProject =
	 * rs.getInt("end_project"); projectHistory =
	 * rs.getString("project_history"); demoLink = rs.getString("demo_link");
	 * 
	 * proj = new Project(name, description, null, needMoney, haveMoney,
	 * endProject, projectHistory, demoLink); arr.add(proj); }
	 * 
	 * proj = arr.get(projectId);
	 * 
	 * st.close(); c.close(); } catch (Exception e) {
	 * 
	 * System.err.println(e.getClass().getName() + ": " + e.getMessage());
	 * System.out.println("Problems with getProject DB"); } return proj;
	 * 
	 * }
	 */
}
