package ua.com.goit.gojava7.kickstarter.dao.db;

import java.security.InvalidAlgorithmParameterException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.util.HibernateUtil;
@Repository
public class ProjectDatabaseDao{
    private static final Logger LOGGER = LogManager.getLogger(ProjectDatabaseDao.class);
    @Autowired
    private SessionFactory      sessionFactory;

    public List<Project> getAll() {
        LOGGER.debug("getting all projects from db.");
        String hql = "FROM Project P";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List<Project> results = HibernateUtil.listAndCast(query);
        if (results.isEmpty()) {
            throw new NoSuchElementException("hibernate returned 0 categories: list is empty.");
        }
        return results;
    }

    public Project getProjectByName(String projectName) {
        LOGGER.debug("Getting project by projectName: " + projectName);
        Session session = sessionFactory.openSession();
        String hql = "FROM Project P WHERE P.projectName = :projectName";
        Query query = session.createQuery(hql);
        query.setParameter("projectName", projectName);
        List<Project> results = HibernateUtil.listAndCast(query);
        if (results.isEmpty()) {
            throw new NoSuchElementException();
        }
        if(session.isOpen()){
        session.close();
        }
        return results.get(0);
    }

    public List<Project> getProjectsByCategoryId(int categoryId) {
        LOGGER.debug("Getting project by categoryId: " + categoryId);
        Session session = sessionFactory.openSession();
        String hql = "FROM Project P WHERE P.category.categoryId = :categoryId";
        Query query = session.createQuery(hql);
        query.setParameter("categoryId", categoryId);
        List<Project> results = HibernateUtil.listAndCast(query);
        return results;
    }

    public String getFundedPercentage(Project project) throws InvalidAlgorithmParameterException {
        return (float) ((getPledged(project) * 100) / project.getMoneyNeeded()) + "%";
    }

    private int getPledged(Project project) {
        return 100500;
    }

}
