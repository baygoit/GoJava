package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@Repository
public class QuestionPostgreDAO implements QuestionsDAO{
	@PersistenceContext
	private EntityManager entityManager;
	
    @Override
    @Transactional
    public void clear() {
    	entityManager.createNamedQuery("Question.removeAll").executeUpdate();
    }

    @Override
    public Question get(Long index) {
    	return entityManager.find(Question.class, index);
    }

    @Override
    @Transactional
    public void add(Question element) {
    	entityManager.persist(element);
    }

    @Override
    @Transactional
    public void addAll(List<Question> elements) {
    	elements.forEach(entityManager::persist);
    }

    @Override
    public List<Question> getAll() {
    	return entityManager.createNamedQuery("Question.getAll", Question.class).getResultList();
    }

    @Override
    public List<Question> getByProject(Long projectId) {
    	TypedQuery<Question> query = entityManager.createNamedQuery("Question.getByProject", Question.class);
		query.setParameter("project_id", projectId);
		return query.getResultList();
    }

}
