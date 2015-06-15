package com.morkva.model.dao.jdbc.mysql;

import com.morkva.entities.Category;
import com.morkva.model.dao.DAO;
import com.morkva.model.dao.DAOFactory;
import com.morkva.model.dao.PersistException;
import com.morkva.model.dao.jdbc.AbstractJDBCDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by koros on 12.06.2015.
 */
public class MySQLCategoryDao extends AbstractJDBCDao<Category, Integer> implements DAO<Category, Integer> {

    private class PersistCategory extends Category {
        public void setId(int id) {
            super.setId(id);
        }
    }

    public MySQLCategoryDao(DAOFactory<Connection> parentFactory, Connection connection) {
        super(parentFactory, connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT categories.id, categories.name FROM categories";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE categories SET `name`=? WHERE id=?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM categories WHERE id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO categories (`name`) VALUES (?);";
    }

    @Override
    protected List<Category> parseResultSet(ResultSet resultSet) throws PersistException {
        LinkedList<Category> list = new LinkedList<>();
        try {
            while (resultSet.next()) {
                PersistCategory category = new PersistCategory();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Category object) throws PersistException {
        try {
            statement.setString(1, object.getName());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Category object) throws PersistException {
        try {
            statement.setString(1, object.getName());
            statement.setInt(2, object.getId());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    public Category create() throws PersistException {
        Category category = new Category();
        return persist(category);
    }
}
