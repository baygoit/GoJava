package com.vladik.dao;

import java.util.List;

import com.vladik.model.Payment;
import com.vladik.model.Project;

public abstract class AbstractPaymentDao {

    public final String SEMICOLON_DELIMITER = ";";
    public final String NEW_LINE_SEPARATOR = "\n";

    public abstract void add(Payment element);

    public abstract void remove(Payment element);

    public abstract List<Payment> getAll();

    public abstract int getSize();

    public abstract int getSumProjectPayments(Project project);

}
