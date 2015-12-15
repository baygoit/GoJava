package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.MemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionMemoryDao extends MemoryDao<Question> implements QuestionDao {
	
	public QuestionMemoryDao(List<Question> data) {
		super(data);
	}

	@Override
	public List<Question> getByProject(int projectId) {
		return this.getAll().stream()
                .filter(project -> project.getProjectId() == projectId)
                .collect(Collectors.toList());
	}
}
