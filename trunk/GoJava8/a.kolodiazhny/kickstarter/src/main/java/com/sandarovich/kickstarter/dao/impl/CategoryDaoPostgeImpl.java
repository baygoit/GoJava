package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.CategoryDao;
import com.sandarovich.kickstarter.model.Category;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CategoryDaoPostgeImpl implements CategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public List<Category> getCategories() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Category.class).
            setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Transactional(readOnly = true)
    @Override
    public Category findById(long categoryId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, categoryId);
    }
}
