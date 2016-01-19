package ua.com.goit.gojava7.kickstarter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.model.Question;
import ua.com.goit.gojava7.kickstarter.validator.MyValidator;

@Repository
public class QuestionService {

    private static final Logger log = LoggerFactory.getLogger(QuestionService.class);

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private MyValidator myValidator;
    @Autowired
    private ProjectDao projectDao;

    public void createQuestion(String text, Long projectId) {
        log.info("<void> createQuestion(text = [{}], projectId = [{}])...", text, projectId);

        if (myValidator.validateQuestion(text)) {
            Question question = new Question();
            question.setQuestion(text);
            question.setProject(projectDao.get(projectId));

            log.info("<void> createQuestion(text = [{}], projectId = [{}]) will create {}", text, projectId, question);
            questionDao.add(question);
        }
    }
}
