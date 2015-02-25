package ua.com.goit.gojava2.solo307.interview;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Interview {
	
	private List <Category> categories = new ArrayList <Category>();
	List <File> fileNames = new ArrayList<File>();
	public XMLParser parser = new XMLParser();
	public TimeCounter timecounter;
	
	public Interview(){ 

	}

	public List<Category> getCategories(){
		return categories;
	}

	public void setCategories(List<Category> categories){
		this.categories = categories;
	}
	
	public void createCategory(File file) {
		List<Question> questions = new ArrayList<Question>();
		try {
			questions = parser.parse(file);
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		categories.add(new Category(file.getName(), questions));
	}
	
	public Category getComposedCategory(){
		Category composed = new Category("composed");
		for(Category category: categories){
			composed.addQuestions(category.getQuestions());
		}
		return composed;
	}
}
	
	

