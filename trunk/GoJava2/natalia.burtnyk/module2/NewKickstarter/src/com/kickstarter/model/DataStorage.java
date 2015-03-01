package com.kickstarter.model;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
	
	private List<String> quotes;
	private List<Сategory> categories;
	private List<Project> projects;
	private List<Project> result;
	
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
	
	public Сategory getSpecificCategory(int index) {
		return categories.get(index - 1); 
	}
	
	public int getSizeCategories() {
		return categories.size();
	}
	
	public Project getProject(int index) {
		return result.get(index - 1);
	}
	
	public int getSizeProjectsOfCategory() {
		return result.size();
	}
	
   public List<Project> getSpecificProjects(Сategory сategory) {
	   result = new ArrayList<Project>();
	   for(Project p: projects) {
		   if(p.getСategory().equals(сategory)) {
			   result.add(p);
		   }  
	   }
	   return result;
   }
}