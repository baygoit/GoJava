package ua.com.goit.gojava7.kickstarter.dao.db;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.fabric.xmlrpc.base.Array;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.util.HibernateUtil;
@Repository
@Transactional
public class ProjectDao{
    private static final Logger LOGGER = LogManager.getLogger(ProjectDao.class);
   
    @PersistenceContext
    private EntityManager manager;

    public List<Project> getAll() {
        List<Project> projects = manager.createQuery("SELECT p FROM Project p",Project.class).getResultList();
        LOGGER.debug("getting all projects from db.");
        return projects;
    }

    
    public Project getProject(Integer projectId) {
        LOGGER.info("<Project> get({})...", projectId);
        Project project = manager.find(Project.class, projectId);

        return project;
    }
    public Project getProjectByName(String projectName) {
        LOGGER.debug("Getting project by projectName: " + projectName);
        //TODO: Check if works
        Project project = manager.find(Project.class, projectName);
        return project;
    }


    public List<Project> getProjectsByCategoryId(int categoryId) {
        TypedQuery<Project> query = manager.createNamedQuery("Project.findByCategoryId",Project.class);
        List<Project> projects = query.setParameter("categoryId", categoryId).getResultList();
        return projects;
    }

    public String getFundedPercentage(Project project) throws InvalidAlgorithmParameterException {
        return (float) ((getPledged(project) * 100) / project.getMoneyNeeded()) + "%";
    }

    private int getPledged(Project project) {
        return 100500;
    }

}
