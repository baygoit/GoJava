package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.MemoryDAO;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionMemoryDAO extends MemoryDAO<Question> implements QuestionsDAO{

    public QuestionMemoryDAO(List<Question> dataSource) {
        super(dataSource);
    }

    @Override
    public List<Question> getByProject(int projectId) {
        return getAll().stream()
                .filter(pledge -> pledge.getProjectId() == projectId)
                .collect(Collectors.toList());
    }

}
