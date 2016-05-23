package ua.dborisenko.kickstarter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.dborisenko.kickstarter.controller.QuestionController;
import ua.dborisenko.kickstarter.domain.Category;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager em;
    
    private static final Logger log = LoggerFactory.getLogger(CategoryDao.class);

    public Category getWithProjects(int id) {
        EntityGraph<?> graph = this.em.getEntityGraph("graph.Category.projects");
        Map<String, Object> projects = new HashMap<String, Object>();
        projects.put("javax.persistence.fetchgraph", graph);
        Category category = em.find(Category.class, id, projects);
        if (category == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return category;
    }

    @SuppressWarnings("unchecked")
    public List<Category> getAll() {
        Query query = em.createNamedQuery("Category.getAll");
        return (List<Category>) query.getResultList();
    }
}
