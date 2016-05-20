package ua.nenya.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.nenya.dao.QuestionDao;
import ua.nenya.dao.db.QuestionDaoImpl;
import ua.nenya.domain.Question;

@Component
public class QuestionValidator implements Validator{
	
	@Autowired
	private QuestionDao questionDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return Question.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Question question = (Question) target;
//		QuestionDao questionDao = new QuestionDaoImpl();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required-name", "Enter question");

		if (questionDao.isQuestionExist(question)) {
			errors.rejectValue("question", "required-unique-question", "Such question already exists!");
		}
		
	}

}
