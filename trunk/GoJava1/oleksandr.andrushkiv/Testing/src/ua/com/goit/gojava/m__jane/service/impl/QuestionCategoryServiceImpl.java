package ua.com.goit.gojava.m__jane.service.impl;

import java.util.ArrayList;
import java.util.List;
import ua.com.goit.gojava.m__jane.model.QuestionCategory;

import ua.com.goit.gojava.m__jane.service.QuestionCategoryService;

public class QuestionCategoryServiceImpl implements QuestionCategoryService {

	private final String splitter = "`";

	private final static String[] QUESTION_CATEGORIES;
	static {
		QUESTION_CATEGORIES = new String[3];
		QUESTION_CATEGORIES[0] = "1`Продавець";
		QUESTION_CATEGORIES[1] = "2`Старший продавець";
		QUESTION_CATEGORIES[2] = "3`Босс";
	}

	@Override
	public QuestionCategory getQuestionCategory(int questionCategoryId) {
		QuestionCategory foundQuestionCategory = null;
		// TODO replaced by map
		List<QuestionCategory> listQuestionCategories = getQuestionCategoryList();
		for (QuestionCategory questionCategory : listQuestionCategories) {
			if (questionCategory.getId() == questionCategoryId) {
				foundQuestionCategory = questionCategory;
				break;
			}
		}
		return foundQuestionCategory;
	}

	protected List<QuestionCategory> getQuestionCategoryList() {

		List<QuestionCategory> list = new ArrayList<>();

		for (int i = 0; i < QUESTION_CATEGORIES.length; i++) {
			String[] arr = QUESTION_CATEGORIES[i].split(splitter);
			QuestionCategory questionCategory = new QuestionCategory();
			questionCategory.setId(Integer.parseInt(arr[0]));
			questionCategory.setName(arr[1]);
			list.add(questionCategory);
		}

		return list;
	}

}
