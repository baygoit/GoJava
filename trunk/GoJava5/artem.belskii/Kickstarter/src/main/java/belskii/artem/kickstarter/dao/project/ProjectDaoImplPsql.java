package belskii.artem.kickstarter.dao.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import belskii.artem.kickstarter.dao.DBConnector;

public class ProjectDaoImplPsql implements ProjectDao {
	Connection connection;
	private Integer currentProjectId;

	public ProjectDaoImplPsql(String dbConnectionConfig) {
		connection = new DBConnector(dbConnectionConfig).getConnection();
	}

	@Override
	public void addProject(Project projectDetails) {
		HashMap<Long, ArrayList<String>> faq = projectDetails.getFaq();
		HashMap<Long, HashMap<Long, String>> paymentVariants = projectDetails.getPaymetVariants();
		String name = projectDetails.getName();
		Long goal = projectDetails.getGoal();
		Long balance = projectDetails.getBalance();
		String startDate = projectDetails.getStartDate();
		String endDate = projectDetails.getEndDate();
		String videoUrl = projectDetails.getVideoUrl();
		int categoryId = projectDetails.getcategoryId();
		String details = projectDetails.getDetails();

		String projectQuery = "INSERT INTO projects (PROJECT_NAME,	GOAL, BALANCE, START_DATE,	END_DATE, VIDEO_URL, CATEGORY_ID, DETAILS) values(?,?,?,?,?,?,?,?) RETURNING id;--";
		try (PreparedStatement statement = connection.prepareStatement(projectQuery, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, name);
			statement.setLong(2, goal);
			statement.setLong(3, balance);
			statement.setString(4, startDate);
			statement.setString(5, endDate);
			statement.setString(6, videoUrl);
			statement.setInt(7, categoryId);
			statement.setString(8, details);
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			while (rs.next()) {
				currentProjectId = new Integer(rs.getString("ID"));
			}
			
			String faqQuery = "INSERT INTO faq (PROJECT_ID,	QUESTION, ANSWER) values (?,?,?);";
			try (PreparedStatement faqSatement = connection.prepareStatement(faqQuery)) {
				statement.setInt(1, currentProjectId);

				for (long i = 0; i < faq.size(); i++) {
					ArrayList<String> question = new ArrayList<String>();
					question.addAll(faq.get(i));
					faqSatement.setString(2, question.get(0)); // question
					String answer = "not answered yet";
					if (!question.get(1).equals("")) {
						answer = question.get(1);
					}
					faqSatement.setString(3, answer); // answer
					faqSatement.execute();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			String paymentQuery = "INSERT INTO payment_methods (PROJECT_ID,	PAYMENT_AMOUMT, BONUS) values (?,?,?);";
			try (PreparedStatement paymentStatement = connection.prepareStatement(paymentQuery)) {
				paymentStatement.setInt(1, currentProjectId);

				for (long i = 0; i < paymentVariants.size(); i++) {

					Object[] value = paymentVariants.get(i).keySet().toArray();
					paymentStatement.setLong(2, new Long(value[0].toString()));
					Object[] bonus = paymentVariants.get(i).values().toArray();
					paymentStatement.setString(3, bonus[0].toString());
					paymentStatement.execute();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<Long, Project> getProjectList() {
		Map<Long, Project> answer = new HashMap<Long, Project>();
		Project selectedProject = null;
		String projectQuery = "select ID, PROJECT_NAME, GOAL, BALANCE, START_DATE, END_DATE, VIDEO_URL, CATEGORY_ID, DETAILS from projects;";
		try (PreparedStatement statement = connection.prepareStatement(projectQuery)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				selectedProject = new Project(rs.getString("PROJECT_NAME"), rs.getLong("GOAL"), rs.getLong("BALANCE"),
											  rs.getString("START_DATE"), rs.getString("END_DATE"), rs.getString("VIDEO_URL"),
											  rs.getInt("CATEGORY_ID"), rs.getString("DETAILS"));
				selectedProject.setProjectId(rs.getLong("ID"));

				String faqQuery = "select QUESTION, ANSWER from faq where PROJECT_ID=?;";
				try (PreparedStatement faqStatement = connection.prepareStatement(faqQuery)) {
					faqStatement.setLong(1, selectedProject.getProjectId());
					ResultSet faqRs = faqStatement.executeQuery();
					long i=0;
					while (faqRs.next()) {
						selectedProject.asqAQuestion(faqRs.getString("QUESTION"));
						selectedProject.getAnswerForQuestion(i, faqRs.getString("ANSWER"));
						i++;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				String paymentQuery = "select PAYMENT_AMOUMT, BONUS from payment_methods where PROJECT_ID=?;";
				try (PreparedStatement paymentStatement = connection.prepareStatement(paymentQuery)) {
					paymentStatement.setLong(1, selectedProject.getProjectId());
					ResultSet paymentRs = paymentStatement.executeQuery();
					while (paymentRs.next()) {
						selectedProject.addPaymetVariants(paymentRs.getLong("PAYMENT_AMOUMT"), paymentRs.getString("BONUS"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				answer.put(new Long(answer.size()), selectedProject);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return answer;
	}

	@Override
	public Project getProjectDetails(int id) {
		Project selectedProject = null;
		String projectQuery = "select ID, PROJECT_NAME, GOAL, BALANCE, START_DATE, END_DATE, VIDEO_URL, CATEGORY_ID, DETAILS from projects where ID=?;";
		try (PreparedStatement statement = connection.prepareStatement(projectQuery)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				selectedProject = new Project(rs.getString("PROJECT_NAME"), rs.getLong("GOAL"), rs.getLong("BALANCE"),
											  rs.getString("START_DATE"), rs.getString("END_DATE"), rs.getString("VIDEO_URL"),
											  rs.getInt("CATEGORY_ID"), rs.getString("DETAILS"));
				selectedProject.setProjectId(rs.getLong("ID"));

				String faqQuery = "select QUESTION, ANSWER from faq where PROJECT_ID=?;";
				try (PreparedStatement faqStatement = connection.prepareStatement(faqQuery)) {
					faqStatement.setLong(1, selectedProject.getProjectId());
					ResultSet faqRs = faqStatement.executeQuery();
					long i=0;
					while (faqRs.next()) {
						selectedProject.asqAQuestion(faqRs.getString("QUESTION"));
						selectedProject.getAnswerForQuestion(i, faqRs.getString("ANSWER"));
						i++;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				String paymentQuery = "select PAYMENT_AMOUMT, BONUS from payment_methods where PROJECT_ID=?;";
				try (PreparedStatement paymentStatement = connection.prepareStatement(paymentQuery)) {
					paymentStatement.setLong(1, selectedProject.getProjectId());
					ResultSet paymentRs = paymentStatement.executeQuery();
					while (paymentRs.next()) {
						selectedProject.addPaymetVariants(paymentRs.getLong("PAYMENT_AMOUMT"), paymentRs.getString("BONUS"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return selectedProject;
	}

	@Override
	public Map<Long, Project> getProjectFromCategory(int id) {
		Map<Long, Project> answer = new HashMap<Long, Project>();
		Project selectedProject = null;
		String projectQuery = "select ID, PROJECT_NAME, GOAL, BALANCE, START_DATE, END_DATE, VIDEO_URL, CATEGORY_ID, DETAILS from projects where CATEGORY_ID=?;";
		try (PreparedStatement statement = connection.prepareStatement(projectQuery)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				selectedProject = new Project(rs.getString("PROJECT_NAME"), rs.getLong("GOAL"), rs.getLong("BALANCE"),
											  rs.getString("START_DATE"), rs.getString("END_DATE"), rs.getString("VIDEO_URL"),
											  rs.getInt("CATEGORY_ID"), rs.getString("DETAILS"));
				selectedProject.setProjectId(rs.getLong("ID"));

				String faqQuery = "select QUESTION, ANSWER from faq where PROJECT_ID=?;";
				try (PreparedStatement faqStatement = connection.prepareStatement(faqQuery)) {
					faqStatement.setLong(1, selectedProject.getProjectId());
					ResultSet faqRs = faqStatement.executeQuery();
					long i=0;
					while (faqRs.next()) {
						selectedProject.asqAQuestion(faqRs.getString("QUESTION"));
						selectedProject.getAnswerForQuestion(i, faqRs.getString("ANSWER"));
						i++;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				String paymentQuery = "select PAYMENT_AMOUMT, BONUS from payment_methods where PROJECT_ID=?;";
				try (PreparedStatement paymentStatement = connection.prepareStatement(paymentQuery)) {
					paymentStatement.setLong(1, selectedProject.getProjectId());
					ResultSet paymentRs = paymentStatement.executeQuery();
					while (paymentRs.next()) {
						selectedProject.addPaymetVariants(paymentRs.getLong("PAYMENT_AMOUMT"), paymentRs.getString("BONUS"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				answer.put(new Long(answer.size()), selectedProject);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return answer;
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Project updatedProject) {
		HashMap<Long, ArrayList<String>> faq = updatedProject.getFaq();
		HashMap<Long, HashMap<Long, String>> paymentVariants = updatedProject.getPaymetVariants();
		String name = updatedProject.getName();
		Long goal = updatedProject.getGoal();
		Long balance = updatedProject.getBalance();
		String startDate = updatedProject.getStartDate();
		String endDate = updatedProject.getEndDate();
		String videoUrl = updatedProject.getVideoUrl();
		int categoryId = updatedProject.getcategoryId();
		String details = updatedProject.getDetails();
		Long projectId = updatedProject.getProjectId();

		String projectQuery = "UPDATE projects SET PROJECT_NAME=?, GOAL=?, BALANCE=?, START_DATE=?,	END_DATE=?, VIDEO_URL=?, CATEGORY_ID=?, DETAILS=? WHERE ID=?;";
		try (PreparedStatement statement = connection.prepareStatement(projectQuery)) {
			statement.setString(1, name);
			statement.setLong(2, goal);
			statement.setLong(3, balance);
			statement.setString(4, startDate);
			statement.setString(5, endDate);
			statement.setString(6, videoUrl);
			statement.setInt(7, categoryId);
			statement.setString(8, details);
			statement.setLong(9, projectId);
			statement.execute();
			
			String faqQuery = "UPDATE faq SET QUESTION=?, ANSWER=?, PROJECT_ID=?;";
			try (PreparedStatement faqStatement = connection.prepareStatement(faqQuery)) {
				for (long i = 0; i < faq.size(); i++) {
					faqStatement.setString(1, faq.get(i).get(0));
					faqStatement.setString(2, faq.get(i).get(1));
					faqStatement.setLong(3, updatedProject.getcategoryId());
					faqStatement.execute();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			String paymentQuery = "UPDATE payment_methods SET PROJECT_ID=?,	PAYMENT_AMOUMT=?, BONUS=? where PROJECT_ID=?;";
			try (PreparedStatement paymentStatement = connection.prepareStatement(paymentQuery)) {
				for (long i = 0; i < paymentVariants.size(); i++) {
					Object[] value = paymentVariants.get(i).keySet().toArray();
					paymentStatement.setLong(1, new Long(value[0].toString()));
					Object[] bonus = paymentVariants.get(i).values().toArray();
					paymentStatement.setString(2, bonus[0].toString());
					paymentStatement.setLong(3, updatedProject.getcategoryId());
					paymentStatement.execute();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}


	
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
