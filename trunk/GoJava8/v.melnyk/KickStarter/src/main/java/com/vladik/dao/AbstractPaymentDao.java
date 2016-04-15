package com.vladik.dao;

import java.util.List;

import com.vladik.model.Payment;
import com.vladik.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public abstract class AbstractPaymentDao {

    @Autowired
    public DataSource dataSource;
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public abstract void add(Payment element);

    public abstract void remove(Payment element);

    public abstract List<Payment> getAll();

    public abstract int getSize();

    public abstract int getSumProjectPayments(Project project);

}
