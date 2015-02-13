package ua.com.goit.gojava2.solo307.interview;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public void addCategory(String name, String path) {
		try {
			categories.add(new Category(name, path));
		} catch (InterviewSimulatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void writeToFile(String name, String time, List<String> results,
			List<String> incorrectAnswers) {
		File file = new File(name);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(name + "\n");
			fileWriter.write(time + "\n");
			for(String line: results){
				fileWriter.write(line + "\n");
			}
			for(String line: incorrectAnswers){
				fileWriter.write(line + "\n");
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
