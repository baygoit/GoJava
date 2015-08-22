package ua.com.goit.kyrychok.dao.database;

import ua.com.goit.kyrychok.dao.FaqDao;
import ua.com.goit.kyrychok.dao.database.datasource_provider.DbDataSourceProvider;
import ua.com.goit.kyrychok.dao.database.sql_provider.FaqSqlProvider;
import ua.com.goit.kyrychok.domain.Faq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbFaqDao implements FaqDao {
    private DbDataSourceProvider dbDataSourceProvider;
    private FaqSqlProvider sqlProvider;

    public DbFaqDao(DbDataSourceProvider dbDataSourceProvider, FaqSqlProvider sqlProvider) {
        this.dbDataSourceProvider = dbDataSourceProvider;
        this.sqlProvider = sqlProvider;
    }

    @Override
    public void add(int projectId, Faq faq) {
        try (Connection connection = dbDataSourceProvider.getConnection()) {
            add(projectId, faq, connection);
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    List<Faq> fetch(int projectId, Connection connection) throws SQLException {
        List<Faq> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlProvider.get4Fetch())) {
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

    void add(int projectId, Faq faq, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sqlProvider.get4Add(), new String[]{"faq_id"})) {
            statement.setString(1, faq.getQuestion());
            statement.setString(2, faq.getAnswer());
            statement.setInt(3, projectId);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    faq.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Can't receive faq ID.");
                }
            }
        }
    }

    void addList(int projectId, List<Faq> faqs, Connection connection) throws SQLException {
        for (Faq faq : faqs) {
            add(projectId, faq, connection);
        }
    }
}
