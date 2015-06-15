package com.morkva.model.dao.jdbc;

import com.morkva.model.dao.DAO;
import com.morkva.model.dao.DAOFactory;
import com.morkva.model.dao.Identified;
import com.morkva.model.dao.PersistException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by koros on 09.06.2015.
 */
public abstract class AbstractJDBCDao<T extends Identified<PK>, PK extends Integer> implements DAO<T, PK> {

    private Connection connection;
    private DAOFactory<Connection> parentFactory;
    private Set<ManyToOne> relations = new HashSet<>();

    public AbstractJDBCDao(DAOFactory<Connection> parentFactory, Connection connection) {
        this.connection = connection;
        this.parentFactory = parentFactory;
    }

    public abstract String getSelectQuery();
    public abstract String getUpdateQuery();
    public abstract String getDeleteQuery();
    public abstract String getCreateQuery();

    protected abstract List<T> parseResultSet(ResultSet resultSet) throws PersistException;

    protected Identified getDependence(Class<? extends Identified> dtoClass, Serializable pk) throws PersistException {
        return parentFactory.getDao(connection, dtoClass).getByPK(pk);
    }

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws PersistException;
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws PersistException;

    protected boolean addRelation(Class<? extends Identified> ownerClass, String field) {
        try {
            return relations.add(new ManyToOne(ownerClass, parentFactory, field));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T persist(T object) throws PersistException {
        if (object.getId() != null) {
            throw new PersistException("Object is already persist.");
        }

        saveDependences(object);

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

    private void saveDependences(Identified owner) throws PersistException {
        for (ManyToOne m : relations) {
            try {
                if (m.getDependence(owner) == null) {
                    continue;
                }
                if (m.getDependence(owner).getId() == null) {
                    Identified depend = m.persistDependence(owner, connection);
                    m.setDependence(owner, depend);
                } else {
                    m.updateDependence(owner, connection);
                }
            } catch (Exception e) {
                throw new PersistException("Exception  on save dependence in relation " + m + ".", e);
            }
        }
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
    public T getByPK(Integer id) throws PersistException {
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
        saveDependences(object);
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
