package com.sergiisavin.kickstarter;

import java.util.ArrayList;
import java.util.List;

import com.sergiisavin.kickstarter.category.container.Categories;
import com.sergiisavin.kickstarter.project.Project;
import com.sergiisavin.kickstarter.project.container.Projects;
import com.sergiisavin.kickstarter.quote.container.Quotes;

public class Kickstarter {
	
	private Quotes quotes;
	private Categories categories;
	private Projects projects;

	public Kickstarter(){
	
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public void setQuotes(Quotes quotes) {
		this.quotes = quotes;	
	}

	public String getRandomQuote() {
		return quotes.getRandomQuote();
	}
	
	public String[] getCategories(){
		String[] result = new String[categories.getSize()];
		for(int index = 0; index < categories.getSize(); index++){
			result[index] = categories.get(index).toString();
		}
		return result;
	}

	public String[] getProjectsByCategory(String categoryName) {
		List<Project> projects = new ArrayList<Project>();
		
		for(int index = 0; index < this.projects.getSize(); index++){
			Project project = this.projects.getProject(index);
			if(project.getCategoryName().equals(categoryName)){
				projects.add(project);
			}
		}
		
		String[] projectsByCategory = new String[projects.size()];
		for(int index = 0; index < projects.size(); index++){
			Project project = projects.get(index);
			projectsByCategory[index] = project.getName() + " " + project.getCategoryName() + " " + project.getTargetSumm() + " " + project.getCurrentSumm()
					+ " " + project.getExpireDate();
		}
		
		return projectsByCategory;
	}

	public void injectProjects(Projects projects) {
		this.projects = projects;
	}
	
}
