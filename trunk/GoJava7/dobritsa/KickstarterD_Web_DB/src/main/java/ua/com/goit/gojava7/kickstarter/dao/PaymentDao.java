package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.model.Payment;

public interface PaymentDao {

    Long calculatePledgedForProject(Long projectId);
    void add(Payment payment);

}
