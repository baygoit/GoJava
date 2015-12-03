package ua.com.goit.gojava7.kickstarter.dao.file;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.FileDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionsFileDao extends FileDao<Question> implements QuestionDao {

	public QuestionsFileDao(List<Question> data) {
		super(data);		
	}
	
	@Override
	public List<Question> getByProject(String projectName) {
		return this.getAll().stream().filter(reward -> reward.getProjectName().equals(projectName))
				.collect(Collectors.toList());
	}

	@Override
	public List<Question> getByProject(int projectId) {
		 return this.getAll().stream()
	                .filter(project -> project.getProjectId() == projectId)
	                .collect(Collectors.toList());
	}

}
