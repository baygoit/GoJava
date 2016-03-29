package com.vladik.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vladik.dao.ConnectionProvider;
import com.vladik.model.Faq;
import com.vladik.dao.AbstractFaqDao;
import com.vladik.model.Project;

public class FaqDaoMysqlImpl extends AbstractFaqDao {
    private static final String INSERT_FAQ = "INSERT INTO Faqs (project_id, question) VALUES (?, ?)";
    private static final String DELETE_FAQ = "DELETE FROM Faqs WHERE project_id = ?";
    private static final String SELECT_ALL_FAQS = "SELECT project_id, question, answer FROM Faqs";
    private static final String COUNT_ALL_FAQS = "SELECT count(*) FROM Faqs";
    private static final String SELECT_PROJECT_FAQS = "SELECT project_id, question, answer FROM Faqs WHERE project_id = ?";

    @Override
    public void add(Faq faq) {
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_FAQ);

            statement.setInt(1, faq.getProjectID());
            statement.setString(2, faq.getQuestion());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Faq faq) {
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_FAQ);

            statement.setInt(1, faq.getProjectID());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Faq> getAll() {
        List<Faq> faqs = new ArrayList<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_FAQS);

            while (resultSet.next()) {
                Faq faq = new Faq();
                faq.setProjectID(resultSet.getInt("project_id"));
                faq.setQuestion(resultSet.getString("question"));
                faq.setAnswer(resultSet.getString("answer"));
                faqs.add(faq);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faqs;
    }

    @Override
    public int getSize() {
        int amountOfCatrgories = 0;
        try {
            Connection connection = ConnectionProvider.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(COUNT_ALL_FAQS);
            while (resultSet.next()) {
                amountOfCatrgories = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amountOfCatrgories;
    }

    @Override
    public String getProjectFaqs(Project project) {
        StringBuilder result = new StringBuilder();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_PROJECT_FAQS);

            statement.setInt(1, project.getUniqueID());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String question = resultSet.getString("question");
                result.append("\n  question : " + question + "\n");

                String answer = resultSet.getString("answer");
                if (answer == null || answer.isEmpty()) {
                    result.append("  answer: There is no answer yet \n");
                } else {
                    result.append("  answer : " + answer + "\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
