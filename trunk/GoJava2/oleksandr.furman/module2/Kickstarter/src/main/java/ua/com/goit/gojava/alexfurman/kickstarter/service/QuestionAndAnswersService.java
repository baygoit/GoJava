package ua.com.goit.gojava.alexfurman.kickstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Project;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.QuestionAndAnswers;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.User;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.ProjectRepository;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.QuestionAndAnswersRepository;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.UserRepository;

@Service
public class QuestionAndAnswersService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private QuestionAndAnswersRepository questionAndAnswersRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Transactional
	public void save(QuestionAndAnswers questionAndAnswers, String name) {
		User user = userRepository.findByName(name);
		questionAndAnswers.setUser(user);
		questionAndAnswersRepository.save(questionAndAnswers);
	}

	public List<QuestionAndAnswers> findByProject(Project project) {
		return questionAndAnswersRepository.findByProject(project);
	}

	@Transactional
	public void addAnswer(Integer projectId, String answer) {
		QuestionAndAnswers questionAndAnswers = questionAndAnswersRepository.getOne(projectId);
		questionAndAnswers.setAnswer(answer);
		questionAndAnswersRepository.save(questionAndAnswers);
	}
}