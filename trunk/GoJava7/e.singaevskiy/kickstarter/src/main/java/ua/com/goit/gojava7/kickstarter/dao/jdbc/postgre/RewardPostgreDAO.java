package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardPostgreDAO implements RewardDAO {

    private static final String TABLE = "reward";
    private static final String FIELDS = "id,description,pledgeSum,project_id";
    private static final String INSERTION = FIELDS.replaceAll("[^,]+", "?");
    private static final String KEY = "id";
    
    private JdbcDispatcher dispatcher;

    public RewardPostgreDAO(JdbcDispatcher dispatcher) {
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
    public Reward get(int index) {
        String sql = "select " + FIELDS + " from " + TABLE + " where " + KEY + " = " + index;
        Reward element = null;
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
    public void add(Reward element) {
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
    public void addAll(List<Reward> elements) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
        try(Connection connection = dispatcher.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Reward element : elements) {
                writeElementToRecord(element, statement);
                statement.executeUpdate();
            } 
            connection.commit();
        } catch (SQLException e) {
            dispatcher.processException(e);
        } 
    }

    @Override
    public List<Reward> getAll() {
        String sql = "select " + FIELDS + " from " + TABLE;
        List<Reward> result = new ArrayList<>();
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
    public List<Reward> getByProject(int projectId) {
        String sql = "select " + FIELDS + " from " + TABLE + " where project_id = " + projectId;
        List<Reward> result = new ArrayList<>();
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

    private Reward readElementFromRecord(ResultSet resultSet) throws SQLException {
        Reward element = new Reward();
        element.setId(resultSet.getInt("id"));
        element.setDescription(resultSet.getString("description"));
        element.setPledgeSum(resultSet.getLong("pledgeSum"));
        element.setProjectId(resultSet.getInt("project_id"));
        return element;
    }

    private void writeElementToRecord(Reward element, PreparedStatement statement) throws SQLException {
        int i = 0;
        statement.setInt(++i, element.getId());
        statement.setString(++i, element.getDescription());
        statement.setLong(++i, element.getPledgeSum());
        statement.setInt(++i, element.getProjectId());
    }
}
