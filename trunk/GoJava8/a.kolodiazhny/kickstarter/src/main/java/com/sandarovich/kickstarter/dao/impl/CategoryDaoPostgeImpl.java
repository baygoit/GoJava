package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.CategoryDao;
import com.sandarovich.kickstarter.dao.exception.DaoException;
import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoPostgeImpl implements CategoryDao {

    @Override
    public List<Category> getCategories() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        List<Category> categories;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Category.class);
            categories = criteria.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
        return categories;
    }

    @Override
    public Category findById(long categoryId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Category category = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            category = session.get(Category.class, categoryId);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
        return category;
    }
}
