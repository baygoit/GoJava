package ua.com.goit.gojava.m__jane.service.impl;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.model.Question;
import ua.com.goit.gojava.m__jane.model.QuestionCategory;
import ua.com.goit.gojava.m__jane.service.QuestionService;

public class QuestionServiceImpl implements QuestionService{
			 
	@SuppressWarnings("serial")
	private final List<Question> questions = new ArrayList<Question>() {

		{			
			
			add(new Question() {
				{
					setId(1);
					setContent("Як має поводитись продавець у торговому залі, якщо Покупець змушений чекати?");
					setQuestionCategory(new QuestionCategory(1,"Продавець"));
					setProfile(new Profile(1,"Торгові питання"));
					setOpenQuestion(true);
					
				}
			});
			add(new Question() {
				{
					setId(2);
					setContent("Яким є завдання продавця на етапі «Презентація товару»?");				
					setQuestionCategory(new QuestionCategory(2,"Старший продавець"));
					setProfile(new Profile(1,"Торгові питання"));
					setOpenQuestion(false);
					
				}
			});
			add(new Question() {
				{
					setId(3);
					setContent("Як продавець має презентувати товар Покупцю?");
					setQuestionCategory(new QuestionCategory(1,"Продавець"));
					setProfile(new Profile(1,"Торгові питання"));
					setOpenQuestion(true);
					
				}
			});
			add(new Question() {
				{
					setId(4);
					setContent("В чому полягає суть методу презентації Т-Х-В? Наведіть приклад по товару з вашого відділу.");
					setQuestionCategory(new QuestionCategory(2,"Старший продавець"));
					setProfile(new Profile(1,"Торгові питання"));
					setOpenQuestion(true);
					
				}
			});
			add(new Question() {
				{
					setId(5);
					setContent("Назвіть основні етапи продажу");
					setQuestionCategory(new QuestionCategory(1,"Продавець"));
					setProfile(new Profile(2,"Законодавство"));
					setOpenQuestion(false);
					
				}
			});
			add(new Question() {
				{
					setId(1);
					setContent("Яким є завдання продавця на етапі «Зустріч покупця»?");
					setQuestionCategory(new QuestionCategory(3,"Босс"));
					setProfile(new Profile(1,"Торгові питання"));
					setOpenQuestion(true);
					
				}
			});
		}
	};
		
	 
	public QuestionServiceImpl() {		
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

		for (Question question : questions) {
			if(question.getId() == questionId) {
				return question;
			}
		}
		return null;
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
