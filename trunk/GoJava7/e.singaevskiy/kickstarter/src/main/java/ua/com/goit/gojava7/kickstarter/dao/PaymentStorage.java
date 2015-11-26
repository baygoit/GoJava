package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.beans.Payment;

public interface PaymentStorage extends DataStorage<Payment>{
    
    default List<Payment> getByProject(int projectId) {
        return getAll().stream()
                .filter(pledge -> pledge.getProjectId() == projectId)
                .collect(Collectors.toList());
    }
    
    default long getSum(int projectId) {
        return getAll().stream()
                .filter(pledge -> pledge.getProjectId() == projectId)
                .mapToLong(Payment::getSum)
                .sum();
    }
    
}
