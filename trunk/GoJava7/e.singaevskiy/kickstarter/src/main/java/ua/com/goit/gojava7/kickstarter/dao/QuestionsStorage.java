package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Question;

public interface QuestionsStorage extends DataStorage<Question>{
    
    default List<Question> getByProject(Project project) {
        return getAll().stream()
                .filter(pledge -> pledge.getProject().equals(project))
                .collect(Collectors.toList());
    }
    
}
