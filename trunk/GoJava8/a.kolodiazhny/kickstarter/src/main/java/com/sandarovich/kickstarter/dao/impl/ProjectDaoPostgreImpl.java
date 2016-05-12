package com.sandarovich.kickstarter.dao.impl;


import com.sandarovich.kickstarter.dao.ProjectDao;
import com.sandarovich.kickstarter.dao.exception.NoResultException;
import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository
public class ProjectDaoPostgreImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public Project findById(long projectId) {
        Session session = sessionFactory.getCurrentSession();
        Project project = session.get(Project.class, projectId);
        if (Objects.isNull(project)) {
            throw new NoResultException("Project not found");
        }
        return project;
    }


    @Transactional(readOnly = true)
    @Override
    public List<Project> findByCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Project.class);
        criteria.add(Restrictions.eq("category", category));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }


}
