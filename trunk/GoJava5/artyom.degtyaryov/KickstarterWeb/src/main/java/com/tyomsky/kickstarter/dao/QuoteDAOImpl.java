package com.tyomsky.kickstarter.dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuoteDAOImpl implements QuoteDAO {

    DataSource dataSource;

    public QuoteDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String get(int id) {
        String quote = "";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT PRESENTATION FROM QUOTES WHERE ID = (?)");
            preparedStatement.setInt(1,id);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                quote = resultSet.getString("PRESENTATION");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't get JDBC connection!", e);
        }
        return quote;
    }
}
