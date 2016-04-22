package com.sandarovich.kickstarter.dao.impl;

import com.sandarovich.kickstarter.dao.AwardDao;
import com.sandarovich.kickstarter.dao.exception.DaoException;
import com.sandarovich.kickstarter.model.Award;
import com.sandarovich.kickstarter.model.Project;
import com.sandarovich.kickstarter.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AwardDaoPostgreImpl implements AwardDao {
    @Override
    public List<Award> getByProject(Project project) {
        List<Award> awards = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(Award.class);
            criteria.add(Restrictions.eq("projectid", project.getId()));
            awards = criteria.list();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
        return awards;
    }
}
