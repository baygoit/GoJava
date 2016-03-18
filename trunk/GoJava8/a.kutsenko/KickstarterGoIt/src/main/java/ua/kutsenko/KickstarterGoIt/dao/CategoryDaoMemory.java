package ua.kutsenko.KickstarterGoIt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ua.kutsenko.KickstarterGoIt.domain.Category;
import ua.kutsenko.KickstarterGoIt.domain.Investment;
import ua.kutsenko.KickstarterGoIt.domain.Project;
import ua.kutsenko.KickstarterGoIt.domain.Question;

public class CategoryDaoMemory implements CategoryDao {
	List<Category> categories = new ArrayList<Category>();
	Category category = new Category();

	@Override
	public Category getByName(String name) {
		for (Category category : categories)
			if (category.getName().equals(name)) {
				return category;

			}
		throw new IllegalArgumentException("Category not found");
		
	}

	@Override
	public List<String> getCategoryNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addInvestment(Project project, Investment investment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addQuestion(Project project, Question question) {
		// TODO Auto-generated method stub

	}

}
