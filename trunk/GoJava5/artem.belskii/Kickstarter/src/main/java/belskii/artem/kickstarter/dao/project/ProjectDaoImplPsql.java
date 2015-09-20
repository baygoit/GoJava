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
				//e.printStackTrace();
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
				//e.printStackTrace();
			}
			
		} catch (SQLException e) {
			//e.printStackTrace();
		}

		try {
			connection.commit();
		} catch (SQLException e) {
			//e.printStackTrace();
		}
	}

	@Override
	public Map<Long, Project> getProjectList() {
		Map<Long, Project> answer = new HashMap<Long, Project>();
		Project selectedProject = null;
		String projectQuery = "select ID, PROJECT_NAME, GOAL, BALANCE, START_DATE, END_DATE, VIDEO_URL, CATEGORY_ID, DETAILS from projects ORDER BY ID ASC;";
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
					//e.printStackTrace();
				}
				
				String paymentQuery = "select PAYMENT_AMOUMT, BONUS from payment_methods where PROJECT_ID=?;";
				try (PreparedStatement paymentStatement = connection.prepareStatement(paymentQuery)) {
					paymentStatement.setLong(1, selectedProject.getProjectId());
					ResultSet paymentRs = paymentStatement.executeQuery();
					while (paymentRs.next()) {
						selectedProject.addPaymetVariants(paymentRs.getLong("PAYMENT_AMOUMT"), paymentRs.getString("BONUS"));
					}
				} catch (SQLException e) {
					//e.printStackTrace();
				}
				
				answer.put(new Long(answer.size()), selectedProject);
				
			}
		} catch (SQLException e) {
			//e.printStackTrace();
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
					//e.printStackTrace();
				}
				
				String paymentQuery = "select PAYMENT_AMOUMT, BONUS from payment_methods where PROJECT_ID=?;";
				try (PreparedStatement paymentStatement = connection.prepareStatement(paymentQuery)) {
					paymentStatement.setLong(1, selectedProject.getProjectId());
					ResultSet paymentRs = paymentStatement.executeQuery();
					while (paymentRs.next()) {
						selectedProject.addPaymetVariants(paymentRs.getLong("PAYMENT_AMOUMT"), paymentRs.getString("BONUS"));
					}
				} catch (SQLException e) {
					//e.printStackTrace();
				}

				
			}
		} catch (SQLException e) {
			//e.printStackTrace();
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
					//e.printStackTrace();
				}
				
				String paymentQuery = "select PAYMENT_AMOUMT, BONUS from payment_methods where PROJECT_ID=?;";
				try (PreparedStatement paymentStatement = connection.prepareStatement(paymentQuery)) {
					paymentStatement.setLong(1, selectedProject.getProjectId());
					ResultSet paymentRs = paymentStatement.executeQuery();
					while (paymentRs.next()) {
						selectedProject.addPaymetVariants(paymentRs.getLong("PAYMENT_AMOUMT"), paymentRs.getString("BONUS"));
					}
				} catch (SQLException e) {
					//e.printStackTrace();
				}
				
				answer.put(new Long(answer.size()), selectedProject);
				
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		
		
		return answer;
	}

	@Override
	public void update(Project updatedProject) {
		//System.out.println("try update project with id: "+updatedProject.getProjectId());
	
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
			//System.out.println(statement);
			statement.execute();
			
			String checkfaqQuery="select exists(select 1 from faq where id=?);";
			try (PreparedStatement checkfaqStatement = connection.prepareStatement(checkfaqQuery)) {
				String faqQuery="";
				if (statement.execute()){
					faqQuery = "UPDATE faq SET QUESTION=?, ANSWER=?, PROJECT_ID=?;";
					try (PreparedStatement faqStatement = connection.prepareStatement(faqQuery)) {
						for (long i = 0; i < faq.size(); i++) {
							faqStatement.setString(1, faq.get(i).get(0));
							faqStatement.setString(2, faq.get(i).get(1));
							faqStatement.setLong(3, updatedProject.getProjectId());
							//System.out.println(faqStatement);
							faqStatement.execute();
						}
					} catch (SQLException e) {
						//e.printStackTrace();
					}
					
				} else {
					faqQuery = "INSERT INTO faq (PROJECT_ID, QUESTION, ANSWER) values (?,?,?);";
					try (PreparedStatement faqStatement = connection.prepareStatement(faqQuery)) {
						for (long i = 0; i < faq.size(); i++) {
							faqStatement.setLong(1, updatedProject.getProjectId());
							faqStatement.setString(2, faq.get(i).get(0));
							faqStatement.setString(3, faq.get(i).get(1));
							//System.out.println(faqStatement);
							faqStatement.execute();
						}

					}
				}
			}
			String checkPaymentMethodsQuery = "select exists(select 1 from payment_methods where id=?);";
			try (PreparedStatement checkpaymentStatement = connection.prepareStatement(checkPaymentMethodsQuery)) {
				if (statement.execute()){
					String paymentQuery = "UPDATE payment_methods SET PROJECT_ID=?,	PAYMENT_AMOUMT=?, BONUS=? where PROJECT_ID=?;";
					try (PreparedStatement paymentStatement = connection.prepareStatement(paymentQuery)) {
						for (long i = 0; i < paymentVariants.size(); i++) {
							Object[] value = paymentVariants.get(i).keySet().toArray();
							paymentStatement.setLong(1, new Long(value[0].toString()));
							Object[] bonus = paymentVariants.get(i).values().toArray();
							paymentStatement.setString(2, bonus[0].toString());
							paymentStatement.setLong(3, updatedProject.getcategoryId());
							//System.out.println(paymentStatement);
							paymentStatement.execute();
						}
					} catch (SQLException e) {
						//e.printStackTrace();
					}
				} else {
					String paymentQuery = "INSERT INTO payment_methods (PROJECT_ID,	PAYMENT_AMOUMT, BONUS) values (?,?,?);";
					try (PreparedStatement paymentStatement = connection.prepareStatement(paymentQuery)) {
						paymentStatement.setLong(1, projectId);

						for (long i = 0; i < paymentVariants.size(); i++) {
							Object[] value = paymentVariants.get(i).keySet().toArray();
							paymentStatement.setLong(2, new Long(value[0].toString()));
							Object[] bonus = paymentVariants.get(i).values().toArray();
							paymentStatement.setString(3, bonus[0].toString());
							paymentStatement.execute();
						}
					} catch (SQLException e) {
						//e.printStackTrace();
					}
					
				}
			}
			
		
		} catch (SQLException e) {
			//e.printStackTrace();
		}

		try {
			connection.commit();
		} catch (SQLException e) {
			//e.printStackTrace();
		}

	}
	
	public void initDemoDB(){
		String dropProjects = "DROP TABLE IF EXISTS PROJECTS";
		String dropFaq = "DROP TABLE IF EXISTS FAQ";
		String dropPaymentMethods = "DROP TABLE IF EXISTS PAYMENT_METHODS";
		try (PreparedStatement statement = connection.prepareStatement(dropProjects)) {
			connection.setAutoCommit(true);
			statement.execute();
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		try (PreparedStatement statement = connection.prepareStatement(dropFaq)) {
			connection.setAutoCommit(true);
			statement.execute();
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		try (PreparedStatement statement = connection.prepareStatement(dropPaymentMethods)) {
			connection.setAutoCommit(true);
			statement.execute();
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		String createProjects = "CREATE TABLE PROJECTS (ID serial, PROJECT_NAME varchar(100), GOAL numeric, BALANCE numeric, START_DATE	varchar(20), END_DATE varchar(20), VIDEO_URL varchar(500), CATEGORY_ID	numeric, DETAILS		varchar(1000));";
		String createFaq= "CREATE TABLE FAQ ( ID serial, PROJECT_ID	numeric, QUESTION varchar(1000), ANSWER varchar(1000));";
		String createPaymentMethods="CREATE TABLE PAYMENT_METHODS (ID serial, PROJECT_ID numeric, PAYMENT_AMOUMT numeric, BONUS varchar(1000));";
			try (PreparedStatement projectsStatement = connection.prepareStatement(createProjects)) {
				connection.setAutoCommit(true);
				projectsStatement.execute();
			} catch (SQLException e) {};
			try (PreparedStatement faqStatement = connection.prepareStatement(createFaq)) {
				connection.setAutoCommit(true);
				faqStatement.execute();
			} catch (SQLException e) {};
			try (PreparedStatement paymentMethodsStatement = connection.prepareStatement(createPaymentMethods)) {
				connection.setAutoCommit(true);
				paymentMethodsStatement.execute();
			} catch (SQLException e) {};
			
			this.addProject(new Project("My test project from Art category", new Long(1), new Long(1), "28.07.2015",	"30.07.2015", "https://www.youtube.com/watch?v=uC0pqWX3yB8", 1, "Project details"));
			this.addProject(new Project("My test project1 from Comics category", new Long(2), new Long(2), "29.07.2015",	"31.07.2015", "https://www.youtube.com/watch?v=uC0pqWX3yB8", 2, "Project details"));
			this.addProject(new Project("My test project2 from Crafts category", new Long(3), new Long(3), "30.07.2015",	"01.08.2015", "https://www.youtube.com/watch?v=uC0pqWX3yB8", 3, "Project details"));
			Project tmpProject = this.getProjectDetails(1);
			tmpProject.addPaymetVariants(10L, "small bonus for project 1");
			tmpProject.addPaymetVariants(30L, "standart bonus for project 1");
			tmpProject.addPaymetVariants(50L, "extra bonus for project 1");
			tmpProject.asqAQuestion("firs question");
			tmpProject.asqAQuestion("second question");
			this.update(tmpProject);
			
			Project tmp1Project = this.getProjectDetails(2);
			tmp1Project.addPaymetVariants(10L, "small bonus for project 1");
			tmp1Project.addPaymetVariants(30L, "standart bonus for project 1");
			tmp1Project.addPaymetVariants(50L, "extra bonus for project 1");
			tmp1Project.asqAQuestion("firs question");
			tmp1Project.asqAQuestion("second question");
			this.update(tmp1Project);

			Project tmp2Project = this.getProjectDetails(3);			
			tmp2Project.addPaymetVariants(10L, "small bonus for project 1");
			tmp2Project.addPaymetVariants(30L, "standart bonus for project 1");
			tmp2Project.addPaymetVariants(50L, "extra bonus for project 1");
			tmp2Project.asqAQuestion("firs question");
			tmp2Project.asqAQuestion("second question");
			this.update(tmp2Project);
	}

}
