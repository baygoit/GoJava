package ua.dborisenko.kickstarter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.dborisenko.kickstarter.domain.Category;

@Repository
@Transactional
public class CategoryDao {

    private static final String GET_ALL_JPQL = "from Category order by name";
    @PersistenceContext
    private EntityManager em;

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
        Query query = em.createQuery(GET_ALL_JPQL);
        return (List<Category>) query.getResultList();
    }

}
