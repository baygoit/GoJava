package ua.com.goit.gojava.m__jane.service.impl;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.m__jane.model.QuestionCategory;
import ua.com.goit.gojava.m__jane.service.QuestionCategoryService;

public class QuestionCategoryServiceImpl implements QuestionCategoryService {
	
	private final List<QuestionCategory> questionCategories = new ArrayList<QuestionCategory>() {
	
		private static final long serialVersionUID = 2L;

		{
			this.add(new QuestionCategory() {
				{
					this.setId(1);
					this.setName("Продавець");
				}
			});
			this.add(new QuestionCategory() {
				{
					this.setId(2);
					this.setName("Старший продавець");
				}
			});
			this.add(new QuestionCategory() {
				{
					this.setId(3);
					this.setName("Босс");
				}
			});
			
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
