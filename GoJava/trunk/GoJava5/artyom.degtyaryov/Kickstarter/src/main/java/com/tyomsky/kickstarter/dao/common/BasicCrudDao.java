package com.tyomsky.kickstarter.dao.common;

import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

public interface BasicCrudDao<E> {

    E save(E entity);

    E merge(E entity);

    E get(Serializable id);

    E get(String property, Object value);

    List<E> getList(String property, Object value);

    void remove(Serializable id);

    Long getCount();

    List<E> getAll();

    E getRandom();

    E getRandom(Criterion restriction);

}
