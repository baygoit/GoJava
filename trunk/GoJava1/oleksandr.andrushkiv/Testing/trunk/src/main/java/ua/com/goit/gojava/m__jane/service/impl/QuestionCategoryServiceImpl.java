package ua.com.goit.gojava.m__jane.service.impl;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.m__jane.model.QuestionCategory;
import ua.com.goit.gojava.m__jane.service.QuestionCategoryService;

public class QuestionCategoryServiceImpl implements QuestionCategoryService {
	
	@SuppressWarnings("serial")
	private final List<QuestionCategory> questionCategories = new ArrayList<QuestionCategory>() {
		{
			this.add(new QuestionCategory(1,"Продавець"));
			this.add(new QuestionCategory(2,"Старший продавець"));
			this.add(new QuestionCategory(3,"Босс"));			
		}

	};
	

	@Override
	public QuestionCategory getQuestionCategory(int questionCategoryId) {

		for (QuestionCategory questionCategory : questionCategories) {
			if (questionCategory.getId() == questionCategoryId) {
				return questionCategory;
			}
		}
		return null;
	}

	protected List<QuestionCategory> getQuestionCategoryList() {
		return questionCategories;
	}

}
