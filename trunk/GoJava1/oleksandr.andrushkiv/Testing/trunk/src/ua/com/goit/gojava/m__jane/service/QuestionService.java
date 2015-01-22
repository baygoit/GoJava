package ua.com.goit.gojava.m__jane.service;

import java.util.List;

import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.model.Question;

public interface QuestionService {

	
	public List<Question> getQuestionList();
	public List<Question> getQuestionList(Profile profile);
    public int getQuestionCount();
    public Question getQuestion(int profileId);
    
    public void setProfileService(ProfileService profileService);
    public void setQuestionCategoryService(QuestionCategoryService questionCategoryService);
    public void initQuestions();
}
