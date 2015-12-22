package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Category;
import ua.com.goit.gojava7.kickstarter.models.Payment;
import ua.com.goit.gojava7.kickstarter.models.Project;
import ua.com.goit.gojava7.kickstarter.models.Question;
import ua.com.goit.gojava7.kickstarter.models.Quote;
import ua.com.goit.gojava7.kickstarter.models.Reward;

@Component
public class DbAgent {
	
	private static final Logger log = LoggerFactory.getLogger(DbAgent.class);
	
	public DbAgent() {
		log.info("Constructor DbAgent()...");
	}
	
	public Quote readQuote(ResultSet resultSet) throws SQLException {
		log.info("<Quote> readQuote()...");
		Quote quote = new Quote();
		quote.setText(resultSet.getString("text"));
		quote.setAuthor(resultSet.getString("author"));
		log.debug("readQuote() returned quote: {}", quote);
		return quote;
	}
	
	public Category readCategory(ResultSet resultSet) throws SQLException {
		log.info("<Category> readCategory()...");
		Category category = new Category();
		category.setId(resultSet.getInt("id"));
		category.setName(resultSet.getString("name"));
		log.debug("readCategory() returned category: {}", category);
		return category;
	}
	
	public Project readProject(ResultSet resultSet) throws SQLException {
		log.info("<Project> readProject()...");
		Project project = new Project();
		project.setId(resultSet.getInt("id"));
		project.setName(resultSet.getString("name"));
		project.setDescription(resultSet.getString("description"));
		project.setGoal(resultSet.getInt("goal"));
		project.setPledged(resultSet.getInt("pledged"));
		project.setDaysToGo(resultSet.getInt("daysToGo"));
		project.setHistory(resultSet.getString("history"));
		project.setLink(resultSet.getString("link"));
		project.setCategoryId(resultSet.getInt("category_id"));
		log.debug("readProject() returned project: {}", project);
		return project;
	}
	
	public Reward readReward(ResultSet resultSet) throws SQLException {
		log.info("<Reward> readReward()...");
		Reward reward = new Reward();
		reward.setId(resultSet.getInt("id"));
		reward.setAmount(resultSet.getInt("amount"));
		reward.setReward(resultSet.getString("reward"));
		reward.setProjectId(resultSet.getInt("project_id"));
		log.debug("readReward() returned reward: {}", reward);
		return reward;
	}
	
	public Question readQuestion(ResultSet resultSet) throws SQLException {
		log.info("<Question> readQuestion()...");
		Question question = new Question();
		question.setTime(resultSet.getString("time"));
		question.setQuestion(resultSet.getString("question"));
		question.setAnswer(resultSet.getString("answer"));
		log.debug("readQuestion() returned question: {}", question);
		return question;
	}
	
	public void writeElement(Question question, PreparedStatement statement) throws SQLException {
		log.info("<void> writeElement({})...", question);
		statement.setString(1, question.getTime());
		statement.setString(2, question.getQuestion());
		statement.setString(3, question.getAnswer());
		statement.setInt(4, question.getProjectId());
	}
	
	public Payment readPayment(ResultSet resultSet) throws SQLException {
		log.info("<Payment> readQuestion()...");
		Payment payment = new Payment();
		payment.setUser(resultSet.getString("user"));
		payment.setCard(resultSet.getString("card"));
		payment.setAmount(resultSet.getInt("amount"));
		log.debug("readPayment() returned payment: {}", payment);
		return payment;
	}

	public void writeElement(Payment payment, PreparedStatement statement) throws SQLException {
		log.info("<void> writeElement({})...", payment);
		statement.setString(1, payment.getUser());
		statement.setString(2, payment.getCard());
		statement.setInt(3, payment.getAmount());
		statement.setInt(4, payment.getProjectId());		
	}
}
