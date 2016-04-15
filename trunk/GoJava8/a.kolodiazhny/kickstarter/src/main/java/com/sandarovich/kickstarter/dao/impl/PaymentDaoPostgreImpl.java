package com.sandarovich.kickstarter.dao.impl;

import com.sandarovich.kickstarter.dao.PaymentDao;
import com.sandarovich.kickstarter.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class PaymentDaoPostgreImpl implements PaymentDao {
    private static final String SQL_INVEST_INTO_PROJECT =
            "INSERT INTO payment (cardnumber, cardholder, amount, projectid) " +
                    "VALUES (?, ? , ?, ?);";
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void pay(Payment payment, int projectId) {

        jdbcTemplate.update(
                SQL_INVEST_INTO_PROJECT,
                payment.getCardNumber(),
                payment.getCardHolder(),
                payment.getAmount(),
                projectId);
    }
}
