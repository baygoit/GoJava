package com.morkva.model.dao.jdbc.mysql;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
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
public class MySQLProjectDao extends AbstractJDBCDao<Project, Integer> {

    private class PersistProject extends Project {
        public void setId(int id) {
            super.setId(id);
        }
    }

    public MySQLProjectDao(DAOFactory<Connection> parentFactory, Connection connection) {
        super(parentFactory, connection);
        addRelation(Project.class, "category");
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM projects";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE projects " +
                "SET " +
                "`name` = ?, " +
                "`short_description` = ?," +
                "`current_money` = ?," +
                "`need_money` = ?," +
                "`days_left` = ?," +
                "`history` = ?," +
                "`video_url` = ?," +
                "`category_id` = ? " +
                "WHERE projects.id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM projects WHERE id = ?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO projects " +
                "(`name`, " +
                "short_description, " +
                "current_money, " +
                "need_money, " +
                "days_left, " +
                "history, " +
                "video_url, " +
                "category_id) VALUES (?,?,?,?,?,?,?,?);";
    }

    @Override
    protected List<Project> parseResultSet(ResultSet resultSet) throws PersistException {
        LinkedList<Project> list = new LinkedList<>();
        try {
            while (resultSet.next()) {
                PersistProject project = new PersistProject();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setShortDescr(resultSet.getString("short_description"));
                project.setCurrentMoney(resultSet.getInt("current_money"));
                project.setNeedMoney(resultSet.getInt("need_money"));
                project.setDaysLeft(resultSet.getInt("days_left"));
                project.setHistory(resultSet.getString("history"));
                project.setUrlVideo(resultSet.getString("video_url"));
                project.setCategory((Category) getDependence(Category.class, resultSet.getInt("category_id")));
                list.add(project);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return list;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Project object) throws PersistException {
        try {
            int categoryId = (object.getCategory() == null || object.getCategory().getId() == null) ? -1
                    : object.getCategory().getId();

            statement.setString(1, object.getName());
            statement.setString(2, object.getShortDescr());
            statement.setInt(3, object.getCurrentMoney());
            statement.setInt(4, object.getNeedMoney());
            statement.setInt(5, object.getDaysLeft());
            statement.setString(6, object.getHistory());
            statement.setString(7, object.getUrlVideo());
            statement.setInt(8, categoryId);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Project object) throws PersistException {
        try {
            int categoryId = (object.getCategory() == null || object.getCategory().getId() == null) ? -1
                    : object.getCategory().getId();

            statement.setString(1, object.getName());
            statement.setString(2, object.getShortDescr());
            statement.setInt(3, object.getCurrentMoney());
            statement.setInt(4, object.getNeedMoney());
            statement.setInt(5, object.getDaysLeft());
            statement.setString(6, object.getHistory());
            statement.setString(7, object.getUrlVideo());
            statement.setInt(8, categoryId);
            statement.setInt(9, object.getId());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    public Project create() throws PersistException {
        Project project = new Project();
        return persist(project);
    }
}
