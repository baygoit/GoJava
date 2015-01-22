package ua.com.goit.gojava.m__jane.service.impl;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.model.Question;
import ua.com.goit.gojava.m__jane.service.ProfileService;
import ua.com.goit.gojava.m__jane.service.QuestionCategoryService;
import ua.com.goit.gojava.m__jane.service.QuestionService;

public class QuestionServiceImpl implements QuestionService{
		
	private ProfileService profileService;	
	private QuestionCategoryService questionCategoryService; 
	
	/*private final static String[] QUESTIONS;
	 static {
	    	QUESTIONS = new String[6];
	    	//id`content`questionCategory_id`profile_id`openQuestion
	        QUESTIONS[0] = "1`Як має поводитись продавець у торговому залі, якщо Покупець змушений чекати?`1`1`true";
	        QUESTIONS[1] = "2`Яким є завдання продавця на етапі «Презентація товару»?`2`1`false";
	        QUESTIONS[2] = "3`Як продавець має презентувати товар Покупцю?`1`1`true";
	        QUESTIONS[3] = "4`В чому полягає суть методу презентації Т-Х-В? Наведіть приклад по товару з вашого відділу.`2`1`true";
	        QUESTIONS[4] = "5`Назвіть основні етапи продажу`1`2`false";
	        QUESTIONS[5] = "6`Яким є завдання продавця на етапі «Зустріч покупця»?`3`1`true";
//	        QUESTIONS[6] = "Як необхідно працювати із запереченнями Покупця?";
//	        QUESTIONS[7] = "Що не можна робити на етапі «Відповіді на заперечення»?";
//	        QUESTIONS[8] = "Що таке комплексний продаж? Наведіть приклад.";
//	        QUESTIONS[9] = "Чому продавець повинен завжди здійснювати комплексний продаж?";
	 }
	*/
	 
	private final List<Question> questions = new ArrayList<Question>();
	 
	public QuestionServiceImpl() {
		//initQuestions();
	}
	

	public void initQuestions() {
		questions.add(new Question(1, "Як має поводитись продавець у торговому залі, якщо Покупець змушений чекати?",
				questionCategoryService.getQuestionCategory(1), profileService.getProfile(1), true));	
		
		questions.add(new Question(2, "Яким є завдання продавця на етапі «Презентація товару»?",
				questionCategoryService.getQuestionCategory(2), profileService.getProfile(1), true));	
		
		questions.add(new Question(3, "Як продавець має презентувати товар Покупцю?",
				questionCategoryService.getQuestionCategory(1), profileService.getProfile(1), true));	
		
		questions.add(new Question(4, "В чому полягає суть методу презентації Т-Х-В? Наведіть приклад по товару з вашого відділу.",
				questionCategoryService.getQuestionCategory(2), profileService.getProfile(1), true));	
		
		questions.add(new Question(5, "Назвіть основні етапи продажу",
				questionCategoryService.getQuestionCategory(1), profileService.getProfile(2), true));
		
		questions.add(new Question(6, "Яким є завдання продавця на етапі «Зустріч покупця»?",
				questionCategoryService.getQuestionCategory(3), profileService.getProfile(1), true));	
	}

	
	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}


	public void setQuestionCategoryService(
			QuestionCategoryService questionCategoryService) {
		this.questionCategoryService = questionCategoryService;
	}


	@Override
	public List<Question> getQuestionList() {
		return questions;
	}


	@Override
	public int getQuestionCount() {		
		return questions.size();
	}

	@Override
	public Question getQuestion(int questionId) {
		Question foundQuestion = null;
		for (Question question : questions) {
			if(question.getId() == questionId) {
				foundQuestion = question;
				break;
			}
		}
		return foundQuestion;
	}

	@Override
	public List<Question> getQuestionList(Profile profile) {
		
		List<Question> listQuestions = new ArrayList<>();

		for (Question question : questions) {
			if (question.getProfile().equals(profile)) {
				listQuestions.add(question);
			}		
		}

		return listQuestions;
	}

}
