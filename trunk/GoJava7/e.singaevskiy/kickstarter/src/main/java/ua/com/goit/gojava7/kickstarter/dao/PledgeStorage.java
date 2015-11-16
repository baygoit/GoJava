package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.beans.Pledge;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public interface PledgeStorage extends DataStorage<Pledge>{
    
    default List<Pledge> getByProject(Project project) {
        return getAll().stream()
                .filter(pledge -> pledge.getProject().equals(project))
                .collect(Collectors.toList());
    }
    
    default long getSum(Project project) {
        return getAll().stream()
                .filter(pledge -> pledge.getProject().equals(project))
                .mapToLong(Pledge::paymentPledgeSum)
                .sum();
    }
}
