package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectsFromDB implements Projects{
	
	private static final String PASS_DB = "7575";//TODO delete duplicate with ATHER CLASS
	private static final String NAME_DB = "postgres";
	private static final String JDBC_POSTGRESQL_PATH = "jdbc:postgresql://127.0.0.1:5432/kickstarter";
	
	public static void main(String[] args) {
		ProjectsFromDB proj = new ProjectsFromDB();
		System.out.println(proj.showProjectFull(2));

		System.out.println(proj.showProjectInShort(5));
				
		proj.setDonation(1, 4);
		
		proj.addFAQ(1, "question1");
		proj.addFAQ(2, "question2");
		proj.addFAQ(1, "question3");
		
	}
	
	@Override
	public String showProjectFull(int projectID) {
		StringBuilder s = new StringBuilder();
		Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            Statement statement = null;
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM projects WHERE id_project =" + projectID);
            while (result.next()) {
	            s.append("projectID = ").append(result.getString("id_project")).append("\n")
					.append("project name: ").append(result.getString("name_project")).append("\n")
					.append("short description: ").append(result.getString("short_description_project")).append("\n")
					.append("full description: " ).append(result.getString("full_description_project")).append("\n")
					.append("foto: ").append(result.getString("foto_project")).append("\n")
					.append("link: ").append(result.getString("link_project")).append("\n")
					.append("how much needed = ").append(result.getString("how_much_needed_project")).append("\n")
					.append("how much collected = ").append(result.getString("how_much_collected_project")).append("\n")
					.append("how much remaining = ").append(result.getString("how_much_remaining_project")).append("\n")
					.append("faq = ").append(arrayListToString(getFaq(projectID))).toString();
            }
        } catch (Exception ex) {
            Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
		return s.toString();
	}
	
	@Override
	public String showProjectInShort(int projectID) {
		StringBuilder s = new StringBuilder();
		Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            Statement statement = null;
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT id_project, name_project, short_description_project, "
            		+ "how_much_needed_project, how_much_collected_project "
            		+ "FROM projects WHERE id_project =" + projectID);
            while (result.next()) {
	            s.append(result.getString("id_project"))
						.append(" ").append(result.getString("name_project"))
						.append(", ").append(result.getString("short_description_project"))
						.append(", ").append(result.getString("how_much_needed_project"))
						.append(", ").append(result.getString("how_much_collected_project")).toString();
            }
        } catch (Exception ex) {
            Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
		return s.toString();
	}

	@Override
	public void setDonation(int chosenProject, int amount) {
		Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            Statement statement = null;
            statement = connection.createStatement();
            statement.execute("UPDATE projects SET how_much_collected_project=how_much_collected_project+" + amount
            	+ ", how_much_remaining_project=how_much_remaining_project-" + amount
            	+ "WHERE id_project=" + chosenProject + ";");
            	
        } catch (Exception ex) {
            Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
	}

	@Override
	public void addFAQ(int projectID, String question) {
		Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            Statement statement = null;
            statement = connection.createStatement();
            statement.execute("INSERT INTO faq(id_project, question)VALUES (" + projectID + ", '" + question + "');");
        } catch (Exception ex) {
            Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
		
	}

	@Override
	public ArrayList<String> getFaq(int projectID) {
		ArrayList<String> s = new ArrayList<String>();
		Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            Statement statement = null;
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM faq WHERE id_project =" + projectID);
            while (result.next()) {
	            s.add(result.getString("question"));
            }
        } catch (Exception ex) {
            Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
		return s;
	}

	private String arrayListToString(ArrayList<String> array) {
		StringBuilder string = new StringBuilder();
		if(!array.isEmpty()){
			
			for (String s : array){
			    string.append(s).append(";\n").toString();
			}
			return string.substring(0, string.length() - 1);
		}
		return string.toString();
	}
	
	@Override
	public ArrayList<Project> getListProject() {
		// do nothing
		return null;// TODO DELETE null (NPE)
	}
	
	@Override
	public int getCounterProject() {
		// do nothing
		return 0;// TODO DELETE 0 (NPE)
	}

	@Override
	public void setListProject(ArrayList<Project> listProject) {
		// do nothing
	}

	@Override
	public void setCounterProject(int counterProject) {
		// do nothing		
	}
	
	@Override
	public void writeAllProjects() {
		// do nothing
	}

	@Override
	public void updateProject(String[] value, int i) {
		// do nothing
	}
}
