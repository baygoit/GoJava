package ua.nenya.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.nenya.controller.CategoryController;
import ua.nenya.dao.QuestionDao;
import ua.nenya.domain.Question;

@Component
public class QuestionValidator implements Validator{
	
	@Autowired
	private QuestionDao questionDao;
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return Question.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Question question = (Question) target;
		
		if (questionDao.isQuestionExist(question)) {
			logger.info("Question "+question.getName()+" in projectId "+question.getProject().getId()+" already exists");
			errors.rejectValue("name", "required-unique-question", "Such question already exists!");
		}
		
	}

}
