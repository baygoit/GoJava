package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import ua.com.goit.gojava2.vova.kickstarter.util.PeriodBetweenDates;

@Component
public class ProjectsDAO extends AbstractDAO implements Projects{
	
	private static Logger log = Logger.getLogger(ProjectsDAO.class.getName());
	
	@Override
	public List<Project> getProgectsForCategory(int categoryID) {
		List<Project> projects = new ArrayList<Project>();
//		try (Connection connection = getConnection()){
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("SELECT * FROM projects WHERE id_category=" + categoryID + "ORDER BY id_project");
//			while (resultSet.next()) {
//				projects.add(getProgect(resultSet.getInt("id_project")));
//			}
//		} catch (SQLException e) {
//			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//			log.log(Level.SEVERE, null, e);
//		}
		return projects;
	}
	
	@Override
	public Project getProgect(int progectID) {
		Project project = null;
//		try (Connection connection = getConnection()){
//			Statement statement = connection.createStatement();
//			ResultSet result = statement.executeQuery("SELECT * FROM projects WHERE id_project=" + progectID);
//			while (result.next()) {
//				project = new Project(result.getInt("id_project"), 
//										result.getInt("id_category"),
//										result.getString("name_project"),
//										result.getString("short_description_project"),
//										result.getString("full_description_project"),
//										result.getString("foto_project"),
//										result.getString("link_project"),
//										result.getInt("how_much_needed_project"),
//										result.getInt("how_much_collected_project"),
//										result.getInt("how_much_remaining_project"),
//										getFaq(progectID),
//										PeriodBetweenDates.periodJoda(result.getString("date_close_project")));//TODO RELOCATE PeriodBetweenDates.periodJoda to service
//			}
//		} catch (SQLException e) {
//			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//			log.log(Level.SEVERE, null, e);
//		}
		return project;
	}
	
	@Override
	public void addFAQ(int projectID, String question) {
//		try (Connection connection = getConnection()){
//			Statement statement = connection.createStatement();
//			statement.execute("INSERT INTO faq(id_project, question) VALUES (" + projectID + ", '" + question + "');");
//		} catch (SQLException e) {
//			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//			log.log(Level.SEVERE, null, e);
//		}
	}
	
	@Override
	public void setDonation(int projectID, int amount) {
//		try (Connection connection = getConnection()){
//			Statement statement = connection.createStatement();
//			statement.execute("UPDATE projects SET how_much_collected_project=how_much_collected_project+" + amount
//			    	+ ", how_much_remaining_project=how_much_remaining_project-" + amount
//			    	+ "WHERE id_project=" + projectID + ";");
//		} catch (SQLException e) {
//			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//			log.log(Level.SEVERE, null, e);
//		}
	}

	@Override
	public ArrayList<String> getFaq(int projectID) {
		ArrayList<String> s = new ArrayList<String>();
//		try (Connection connection = getConnection()){
//			Statement statement = connection.createStatement();
//			ResultSet result = statement.executeQuery("SELECT * FROM faq WHERE id_project =" + projectID);
//	            while (result.next()) {
//		            s.add(result.getString("question"));
//	            }
//		} catch (SQLException e) {
//			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//			log.log(Level.SEVERE, null, e);
//		}
		return s;
	}
}
