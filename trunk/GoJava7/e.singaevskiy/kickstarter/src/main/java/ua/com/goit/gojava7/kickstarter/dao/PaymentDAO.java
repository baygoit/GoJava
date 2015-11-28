package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Payment;

public interface PaymentDAO extends DataSource<Payment>{
    
    List<Payment> getByProject(int projectId);
    
    long getSum(int projectId);
    
}
