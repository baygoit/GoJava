package com.morkva.model.dao.jdbc.mysql;

import com.morkva.entities.PaymentOption;
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
 * Created by koros on 17.06.2015.
 */
public class MySQLPaymentOptionDao extends AbstractJDBCDao<PaymentOption, Integer> {

    private class PersistedPaymentOption extends PaymentOption {
        @Override
        protected void setId(Integer id) {
            super.setId(id);
        }
    }

    public MySQLPaymentOptionDao(DAOFactory<Connection> parentFactory, Connection connection) {
        super(parentFactory, connection);
        addRelation(PaymentOption.class, "project");
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM payment_options";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE payment_options " +
                "SET description = ?, amount = ?, project_id = ? " +
                "WHERE id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM payment_options WHERE id = ?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO payment_options (description, amount, project_id) VALUES (?,?,?);";
    }

    @Override
    protected List<PaymentOption> parseResultSet(ResultSet resultSet) throws PersistException {
        LinkedList<PaymentOption> list = new LinkedList<>();
        try {
            while (resultSet.next()) {
                PersistedPaymentOption paymentOption = new PersistedPaymentOption();
                paymentOption.setId(resultSet.getInt("id"));
                paymentOption.setDescription(resultSet.getString("description"));
                paymentOption.setAmount(resultSet.getInt("amount"));
                paymentOption.setProject((Project) getDependence(Project.class, resultSet.getInt("project_id")));
                list.add(paymentOption);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return list;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, PaymentOption object) throws PersistException {
        try {
            int projectId = (object.getProject() == null || object.getProject().getId() == null) ? -1
                    : object.getProject().getId();

            statement.setString(1, object.getDescription());
            statement.setInt(2, object.getAmount());
            statement.setInt(3, projectId);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, PaymentOption object) throws PersistException {
        try {
            int projectId = (object.getProject() == null || object.getProject().getId() == null) ? -1
                    : object.getProject().getId();

            statement.setString(1, object.getDescription());
            statement.setInt(2, object.getAmount());
            statement.setInt(3, projectId);
            statement.setInt(4, object.getId());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    public PaymentOption create() throws PersistException {
        PaymentOption paymentOption = new PaymentOption();
        return persist(paymentOption);
    }
}
