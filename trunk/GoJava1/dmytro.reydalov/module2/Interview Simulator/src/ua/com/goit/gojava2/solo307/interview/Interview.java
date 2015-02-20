package ua.com.goit.gojava2.solo307.interview;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Interview {
	
	private int correctAnswers;
	private int partiallyCorrectAnswers;
	private int incorrectAnswers;
	private List <Category> categories = new ArrayList <Category>();
	private Category currentCategory = new Category();

	public TimeCounter timecounter;
	
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
	
	public void addCategory(String name, String path) {
		try {
			categories.add(new Category(name, path));
		} catch (InterviewSimulatorException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	public Category getComposedCategory(){
		Category composed = new Category();
		for(Category category: categories){
			composed.addQuestions(category.getQuestions());
		}
		return composed;
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
	
	public List<String> getResults(){
		List<String> results = new ArrayList<String>();
		results.add(new String("correct answers " + correctAnswers));
		results.add(new String("partial correct answers " + partiallyCorrectAnswers));
		results.add(new String("incorrect answers " + incorrectAnswers));
		return results;
	}
	
	public void printList(List<String> list){
		for(String line: list){
			System.out.println(line);
		}
	}
}

