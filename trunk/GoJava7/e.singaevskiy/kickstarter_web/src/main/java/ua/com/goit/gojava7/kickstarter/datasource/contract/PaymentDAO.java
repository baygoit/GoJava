package ua.com.goit.gojava7.kickstarter.datasource.contract;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Payment;

public interface PaymentDAO extends DataSource<Payment>{
    
    List<Payment> getByProject(Long projectId);
    
    long getSum(Long projectId);
    
}
