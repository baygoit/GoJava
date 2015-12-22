package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Question;

@Component
public class QuestionDbDao {

	@Autowired
	private DbDao dbDao;

	private static final Logger log = LoggerFactory.getLogger(QuestionDbDao.class);

	public QuestionDbDao() {
		log.info("Constructor QuestionDbDao()...");
	}

	public void add(Question element) {
		log.info("<void> add({})...", element);
		String query = "insert into question (time, question, answer, project_id) values (?, ?, ?, ?)";		
		dbDao.addQuestion(element, query);
	}

	public List<Question> getByProject(int projectId) {
		log.info("<Question> getByProject({})...", projectId);
		String query = "select time, question, answer, project_id from question where project_id = " + projectId;		
		return dbDao.getQuestionsByProject(query);
	}
}
