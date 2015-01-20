package ua.com.goit.gojava.m__jane.dao.impl;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.m__jane.dao.ProfileDao;
import ua.com.goit.gojava.m__jane.dao.QuestionCategoryDao;
import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.model.QuestionCategory;
import ua.com.goit.gojava.m__jane.source.InnerStorage;

public class QuestionCategoryDaoImpl implements QuestionCategoryDao {
	private final static InnerStorage STORAGE = new InnerStorage();
	
	@Override
	public List<QuestionCategory> getQuestionCategoryList() {

		List<QuestionCategory> list = new ArrayList<>();

		List<String> listString = STORAGE.getProfiles();
		for (int i = 0; i < listString.size(); i++) {
			String[] arr = listString.get(i).split(STORAGE.splitter);
			QuestionCategory questionCategory = new QuestionCategory();
			questionCategory.setId(Integer.parseInt(arr[0]));
			questionCategory.setName(arr[1]);
			list.add(questionCategory);
		}

		return list;
	}

}
