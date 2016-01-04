package ua.com.goit.gojava7.kickstarter.dao.db;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.util.HibernateUtil;
@Repository
public class CategoryDatabaseDao{
    private static final Logger logger = LogManager.getLogger(CategoryDatabaseDao.class); 
    
    
    public List<Category> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Category C ");
        List<Category> categoriesList = HibernateUtil.listAndCast(query); 
        if(categoriesList.isEmpty()){
            throw new NoSuchElementException();
        }
        return categoriesList;
    }


    public Category getCategoryById(int categoryId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Category C WHERE C.categoryId = :categoryId");
        query.setParameter("categoryId",categoryId);
        List<Category> categoriesList = HibernateUtil.listAndCast(query);
        if(categoriesList.isEmpty()){
            throw new NoSuchElementException();
        }
        return categoriesList.get(0);
    }
    

    
}
