package com.tyomsky.kickstarter.dao.hibernate;

import com.tyomsky.kickstarter.dao.CategoryDAO;
import com.tyomsky.kickstarter.dao.common.AbstractHibernateDao;
import com.tyomsky.kickstarter.domain.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class HibernateCategoryDao extends AbstractHibernateDao<Category> implements CategoryDAO {

    public HibernateCategoryDao() {
        super(Category.class);
    }

}
