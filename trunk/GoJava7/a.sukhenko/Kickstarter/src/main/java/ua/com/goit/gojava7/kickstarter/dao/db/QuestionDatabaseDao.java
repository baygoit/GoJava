package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.util.Validator;
@Repository
@Transactional
public class QuestionDatabaseDao{

    private static final Logger logger = LogManager.getLogger(QuestionDatabaseDao.class);
    @Autowired
    private SessionFactory      sessionFactory;
    @Autowired
    private Validator validator;
    
    @Autowired
    private ProjectDao projectDao;
    
    public List<Question> getQuestionsByProjectId(int projectId) {
        logger.debug("Getting questions by projectId: " + projectId);
        Session session = sessionFactory.openSession();
        String hql = "FROM Question Q WHERE Q.project.id = :projectId";
        Query query = session.createQuery(hql);
        query.setParameter("projectId", projectId);
        List<Question> results = HibernateUtil.listAndCast(query);
        session.close();
        return results;
    }
    
    public void createQuestion(String text, int projectId) {
        logger.info("<void> createQuestion({}, {})...", text, projectId);
        if (validator.validateQuestion(text)) {
            Question question = new Question();
            question.setQuestion(text);
            question.setProject(projectDao.getProject(projectId));
            add(question);
        }else{
            logger.info("Question isn't created (validation failed)");
        }
    }
    
    private void add(Question question) {
        
        logger.info("<void> add()...", question);
        Session session = sessionFactory.getCurrentSession();
        session.save(question);
    }
}
