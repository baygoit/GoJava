package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Question;

public interface QuestionsDAO extends DataSource<Question>{
    
    List<Question> getByProject(int projectId);
    
}
