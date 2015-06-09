package com.morkva.model.dao.jdbc;

import com.morkva.entities.Entity;
import com.morkva.model.dao.DAO;
import com.morkva.model.dao.PersistException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by koros on 09.06.2015.
 */
public abstract class AbstractJDBCDao<T extends Entity, PK extends Serializable> implements DAO<T, PK> {

    private Connection connection;

    public AbstractJDBCDao(Connection connection) {
        this.connection = connection;
    }

    public abstract String getSelectQuery();
    public abstract String getUpdateQuery();
    public abstract String getDeleteQuery();
    public abstract String getCreateQuery();

    protected abstract List<T> parseResultSet(ResultSet resultSet) throws PersistException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws PersistException;
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws PersistException;

    @Override
    public T create(T object) throws PersistException {
        if (object.getId() != null) {
            throw new PersistException("Object is already persist.");
        }

        T persistInstance;

        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On persist modify more then one record: " + count);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        sql = getSelectQuery() + " WHERE id = last_insert_id();";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            List<T> list = parseResultSet(resultSet);
            if ((list == null) || (list.size() != 1)) {
                throw new PersistException("Exception on findByPK new persist data.");
            }
            persistInstance = list.iterator().next();
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return persistInstance;
    }

    @Override
    public void delete(T object) throws PersistException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            try {
                statement.setObject(1, object.getId());
            } catch (Exception e) {
                throw new PersistException(e);
            }
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On delete modify more then one record: " + count);
            }
            statement.close();
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    public T getByPK(int id) throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (Exception e) {
            throw new PersistException(e);
        }

        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new PersistException("Received more than one record.");
        }
        return list.iterator().next();
    }

    @Override
    public void update(T object) throws PersistException {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            prepareStatementForUpdate(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On update modify more then one record: " + count);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }

    }

    @Override
    public List<T> getAll() throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }

    @Override
    public List<T> getByCustomQuery(String sql) throws PersistException {
        List<T> list;
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }
}
