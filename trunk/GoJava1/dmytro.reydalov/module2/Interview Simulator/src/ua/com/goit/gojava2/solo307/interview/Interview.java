package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.List;

public class Interview {
	
	private int correctAnswers;
	private int partiallyCorrectAnswers;
	private int incorrectAnswers;
	private List <Category> categories = new ArrayList <Category>();
	private Category currentCategory = new Category();

	TimeCounter timecounter;
	
	public Interview(){ 
		correctAnswers = 0;
		partiallyCorrectAnswers = 0;
		incorrectAnswers = 0;
		currentCategory = new Category();
	}

	public int getCorrectAnswers(){
		return correctAnswers;
	}

	public void setCorrectAnswers(int correctAnswers){
		this.correctAnswers = correctAnswers;
	}

	public int getPartiallyCorrectAnswers(){
		return partiallyCorrectAnswers;
	}

	public void setPartialylCorrectAnswers(int partialCorrectAnswers){
		this.partiallyCorrectAnswers = partialCorrectAnswers;
	}
	
	public int getIncorrectAnswers(){
		return incorrectAnswers;
	}

	public void setIncorrectAnswers(int wrongAnswers){
		this.incorrectAnswers = wrongAnswers;
	}
	
	public List<Category> getCategories(){
		return categories;
	}

	public void setCategories(List<Category> categories){
		this.categories = categories;
	}
	
	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}
	
	public void addCategory(String name, String path){
		categories.add(new Category(name, path));
	}
	
	public void composeCategory(List<Category> categories){
		for(Category category: categories){
			currentCategory.addQuestions(category.getQuestions());
		}
	}
	
	public void addCorrectAnswers(){
		correctAnswers++;
	}
	
	public void addPartiallyCorrectAnswers(){
		partiallyCorrectAnswers++;
	}
	
	public void addIncorrectAnswers(){
		incorrectAnswers++;
	}
	
	public void printResults(){
		System.out.println("correct answers " + correctAnswers);
		System.out.println("partial correct answers " + partiallyCorrectAnswers);
		System.out.println("incorrect answers " + incorrectAnswers);
	}
}
