package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Category;
import ua.com.goit.gojava7.kickstarter.models.Payment;
import ua.com.goit.gojava7.kickstarter.models.Project;
import ua.com.goit.gojava7.kickstarter.models.Question;
import ua.com.goit.gojava7.kickstarter.models.Quote;
import ua.com.goit.gojava7.kickstarter.models.Reward;

@Component
public class DbDao {

	private static final Logger log = LoggerFactory.getLogger(DbDao.class);

	@Autowired
	private BasicDataSource basicDataSource;
	@Autowired
	private DbAgent dbAgent;

	public DbDao() {
		log.info("Constructor DbManager()...");
	}

	public Quote getQuote(String query) {
		log.info("<Quote> getQuote({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return dbAgent.readQuote(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Category> getCategories(String query) {
		log.info("<categories> getCategories({})...", query);
		List<Category> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(dbAgent.readCategory(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("getCategories() returned categories: {}", data);
		return data;
	}

	public Category getCategory(String query) {
		log.info("<Category> getCategory({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return dbAgent.readCategory(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Project> getProjects(String query) {
		log.info("<projects> getProjects({})...", query);
		List<Project> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(dbAgent.readProject(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("getProjects() returned projects: {}", data);
		return data;
	}

	public Project getProject(String query) {
		log.info("<Project> getProject({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return dbAgent.readProject(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getProjectName(String query) {
		log.info("<String> getProjectName({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return resultSet.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updatePledged(Project project, String query) {
		log.info("<void> updatePledged({}, {})...", project, query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Reward> getRewardsByProject(String query) {
		log.info("<rewards> getRewardsByProject({})...", query);
		List<Reward> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(dbAgent.readReward(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("getRewardsByProject() returned rewards: {}", data);
		return data;
	}

	public Reward getReward(String query) {
		log.info("<Reward> get({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return dbAgent.readReward(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addQuestion(Question element, String query) {
		log.info("<void> addQuestion({}, {})...", element, query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			dbAgent.writeQuestion(element, ps);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Question> getQuestionsByProject(String query) {
		log.info("<questions> getQuestionsByProject({})...", query);
		List<Question> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(dbAgent.readQuestion(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("getQuestionsByProject() returned questions: {}", data);
		return data;
	}

	public void addPayment(Payment element, String query) {
		log.info("<void> addPayment({}, {})...", element, query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			dbAgent.writePayment(element, ps);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Payment> getPaymentsByProject(String query) {
		log.info("<payments> getPaymentsByProject({})...", query);
		List<Payment> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(dbAgent.readPayment(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("getPaymentsByProject() returned payments: {}", data);
		return data;
	}

	public int getSumPaymentsByProject(String query) {
		log.info("<int> getSumPaymentsByProject({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return dbAgent.readSumPaymentsByProject(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Project> getTop5ProjectsByPledged(String query) {
		log.info("<payments> getTop5ProjectsByPledged({})...", query);
		List<Project> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				Project project = new Project();
				project.setId(resultSet.getInt("projectId"));
				project.setPledged(resultSet.getInt("sum"));
				log.debug("readProject() returned project: {}", project);
				data.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("getTop5ProjectsByPledged() returned payments: {}", data);
		return data;
	}
}
