package ua.com.goit.gojava7.kickstarter.dao.file;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.util.FileDAO;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionFileDAO extends FileDAO<Question> implements QuestionsDAO {

    public QuestionFileDAO() {
        super(Question.class);
    }

    public QuestionFileDAO(String pathToFile) {
        super(Question.class, pathToFile);
    }

    @Override
    public List<Question> getByProject(int projectId) {
        return getAll().stream()
                .filter(pledge -> pledge.getProjectId() == projectId)
                .collect(Collectors.toList());
    }
}
