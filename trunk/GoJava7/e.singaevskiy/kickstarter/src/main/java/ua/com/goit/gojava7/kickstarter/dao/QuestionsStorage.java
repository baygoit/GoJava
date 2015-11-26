package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.beans.Question;

public interface QuestionsStorage extends DataStorage<Question>{
    
    default List<Question> getByProject(int projectId) {
        return getAll().stream()
                .filter(pledge -> pledge.getProjectId() == projectId)
                .collect(Collectors.toList());
    }
    
}
