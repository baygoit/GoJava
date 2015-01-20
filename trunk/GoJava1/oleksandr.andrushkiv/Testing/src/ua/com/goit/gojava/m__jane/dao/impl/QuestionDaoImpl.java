package ua.com.goit.gojava.m__jane.dao.impl;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.m__jane.dao.QuestionDao;
import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.model.Question;
import ua.com.goit.gojava.m__jane.model.QuestionCategory;
import ua.com.goit.gojava.m__jane.source.InnerStorage;

public class QuestionDaoImpl implements QuestionDao {

	private final static InnerStorage STORAGE = new InnerStorage();

	
	
	@Override
	public List<Question> getQuestionList() {
		
		List<Question> listQuestions = new ArrayList<>();
				
		List<String> listString = STORAGE.getQuestions();
		for (int i = 0; i < listString.size(); i++) {			
			String[] arr = listString.get(i).split(STORAGE.splitter);
			//id|content|questionCategory_id|profile_id|openQuestion
				Question q = new Question();
				q.setId(Integer.parseInt(arr[0]));
				q.setContent(arr[1]);
				q.setQuestionCategory(getQuestionCategoryById(Integer.parseInt(arr[2])));
				q.setProfile(getProfileById(Integer.parseInt(arr[3])));
				q.setOpenQuestion(Boolean.parseBoolean(arr[4]));	
				listQuestions.add(q);		
		}
		
		return listQuestions;
	}

	@Override
	public List<Question> getQuestionList(int profileId) {
		
		List<Question> listQuestions = new ArrayList<>();
				
		List<String> listString = STORAGE.getQuestions();
		for (int i = 0; i < listString.size(); i++) {			
			String[] arr = listString.get(i).split(STORAGE.splitter);
			
			if (Integer.parseInt(arr[3])!=profileId) continue;
			//id|content|questionCategory_id|profile_id|openQuestion
				Question q = new Question();
				q.setId(Integer.parseInt(arr[0]));
				q.setContent(arr[1]);
				q.setQuestionCategory(getQuestionCategoryById(Integer.parseInt(arr[2])));
				q.setProfile(getProfileById(Integer.parseInt(arr[3])));
				q.setOpenQuestion(Boolean.parseBoolean(arr[4]));	
				listQuestions.add(q);		
		}
		
		return listQuestions;
	}
	
	private Profile getProfileById(int parseInt) {
		String[] arr = STORAGE.getProfiles().get(parseInt-1).split(STORAGE.splitter);
		Profile profile = new Profile();
		profile.setId(Integer.parseInt(arr[0]));
		profile.setName(arr[1]);
		
		return profile;
	}

	private QuestionCategory getQuestionCategoryById(int parseInt) {
		String[] arr = STORAGE.getQuestionCategories().get(parseInt-1).split(STORAGE.splitter);
		QuestionCategory questionCategory = new QuestionCategory();
		questionCategory.setId(Integer.parseInt(arr[0]));
		questionCategory.setName(arr[1]);
		
		return questionCategory;
	}

	
}
