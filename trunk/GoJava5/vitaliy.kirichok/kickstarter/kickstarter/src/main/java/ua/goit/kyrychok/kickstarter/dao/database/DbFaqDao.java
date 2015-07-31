package ua.goit.kyrychok.kickstarter.dao.database;

import ua.goit.kyrychok.kickstarter.dao.FaqDao;
import ua.goit.kyrychok.kickstarter.model.Faq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbFaqDao implements FaqDao {
    private DbDataSourceProvider dbDataSourceProvider;

    public DbFaqDao(DbDataSourceProvider dbDataSourceProvider) {
        this.dbDataSourceProvider = dbDataSourceProvider;
    }

    @Override
    public void add(int projectId, Faq faq) {
        String sql = "INSERT INTO faq " +
                "(question, answer, project_id) " +
                "VALUES " +
                "(?, ?, ?) ";
        try (Connection connection = dbDataSourceProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, faq.getQuestion());
            statement.setString(2, faq.getAnswer());
            statement.setInt(3, projectId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    List<Faq> fetch(int projectId, Connection connection) throws SQLException {
        List<Faq> result = new ArrayList<>();
        String sql = "SELECT f.faq_id AS id, " +
                "f.question AS question, " +
                "f.answer AS answer " +
                "FROM faq f " +
                "WHERE f.project_id = ? " +
                "ORDER BY f.faq_id";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Faq faq = new Faq(resultSet.getString("question"), resultSet.getString("answer"));
                faq.setId(resultSet.getInt("id"));
                result.add(faq);
            }
        }
        return result;
    }
}
