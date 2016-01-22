package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Question;
import ua.com.goit.gojava7.kickstarter.util.HibernateUtil;
@Repository
@Transactional
public class QuestionDatabaseDao{

    private static final Logger logger = LogManager.getLogger(QuestionDatabaseDao.class);


    @PersistenceContext
    private EntityManager manager;
    
    @Autowired
    private ProjectDao projectDao;
    
    public List<Question> getQuestionsByProjectId(int projectId) {
        TypedQuery<Question> query = manager.createNamedQuery("Question.findByProjectId",Question.class);
        List<Question> questions = query.setParameter("projectId", projectId).getResultList();
        return questions;
    }
    
    public void createQuestion(String text, int projectId) {
        logger.info("<void> createQuestion({}, {})...", text, projectId);
        //TODO: Check JPA
            Question question = new Question();
            question.setQuestion(text);
            question.setProject(projectDao.getProject(projectId));
            add(question);
        
    }
    
    public void add(Question question) {
        
        logger.info("<void> add()...", question);
        //TODO: JPA
    }
}
