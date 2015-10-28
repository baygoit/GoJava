package ua.com.goit.gojava.alexfurman.kickstarter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Project;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.QuestionAndAnswers;

public interface QuestionAndAnswersRepository extends JpaRepository<QuestionAndAnswers, Integer> {

	List<QuestionAndAnswers> findByProject(Project project);

}
