package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Payment;

public interface PaymentStorage extends DataStorage<Payment>{
    
    default List<Payment> getByProject(Project project) {
        return getAll().stream()
                .filter(pledge -> pledge.getProject().equals(project))
                .collect(Collectors.toList());
    }
    
    default long getSum(Project project) {
        return getAll().stream()
                .filter(pledge -> pledge.getProject().equals(project))
                .mapToLong(Payment::getSum)
                .sum();
    }
    
}
