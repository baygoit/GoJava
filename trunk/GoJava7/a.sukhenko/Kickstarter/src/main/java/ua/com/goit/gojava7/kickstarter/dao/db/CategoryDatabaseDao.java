package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.util.HibernateUtil;
@Repository
@Transactional
public class CategoryDatabaseDao{
    private static final Logger logger = LogManager.getLogger(CategoryDatabaseDao.class);
    
    @PersistenceContext
    private EntityManager entityManager;



    public List<Category> getAll() {
        return entityManager.createQuery("Select c from Category c",Category.class).getResultList();
    }
    
    public Category getCategoryById(Integer categoryId) {
        return entityManager.find(Category.class, categoryId);
    }
    

}
