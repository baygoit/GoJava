package com.kickstarter.model;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
	
	private List<String> quotes;
	private List<Сategory> categories;
	private List<Project> projects;
	
	public DataStorage() {
		quotes = new ArrayList<String>();
		categories = new ArrayList<Сategory>();
		projects = new ArrayList<Project>();
	}
	
	public void addQuote(String quote) {
		quotes.add(quote);
	}
	
	public void addCategory(Сategory category) {
		categories.add(category);
	}
	
    public void addProject(Project project) {
    	projects.add(project);
    }
	
	public String getRundomQuote() {
		int i = (int)(Math.random() * quotes.size());
		return quotes.get(i);
	}
	
	public List<Сategory> getCategoriesList() {
		return categories;
	}

   public List<Project> getSpecificProjects(Сategory сategory) {
	   List<Project> result = new ArrayList<Project>();
	   for(Project p: projects) {
		   if(p.getСategory().equals(сategory)) {
			   result.add(p);
		   }  
	   }
	   return result;
   }
}