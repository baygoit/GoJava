package com.anmertrix.dao.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.anmertrix.ConnectionManager;
import com.anmertrix.dao.DaoException;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Answer;
import com.anmertrix.domain.Project;
import com.anmertrix.domain.Question;

public class ProjectDaoSql implements ProjectDao {
	
	private ConnectionManager connectionManager;
	
	public ProjectDaoSql(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}
	
	@Override
	public List<Project> getProjectsByCategoryId(int index) {
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			List<Project> projects = new ArrayList<Project>();
			ResultSet rs = statement.executeQuery("SELECT id, name FROM project WHERE category_id=" + index);
			
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
	public Project getProjectById(int index) {
		
		Project project = new Project();
    	
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet rs = statement.executeQuery("SELECT name, description, required_budget, days_left, history, url, COALESCE(SUM(amount),0) AS sum_amount FROM project JOIN investment ON (project.id = investment.project_id) WHERE project_id=" + index);
			
			rs.next();
			String name = rs.getString("name");
			String description = rs.getString("description");
			int required_budget = rs.getInt("required_budget");
			int days_left = rs.getInt("days_left");
			String history = rs.getString("history");
			String url = rs.getString("url");
			int gathered_budget = rs.getInt("sum_amount");
				
			project.setProjectData(index, name, description, required_budget, gathered_budget, days_left, history);
			project.setUrl(url);
				
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
		return project;
	}
	
	@Override
	public List<Question> getQuestionByProjectId(int index) {
		
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			List<Question> questions = new ArrayList<Question>();
			ResultSet rs = statement.executeQuery("SELECT id, question FROM question WHERE project_id=" + index);
			
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
	public List<Answer> getAnswerByQuestionId(int index) {
		
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			List<Answer> answers = new ArrayList<Answer>();
			ResultSet rs = statement.executeQuery("SELECT id, answer FROM answer WHERE question_id=" + index);
			
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
		String queryStr = "INSERT INTO question (project_id, question) VALUES (?,  ?)";
		
		try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(queryStr)) {
			
			statement.setInt(1, question.getProjectId());
			statement.setString(2, question.getQuestion());
			statement.execute();
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
