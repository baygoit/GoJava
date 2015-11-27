package ua.com.goit.gojava7.kickstarter.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.AbstractFaqDao;

public class FaqDaoMysqlImpl extends AbstractFaqDao  {
	private static final String INSERT_FAQ = "INSERT INTO faqs (project_id, question, answer) VALUES (?, ?, ?)";
	private static final String DELETE_FAQ = "DELETE FROM faqs WHERE project_id = ?";
	private static final String SELECT_ALL_FAQS = "SELECT id, name FROM faqs";
	private static final String COUNT_ALL_FAQS = "SELECT count(*) FROM faqs";
	
	
	@Override
	public void add(Faq faq) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(INSERT_FAQ)) {		
		
			statement.setInt(2, faq.getProjectID());			
			statement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Faq faq) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(DELETE_FAQ)){		
		
			statement.setInt(2, faq.getProjectID());
			statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
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

}
