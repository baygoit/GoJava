package ua.com.goit.gojava7.kickstarter.storage_in_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.FaqDAO;

public class FaqStorage implements FaqDAO {
	private static final String DATABASE_URL = "jdbc:mysql://localhost/kickstarter";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	
	@Override
	public void add(Faq faq) {
		String insertFaq = "INSERT INTO faqs (project_id, question) VALUES ('" 
				+ faq.getProjectID() + "' , '"+ faq.getQuestion() + "')";
		
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			statement.executeUpdate(insertFaq);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (statement != null) {
					 statement.close();
			    }
				if (connection != null) {
					 connection.close();
			    }
			} catch (SQLException e) {
				System.out.println("Problems with closing connection...");
			}
		}
	}

	@Override
	public List<Faq> getAll() {
		String selectFaqFilds = "SELECT project_id, question, answer from faqs";
		List<Faq> faqs = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectFaqFilds);
			
			 while (resultSet.next()) {
			        int prjectID = resultSet.getInt("project_id");
			        String question = resultSet.getString("question");
			        String answer = resultSet.getString("answer");
			 
			        Faq faq = new Faq(question);
			        faq.setProjectID(prjectID);
			        faq.setAnswer(answer);
			        faqs.add(faq);
			 }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (statement != null) {
					 statement.close();
			    }
				if (connection != null) {
					 connection.close();
			    }
			} catch (SQLException e) {
				System.out.println("Problems with closing connection...");
			}
		}
		return faqs;
	}

	@Override
	public int getSize() {
		String selectCountFaqs = "SELECT count(*) from faqs";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		int amountOfCatrgories = 0;
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectCountFaqs);

			while (resultSet.next()) {
				amountOfCatrgories = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (statement != null) {
					 statement.close();
			    }
				if (connection != null) {
					 connection.close();
			    }
			} catch (SQLException e) {
				System.out.println("Problems with closing connection...");
			}
		}
		return amountOfCatrgories;
	}

	@Override
	public String getProjectFaqs(Project project) {
		String selectFaqFilds = "SELECT question, answer from faqs WHERE project_id = " + project.getUniqueID();
		StringBuilder result = new StringBuilder();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectFaqFilds);
			
			 while (resultSet.next()) {
			        String question = resultSet.getString("question");
			        result.append("\n  question : " + question + "\n");
			        
			        String answer = resultSet.getString("answer");
			        if (answer == null || answer.isEmpty()) {
			        	result.append("  answer: There is no answer yet \n");
					} else {
						result.append("  answer : " + answer + "\n");
					}	
			 }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (statement != null) {
					 statement.close();
			    }
				if (connection != null) {
					 connection.close();
			    }
			} catch (SQLException e) {
				System.out.println("Problems with closing connection...");
			}
		}
		return result.toString();
	}
	
	@Override
	public void remove(Faq faq) {
		// TODO Auto-generated method stub
		
	}

}
