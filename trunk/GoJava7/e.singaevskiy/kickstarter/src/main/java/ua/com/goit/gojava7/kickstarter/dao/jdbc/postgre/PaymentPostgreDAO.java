package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.JdbcDispatcher;

public class PaymentPostgreDAO implements PaymentStorage {

    private static final String TABLE = "payment";
    private static final String FIELDS = "cardId,date,username,sum,project_id,reward_id";
    private static final String INSERTION = FIELDS.replaceAll("[^,]+", "?");
    private static final String KEY = "id";
    
    private JdbcDispatcher dispatcher;

    public PaymentPostgreDAO(JdbcDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void clear() {
        String sql = "delete from " + TABLE;
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement()) {
            statement.execute(sql);
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        }
    }

    @Override
    public Payment get(int index) {
        String sql = "select " + FIELDS + " from " + TABLE + " where " + KEY + " = " + index;
        Payment element = null;
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);) {    
            if (resultSet.next()) {
                element = readElementFromRecord(resultSet);
            }
        } catch (SQLException e) {
            dispatcher.processException(e);
        }
        return element;
    }

    @Override
    public void add(Payment element) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
        try(Connection connection = dispatcher.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            writeElementToRecord(element, statement);
            statement.executeUpdate();  
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        }
    }

    @Override
    public void addAll(List<Payment> elements) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
        try(Connection connection = dispatcher.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Payment element : elements) {
                writeElementToRecord(element, statement);
                statement.executeUpdate();
            } 
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        } 
    }

    @Override
    public List<Payment> getAll() {
        String sql = "select " + FIELDS + " from " + TABLE;
        List<Payment> result = new ArrayList<>();
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(readElementFromRecord(resultSet));
            }
        } catch (SQLException e) {
            dispatcher.processException(e);
        }       
        return result;
    }

    @Override
    public List<Payment> getByProject(Project category) {
        String sql = "select " + FIELDS + " from " + TABLE + " where project_id = " + category.getId();
        List<Payment> result = new ArrayList<>();
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(readElementFromRecord(resultSet));
            }
        } catch (SQLException e) {
            dispatcher.processException(e);
        }       
        return result;
    }

    private Payment readElementFromRecord(ResultSet resultSet) throws SQLException {
        Payment element = new Payment();
        element.setCardId(resultSet.getInt("cardId"));
        element.setDate(resultSet.getDate("date"));
        element.setUser(resultSet.getString("username"));        
        element.setSum(resultSet.getLong("sum"));
        element.setReward(null);//resultSet.getInt("reward_id"));
        element.setProject(null);//resultSet.getInt("project_id"));
        return element;
    }

    private void writeElementToRecord(Payment element, PreparedStatement statement) throws SQLException {
        int i = 0;
        statement.setLong(++i, element.getCardId());
        statement.setDate(++i, element.getDate());
        statement.setString(++i, element.getUser());
        statement.setLong(++i, element.getSum());
        statement.setInt(++i, element.getProject().getId());
        if (element.getReward() != null) {
            statement.setInt(++i, element.getReward().getId());
        } else {
            statement.setNull(++i, java.sql.Types.INTEGER);
        }       
    }
}
