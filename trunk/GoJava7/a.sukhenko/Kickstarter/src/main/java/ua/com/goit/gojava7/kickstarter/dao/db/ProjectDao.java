package ua.com.goit.gojava7.kickstarter.dao.db;

import java.security.InvalidAlgorithmParameterException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.model.Project;
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
       TypedQuery<Project> query = manager.createNamedQuery("Project.findByProjectName",Project.class);
       List<Project> projects = query.setParameter("projectName", projectName).getResultList();
       return projects.get(0);
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
