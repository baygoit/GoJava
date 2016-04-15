package com.vladik.dao.impl;

import com.vladik.dao.AbstractPaymentDao;
import com.vladik.model.Payment;
import com.vladik.model.Project;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentDaoMysqlImpl extends AbstractPaymentDao {
    private static final String INSERT_PAYMENT = "INSERT INTO Payments (project_id, cardholder_name, card_number, donating_sum) VALUES (?, ?, ?, ?)";
    private static final String DELETE_PAYMENT = "DELETE FROM Payments WHERE project_id = ?";
    private static final String SELECT_ALL_PAYMENTS = "SELECT project_id, cardholder_name, card_number, donating_sum  FROM Payments";
    private static final String COUNT_ALL_PAYMENTS = "SELECT count(*) FROM Payments";
    private static final String SELECT_PROJECT_PAYMENTS = "SELECT donating_sum FROM Payments WHERE project_id = ?";

    @Override
    public void add(Payment payment) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_PAYMENT);
            statement.setInt(1, payment.getProjectID());
            statement.setString(2, payment.getCardholderName());
            statement.setLong(3, payment.getCardNumber());
            statement.setInt(4, payment.getDonatingSum());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Payment payment) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_PAYMENT);
            statement.setInt(1, payment.getProjectID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Payment> getAll() {
        List<Payment> payments = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PAYMENTS);
            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setProjectID(resultSet.getInt("project_id"));
                payment.setCardholderName(resultSet.getString("user_name"));
                payment.setCardNumber(resultSet.getLong("credit_card_number"));
                payment.setDonatingSum(resultSet.getInt("donating_sum"));

                payments.add(payment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    @Override
    public int getSize() {
        int amountOfPayments = 0;
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(COUNT_ALL_PAYMENTS);
            while (resultSet.next()) {
                amountOfPayments = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amountOfPayments;
    }

    @Override
    public int getSumProjectPayments(Project project) {
        int collectedSum = 0;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_PROJECT_PAYMENTS);
            statement.setInt(1, project.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int donatingSum = resultSet.getInt("donating_sum");
                collectedSum += donatingSum;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collectedSum;
    }
}
