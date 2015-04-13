package com.epic.app.dao.impl;

import com.epic.app.dao.BasicCrudDao;
import org.hibernate.*;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;
import static org.springframework.util.Assert.notNull;

@Transactional(propagation = Propagation.REQUIRED)
public abstract class AbstractHibernateDAO<E> implements BasicCrudDao<E> {

    protected final Class<E> entityClass;
    @Autowired
    SessionFactory sessionFactory;
    @Autowired ImprovedNamingStrategy namingStrategy;

    public AbstractHibernateDAO(Class<E> entityClass) {
        notNull(entityClass, "entityClass must not be null");
        this.entityClass = entityClass;
    }

    public E save(E entity) {
       /* try {
            ClassMetadata metadata = sessionFactory.getClassMetadata(entityClass);
            Object id = getProperty(entity, metadata.getIdentifierPropertyName());
            if (id != null && id.equals(new Integer(0))) {
                setProperty(entity, metadata.getIdentifierPropertyName(), null);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
        currentSession().saveOrUpdate(entity);
        return entity;
    }

    @Nullable
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public E merge(@Nullable E entity) {
        return (E) currentSession().merge(entity);
    }

    @SuppressWarnings("unchecked")
    public E get(Serializable id) {
        return (E) currentSession().get(entityClass, id);
    }

    @Nullable
    @Override
    public E get(String property, @NotNull Object value) {
        Criteria criteria = criteria();
        if (property.indexOf(".") > 0) {
            String[] aliases = property.split("\\.");
            String aProperty = "";
            for (int i=0; i < aliases.length-1; i++) {
                if (!aProperty.isEmpty()) {
                    aProperty += ".";
                }
                aProperty += aliases[i];
                String tmp = aProperty.replace(".", "_");
                criteria.createAlias(aProperty, tmp);
                aProperty = tmp;
            }
            property = aProperty+"."+aliases[aliases.length-1];
        }
        return (E) criteria.add(eq(property, value))
                .uniqueResult();
    }

    @Nullable
    @Override
    public List<E> getList(String property, @NotNull Object value) {
        return criteria()
                .add(eq(property, value))
                .list();
    }

    @SuppressWarnings("unchecked")
    protected E load(Serializable id) {
        return (E) currentSession().load(entityClass, id);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void remove(Serializable id) {
        E entity = (E) currentSession().get(entityClass, id);
        currentSession().delete(entity);
    }

    public Long getCount() {
        return (Long) currentSession().createQuery("select count (*) from "+entityClass.getName())
                .uniqueResult();
    }

    @Override
    public List<E> getAll() {
        return criteria()
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }


    ///-----
    protected Criteria criteria() {
        return currentSession().createCriteria(entityClass);
    }

    protected Query query(String hql) {
        return currentSession().createQuery(hql);
    }

    protected SQLQuery sqlQuery(String hql) {
        return currentSession().createSQLQuery(hql);
    }

    protected Query queryByName(String queryName) {
        return currentSession().getNamedQuery(queryName);
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected List<E> all() {
        return list(criteria());
    }

    public Class<E> getEntityClass() {
        return entityClass;
    }

        /* === BEGIN GENERICS SUPPRESSION WRAPPERS === */

    protected List<E> list(Criteria criteria) {
        return list(criteria, true);
    }

    @SuppressWarnings("unchecked")
    protected List<E> list(Criteria criteria, boolean cache) {
        criteria.setCacheable(cache);
        return new ArrayList<E>(new LinkedHashSet<E>(criteria.list())); // privent duplications
    }

    protected List<E> list(Query query) {
        return list(query, true);
    }

    @SuppressWarnings("unchecked")
    protected List<E> list(Query query, boolean cache) {
        query.setCacheable(cache);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    protected E uniqueResult(Criteria criteria) {
        return (E) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    protected E uniqueResult(Query query) {
        return (E) query.uniqueResult();
    }

}