package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.model.Category;
@Repository
@Transactional
public class CategoryDao{
    private static final Logger logger = LogManager.getLogger(CategoryDao.class);
    
    @PersistenceContext
    private EntityManager entityManager;



    public List<Category> getAll() {
        logger.info("Getting all categories");
        return entityManager.createQuery("Select c from Category c",Category.class).getResultList();
    }
    
    public Category getCategoryById(Integer categoryId) {
        logger.info("getting category by id: " + categoryId);
        return entityManager.find(Category.class, categoryId);
    }
    

}
