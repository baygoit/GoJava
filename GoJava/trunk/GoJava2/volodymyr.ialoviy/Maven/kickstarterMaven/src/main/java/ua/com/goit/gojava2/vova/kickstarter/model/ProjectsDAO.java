package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava2.vova.kickstarter.util.PeriodBetweenDates;

public class ProjectsDAO implements Projects{
	
	private Connection connection;
	
	public ProjectsDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Project> getProgectsForCategory(int categoryID) {
		List<Project> projects = new ArrayList<Project>();
		ResultSet result;
		try {
			Statement statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM projects WHERE id_category=" + categoryID + "ORDER BY id_project");
			while (result.next()) {
				projects.add(new Project(result.getInt("id_project"), 
										result.getInt("id_category"),
										result.getString("name_project"),
										result.getString("short_description_project"),
										result.getString("full_description_project"),
										result.getString("foto_project"),
										result.getString("link_project"),
										result.getInt("how_much_needed_project"),
										result.getInt("how_much_collected_project"),
										result.getInt("how_much_remaining_project"),
										getFaq(result.getInt("id_project")),
										PeriodBetweenDates.periodJoda(result.getString("date_close_project"))));
			}
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
		return projects;
	}
	
	@Override
	public Project getProgect(int progectID) {
		Project project = null;
		ResultSet result;
		try {
			Statement statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM projects WHERE id_project=" + progectID);
			while (result.next()) {
				project = new Project(result.getInt("id_project"), 
										result.getInt("id_category"),
										result.getString("name_project"),
										result.getString("short_description_project"),
										result.getString("full_description_project"),
										result.getString("foto_project"),
										result.getString("link_project"),
										result.getInt("how_much_needed_project"),
										result.getInt("how_much_collected_project"),
										result.getInt("how_much_remaining_project"),
										getFaq(progectID), PeriodBetweenDates.periodJoda(result.getString("date_close_project")));
			}
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
		return project;
	}
	
	@Override
	public void addFAQ(int projectID, String question) {
		try {
			Statement statement = connection.createStatement();
			statement.execute("INSERT INTO faq(id_project, question)VALUES (" + projectID + ", '" + question + "');");
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
	}
	
	@Override
	public void setDonation(int projectID, int amount) {
		try {
			Statement statement = connection.createStatement();
			statement.execute("UPDATE projects SET how_much_collected_project=how_much_collected_project+" + amount
			    	+ ", how_much_remaining_project=how_much_remaining_project-" + amount
			    	+ "WHERE id_project=" + projectID + ";");
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
	}

	@Override
	public ArrayList<String> getFaq(int projectID) {
		ArrayList<String> s = new ArrayList<String>();
		
		ResultSet result;
		try {
			Statement statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM faq WHERE id_project =" + projectID);
	            while (result.next()) {
		            s.add(result.getString("question"));
	            }
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
		return s;
	}
}
