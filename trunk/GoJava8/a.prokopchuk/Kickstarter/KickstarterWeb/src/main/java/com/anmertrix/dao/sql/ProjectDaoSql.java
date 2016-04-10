package com.anmertrix.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.DaoException;
import com.anmertrix.dao.NoResultException;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Answer;
import com.anmertrix.domain.Payment;
import com.anmertrix.domain.Project;
import com.anmertrix.domain.Question;
import com.anmertrix.domain.Reward;

@Repository
public class ProjectDaoSql implements ProjectDao {
	
	private static final String SELECT_PROJECTS = "SELECT id, name FROM project WHERE category_id=?";
	private static final String SELECT_PROJECT = "SELECT name, description, required_budget, days_left, history, url, COALESCE(SUM(amount),0) AS sum_amount FROM project JOIN payment ON (project.id = payment.project_id) WHERE project_id=?";
	private static final String SELECT_QUESTIONS = "SELECT id, question FROM question WHERE project_id=?";
	private static final String SELECT_ANSWERS = "SELECT id, answer FROM answer WHERE question_id=?";
	private static final String INSERT_QUESTION = "INSERT INTO question (project_id, question) VALUES (?, ?)";
	private static final String SELECT_PAYMENTS = "SELECT id, cardholder_name, amount FROM payment WHERE project_id=?";
	private static final String INSERT_PAYMENT = "INSERT INTO payment (project_id, cardholder_name, card_number, amount) VALUES (?, ?, ?, ?)";
	private static final String SELECT_REWARDS = "SELECT id, name, amount, description FROM reward";

	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Project> getProjectsByCategoryId(int category_id) {

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_PROJECTS)) {
			statement.setInt(1, category_id);
			ResultSet rs = statement.executeQuery();
			List<Project> projects = new ArrayList<Project>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				Project project = new Project();
				project.setId(id);
				project.setName(name);
				projects.add(project);				
			}
			return projects;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public Project getProjectById(int project_id) {
		
		Project project = new Project();
    	
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_PROJECT)) {
			statement.setInt(1, project_id);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				int required_budget = rs.getInt("required_budget");
				int days_left = rs.getInt("days_left");
				String history = rs.getString("history");
				String url = rs.getString("url");
				int gathered_budget = rs.getInt("sum_amount");
					
				project.setProjectData(project_id, name, description, required_budget, gathered_budget, days_left, history);
				project.setUrl(url);
				return project;
			} else {
				throw new NoResultException("No project found");
			}
				
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public List<Question> getQuestionByProjectId(int project_id) {
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_QUESTIONS)) {
			statement.setInt(1, project_id);
			ResultSet rs = statement.executeQuery();
			
			List<Question> questions = new ArrayList<Question>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String questionText = rs.getString("question");
				
				Question question = new Question();
				question.setId(id);
				question.setQuestion(questionText);
				questions.add(question);				
			}
			return questions;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public List<Answer> getAnswerByQuestionId(int question_id) {
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_ANSWERS)) {
			statement.setInt(1, question_id);
			ResultSet rs = statement.executeQuery();
			
			List<Answer> answers = new ArrayList<Answer>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String answerText = rs.getString("answer");
				
				Answer answer = new Answer();
				answer.setId(id);
				answer.setAnswer(answerText);
				answers.add(answer);				
			}
			return answers;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public void insertQuestion(Question question) {		

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_QUESTION)) {
			statement.setInt(1, question.getProjectId());
			statement.setString(2, question.getQuestion());
			statement.execute();
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public List<Payment> getPaymentsByProjectId(int project_id) {
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_PAYMENTS)) {
			statement.setInt(1, project_id);
			ResultSet rs = statement.executeQuery();
			
			List<Payment> payments = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String cardholderName = rs.getString("cardholder_name");
				int amount = rs.getInt("amount");
				
				Payment payment = new Payment();
				payment.setId(id);
				payment.setCardholderName(cardholderName);
				payment.setAmount(amount);
				payments.add(payment);				
			}
			return payments;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void insertPayment(Payment payment) {

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_PAYMENT)) {
			statement.setInt(1, payment.getProjectId());
			statement.setString(2, payment.getCardholderName());
			statement.setString(3, payment.getCardNumber());
			statement.setInt(4, payment.getAmount());
			statement.execute();
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Reward> getRewards() {

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_REWARDS)) {
			ResultSet rs = statement.executeQuery();
			
			List<Reward> rewards = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int amount = rs.getInt("amount");
				String description = rs.getString("description");
				
				Reward reward = new Reward();
				reward.setId(id);
				reward.setName(name);
				reward.setAmount(amount);
				reward.setDescription(description);
				rewards.add(reward);				
			}
			return rewards;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
