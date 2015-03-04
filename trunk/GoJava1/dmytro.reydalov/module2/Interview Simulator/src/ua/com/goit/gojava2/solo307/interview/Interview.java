package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.List;

public class Interview {
	
	private List <Category> categories = new ArrayList <Category>();
	private CategoryDAO categoryDao = new CategoryDAO();

	public List<Category> getCategories(){
		return categories;
	}

	public void setCategories(List<Category> categories){
		this.categories = categories;
	}
	
	public void createCategories() throws InterviewSimulatorException {
		this.categories = categoryDao.getCategoriesList();
		System.out.println(categories);
		List<Question> questions = categoryDao.getQuestions();
		categoryDao.fillQuestions(questions);
		categoryDao.fillCategories(categories, questions);
		
	}
	
	public void createCategories(String [] names) throws InterviewSimulatorException {
		this.categories = categoryDao.getCategories(names);
		List<Question> questions = categoryDao.getQuestions();
		categoryDao.fillQuestions(questions);
		categoryDao.fillCategories(categories, questions);
	}
	
	public Category getComposedCategory(){
		final int CATEGORY_ID = 999;
		final String CATEGORY_NAME = "composite";
		Category composed = new Category(CATEGORY_NAME, CATEGORY_ID);
		for(Category category: categories){
			composed.addQuestions(category.getQuestions());
		}
		return composed;
	}
	

}
	
	

