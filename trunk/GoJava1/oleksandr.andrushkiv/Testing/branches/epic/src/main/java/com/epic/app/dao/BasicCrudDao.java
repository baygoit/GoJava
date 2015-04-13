package com.epic.app.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.List;

public interface BasicCrudDao<E> {
    E save(E entity);
    E merge(E entity);

    /**
     * Get entity by ID
     * @param id
     * @return
     */
    @Nullable E get(@NotNull Serializable id);

    /**
     * Get Entity with property equals value.
     *
     * Property can be nested like "person.contact.email"
     *
     * Return only one entity, if found more throw exception.
     *
     * @param property field of entity
     * @param value
     * @return one entity
     */
    @Nullable E get(String property, @NotNull Object value);

    /**
     * Same as get(property, value), but return list of entity
     *
     * @param property field of entity
     * @param value
     * @return list of Entity
     */
    List<E> getList(String property, @NotNull Object value);

    /**
     * Remove entity from database by ID
     * @param id
     */
    void remove(@NotNull Serializable id);

    @NotNull
    Long getCount();

    /**
     * Return all records for this Entity
     * @return
     */
    @NotNull
    List<E> getAll();

}
