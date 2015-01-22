package ua.com.goit.gojava.m__jane.service.impl;

import java.util.ArrayList;
import java.util.List;
import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.model.Question;
import ua.com.goit.gojava.m__jane.service.ProfileService;
import ua.com.goit.gojava.m__jane.service.QuestionCategoryService;
import ua.com.goit.gojava.m__jane.service.QuestionService;

public class QuestionServiceImpl implements QuestionService{
	
	private final String splitter = "`";
	private final ProfileService profileService = new ProfileServiceImpl();
	private final QuestionCategoryService questionCategoryService = new QuestionCategoryServiceImpl(); 
	
	 private final static String[] QUESTIONS;
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
	
	public QuestionServiceImpl() {

	}

	@Override
	public List<Question> getQuestionList() {
		
		List<Question> listQuestions = new ArrayList<>();
				
		for (int i = 0; i < QUESTIONS.length; i++) {			
			String[] arr = QUESTIONS[i].split(splitter);
			//id|content|questionCategory_id|profile_id|openQuestion
				Question q = new Question();
				q.setId(Integer.parseInt(arr[0]));
				q.setContent(arr[1]);
				q.setQuestionCategory(questionCategoryService.getQuestionCategory(Integer.parseInt(arr[2])));
				q.setProfile(profileService.getProfile(Integer.parseInt(arr[3])));
				q.setOpenQuestion(Boolean.parseBoolean(arr[4]));	
				listQuestions.add(q);		
		}
		
		return listQuestions;
	}


	@Override
	public int getQuestionCount() {		
		return getQuestionList().size();
	}

	@Override
	public Question getQuestion(int questionId) {
		Question foundQuestion = null;
		//TODO replaced by map
		List<Question> listQuestions = getQuestionList();
		for (Question question : listQuestions) {
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
				

		for (int i = 0; i < QUESTIONS.length; i++) {			
			String[] arr = QUESTIONS[i].split(splitter);
			
			if (Integer.parseInt(arr[3])!=profile.getId()) continue;
			//id|content|questionCategory_id|profile_id|openQuestion
				Question q = new Question();
				q.setId(Integer.parseInt(arr[0]));
				q.setContent(arr[1]);
				q.setQuestionCategory(questionCategoryService.getQuestionCategory(Integer.parseInt(arr[2])));
				q.setProfile(profileService.getProfile(Integer.parseInt(arr[3])));
				q.setOpenQuestion(Boolean.parseBoolean(arr[4]));	
				listQuestions.add(q);		
		}
		
		return listQuestions;
	}

}
