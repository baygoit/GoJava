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
			
			result = ConnectToDB.statement.executeQuery("SELECT * FROM projects ORDER BY id_project");
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
										null, PeriodBetweenDates.periodJoda(result.getString("date_close_project"))));
			}

			writeFaq();
			
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": +++"+ e.getMessage() );
		}
	}

	private void writeFaq() {
		for (Project project: projects){
			project.setFaq(getFaq(project.getProjectID()));
		}
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

		Project project = getProjects().get(chosenProject - 1);// TODO relocate method or setProjects();
		project.setHowMuchCollected(project.getHowMuchCollected() + amount);
		project.setHowMuchRemaining(project.getHowMuchRemaining() - amount);
	}

	@Override
	public void addFAQ(int projectID, String question) {
		try {
			ConnectToDB.statement.execute("INSERT INTO faq(id_project, question)VALUES (" + projectID + ", '" + question + "');");
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
		writeFaq();
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

	@Override
	public int[] projectsThatAreContainedInTheCategory(int categoryId) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		List<Project> projects = getProjects();
		for (Project project : projects){
			if (project.getCategoryID() == categoryId){
				array.add(project.getProjectID());
			}
		}

        int[] a = new int[array.size()];//TODO DELETE, INT[] = lIST or relocate to util
        int j = 0;
        for (Integer i : array){
        	a[j] = i;
        	j++;
        }
		return a;
	}
}
