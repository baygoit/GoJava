package com.tyomsky.kickstarter.dao.common;

import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

import static org.apache.commons.beanutils.BeanUtils.getProperty;
import static org.apache.commons.beanutils.BeanUtils.setProperty;
import static org.hibernate.criterion.Projections.rowCount;
import static org.hibernate.criterion.Restrictions.eq;
import static org.springframework.util.Assert.notNull;

@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public abstract class AbstractHibernateDao<E> implements BasicCrudDao<E> {

    protected final Class<E> entityClass;
    private Random random;
    SessionFactory sessionFactory;

    public AbstractHibernateDao(Class<E> entityClass) {
        notNull(entityClass, "entityClass must not be null");
        this.entityClass = entityClass;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public E save(E entity) {
        try {
            ClassMetadata metadata = sessionFactory.getClassMetadata(entityClass);
            Object id = getProperty(entity, metadata.getIdentifierPropertyName());
            if (id != null && id.equals(new Integer(0))) {
                setProperty(entity, metadata.getIdentifierPropertyName(), null);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        currentSession().saveOrUpdate(entity);
        return entity;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public E merge(E entity) {
        return (E) currentSession().merge(entity);
    }

    protected Criteria criteria() {
        return currentSession().createCriteria(entityClass);
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public E get(Serializable id) {
        return (E) currentSession().get(entityClass, id);
    }

    @Override
    public E get(String property, Object value) {
        Criteria criteria = criteria();
        if (property.indexOf(".") > 0) {
            String[] aliases = property.split("\\.");
            String aProperty = "";
            for (int i = 0; i < aliases.length - 1; i++) {
                if (!aProperty.isEmpty()) {
                    aProperty += ".";
                }
                aProperty += aliases[i];
                String tmp = aProperty.replace(".", "_");
                criteria.createAlias(aProperty, tmp);
                aProperty = tmp;
            }
            property = aProperty + "." + aliases[aliases.length - 1];
        }
        return (E) criteria.add(eq(property, value))
                .uniqueResult();
    }

    @Override
    public List<E> getList(String property, Object value) {
        return criteria()
                .add(eq(property, value))
                .list();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void remove(Serializable id) {
        E entity = (E) currentSession().get(entityClass, id);
        currentSession().delete(entity);
    }

    public Long getCount() {
        return (Long) currentSession().createQuery("select count (*) from " + entityClass.getName())
                .uniqueResult();
    }

    @Override
    public List<E> getAll() {
        return criteria()
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }

    @Override
    public E getRandom(Criterion restriction) {
        Criteria criteria = criteria();
        criteria.add(restriction);
        criteria.setProjection(rowCount());
        int count = ((Number) criteria.uniqueResult()).intValue();
        if (0 != count) {
            int index = random.nextInt(count);
            criteria = criteria();
            criteria.add(restriction);
            return (E) criteria.setFirstResult(index).setMaxResults(1).uniqueResult();
        }
        return null;
    }

    @Override
    public E getRandom() {
        Criteria criteria = criteria();
        criteria.setProjection(rowCount());
        int count = ((Number) criteria.uniqueResult()).intValue();
        if (0 != count) {
            int index = random.nextInt(count);
            criteria = criteria();
            return (E) criteria.setFirstResult(index).setMaxResults(1).uniqueResult();
        }
        return null;
    }

    @Autowired
    public void setRandom(Random random) {
        this.random = random;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}