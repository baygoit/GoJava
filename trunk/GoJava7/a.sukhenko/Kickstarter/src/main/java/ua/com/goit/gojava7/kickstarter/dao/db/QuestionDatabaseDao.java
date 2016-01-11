package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.util.HibernateUtil;
@Repository
public class QuestionDatabaseDao{

    private static final Logger logger = LogManager.getLogger(QuestionDatabaseDao.class);
    @Autowired
    private SessionFactory      sessionFactory;
    
    
    public List<Question> getQuestionsByProjectId(int projectId) {
        logger.debug("Getting questions by projectId: " + projectId);
        Session session = sessionFactory.openSession();
        String hql = "FROM Question Q WHERE Q.project.id = :projectId";
        Query query = session.createQuery(hql);
        query.setParameter("projectId", projectId);
        List<Question> results = HibernateUtil.listAndCast(query);
        return results;
    }
}
