package com.morkva.model.dao.jdbc;

import com.morkva.model.dao.DAOFactory;
import com.morkva.model.dao.Identified;
import com.morkva.model.dao.PersistException;

import java.lang.reflect.Field;
import java.sql.Connection;

/**
 * Created by koros on 15.06.2015.
 */
public class ManyToOne<Owner extends Identified, Dependence extends Identified> {

    private DAOFactory<Connection> factory;

    private Field field;

    private String name;

    private int hash;

    public ManyToOne(Class<Owner> ownerClass, DAOFactory<Connection> factory, String field) throws NoSuchFieldException {
        this.factory = factory;
        this.field = ownerClass.getDeclaredField(field);
        this.field.setAccessible(true);
        name = ownerClass.getSimpleName() + " to " + this.field.getType().getSimpleName();
        hash = ownerClass.hashCode() & field.hashCode();
    }

    public Dependence getDependence(Owner owner) throws IllegalAccessException {
        return (Dependence) field.get(owner);
    }

    public void setDependence(Owner owner, Dependence dependence) throws IllegalAccessException {
        field.set(owner, dependence);
    }

    public Identified persistDependence(Owner owner, Connection connection) throws IllegalAccessException, PersistException {
        return factory.getDao(connection, field.getType()).persist(getDependence(owner));
    }

    public void updateDependence(Owner owner, Connection connection) throws IllegalAccessException, PersistException {
        factory.getDao(connection, field.getType()).update(getDependence(owner));
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
