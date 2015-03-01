package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava2.vova.kickstarter.util.ConnectToDB;
import ua.com.goit.gojava2.vova.kickstarter.util.PeriodBetweenDates;

public class ProjectsFromDB implements Projects{
	
	private List<Project> projects;

	@Override
	public List<Project> getProjects() {
		return projects;
	}

	@Override
	public void setProjects() {
		projects = new ArrayList<Project>();
		ResultSet result;
		try {
			ArrayList<String> faq = getFaq(projects.size());
			result = ConnectToDB.statement.executeQuery("SELECT * FROM projects ORDER BY id_project");
			while (result.next()) {
				projects.add(new Project(result.getInt("id_project"), 
										result.getString("name_project"),
										result.getString("short_description_project"),
										result.getString("full_description_project"),
										result.getString("foto_project"),
										result.getString("link_project"),
										result.getInt("how_much_needed_project"),
										result.getInt("how_much_collected_project"),
										result.getInt("how_much_remaining_project"),
										faq, PeriodBetweenDates.periodJoda(result.getString("date_close_project"))));
			}
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": +++"+ e.getMessage() );
		}
	}
	
	@Override
	public String showProjectInShort(int projectID) {
		StringBuilder s = new StringBuilder();

		ResultSet result;
		try {
			result = ConnectToDB.statement.executeQuery("SELECT id_project, name_project, short_description_project, "
	            		+ "how_much_needed_project, how_much_collected_project "
	            		+ "FROM projects WHERE id_project =" + projectID);
	            while (result.next()) {
		            s.append(result.getString("id_project"))
							.append(" ").append(result.getString("name_project"))
							.append(", ").append(result.getString("short_description_project"))
							.append(", ").append(result.getString("how_much_needed_project"))
							.append(", ").append(result.getString("how_much_collected_project")).toString();
	            }
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
		
		return s.toString();
	}

	@Override
	public void setDonation(int chosenProject, int amount) {
		try {
			ConnectToDB.statement.execute("UPDATE projects SET how_much_collected_project=how_much_collected_project+" + amount
			    	+ ", how_much_remaining_project=how_much_remaining_project-" + amount
			    	+ "WHERE id_project=" + chosenProject + ";");
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
	}

	@Override
	public void addFAQ(int projectID, String question) {
		try {
			ConnectToDB.statement.execute("INSERT INTO faq(id_project, question)VALUES (" + projectID + ", '" + question + "');");
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
	}

	@Override
	public ArrayList<String> getFaq(int projectID) {
		ArrayList<String> s = new ArrayList<String>();
		
		ResultSet result;
		try {
			result = ConnectToDB.statement.executeQuery("SELECT * FROM faq WHERE id_project =" + projectID);
	            while (result.next()) {
		            s.add(result.getString("question"));
	            }
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
		return s;
	}



//	private String arrayListToString(ArrayList<String> array) {
//		StringBuilder string = new StringBuilder();
//		if(!array.isEmpty()){
//			for (String s : array){
//			    string.append(s).append(";\n").toString();
//			}
//			return string.substring(0, string.length() - 1);
//		}
//		return string.toString();
//	}
}
