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

    @PersistenceContext
    private EntityManager em;
    
    public Category get(int id) {
        Category category = em.find(Category.class, id);
        if (category == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return category;
    }
    
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
    
    public int add(String name) {
        Category category = new Category();
        category.setName(name);
        em.persist(category);
        return category.getId(); 
    }
    
    public void update(Category category) {
        em.merge(category);
    }
    
    public void delete(int id) {
        Query query = em.createQuery("DELETE from Category c WHERE c.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
