package com.morkva.model.dao.jdbc;

import com.morkva.model.dao.DAOFactory;
import com.morkva.model.dao.Identified;
import com.morkva.model.dao.PersistException;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by koros on 17.06.2015.
 */
public class OneToMany<O extends Identified, D extends List<Identified>> {
    private DAOFactory<Connection> factory;

    private Field field;

    private String name;

    private int hash;

    public OneToMany(Class<O> ownerClass, DAOFactory<Connection> factory, String field) throws NoSuchFieldException {
        this.factory = factory;
        this.field = ownerClass.getDeclaredField(field);
        this.field.setAccessible(true);
        name = ownerClass.getSimpleName() + " to " + this.field.getType().getSimpleName();
        hash = ownerClass.hashCode() & field.hashCode();
    }

    public D getDependencies(O owner) throws IllegalAccessException {
        return (D) field.get(owner);
    }

    public void setDependencies(O owner, D dependencies) throws IllegalAccessException {
        field.set(owner, dependencies);
    }

    public List<Identified> persistDependencies(O owner, Connection connection) throws IllegalAccessException, PersistException {
        LinkedList<Identified> dependencies = new LinkedList<>();
        for (Identified identified : getDependencies(owner)) {
            Identified dep = factory.getDao(connection, field.getType()).persist(identified);
            dependencies.add(dep);
        }
        return dependencies;
    }

    public void updateDependencies(O owner, Connection connection) throws IllegalAccessException, PersistException {
        for (Identified identified : getDependencies(owner)) {
            factory.getDao(connection, field.getType()).update(identified);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return hash;
    }
}
