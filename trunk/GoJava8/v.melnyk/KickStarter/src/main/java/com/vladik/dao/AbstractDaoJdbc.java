package com.vladik.dao;

import com.vladik.model.Category;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public abstract class AbstractDaoJdbc<T extends Serializable> implements GenericDao<T> {
    private Class<T> type;
    public String tableName;
    public Field field;

    public AbstractDaoJdbc(Class<T> type) {
        this.type = type;
        try {
            field = type.getField("TABLE_NAME");
            field.setAccessible(true);
            T object = (T) type.getClass();
            tableName = (String) field.get(object);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {

        }
    }


    private final String INSERT_T = "INSERT INTO " + tableName + " (name) VALUES (?)";
    private final String DELETE_T = "DELETE FROM " + tableName + " WHERE id = ?";
    private final String SELECT_ALL_T = "SELECT id, name FROM " + tableName;
    private final String COUNT_ALL_T = "SELECT count(*) FROM " + tableName;


    @Override
    public void add(T element) {

    }

    @Override
    public void remove(T element) {

    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
