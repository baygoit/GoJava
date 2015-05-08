package com.ivanpozharskyi.kickstarter.userinterface;

import com.ivanpozharskyi.kickstarter.datastorage.Category;
import com.ivanpozharskyi.kickstarter.datastorage.ProjectStorage;

public class MenuProjects implements Menu {
	private ProjectStorage projects;
	private Category category;
	
	public void setCategory(Category category){
		this.category = category;
	}
 
	@Override
	public void setChoise(Object choice) {
		category = (Category) choice;
		
	}

	public void show(){
		System.out.println(projects.getProjectsInCategory(category));
		System.out.println("Choose project: ");				
	}
	
}
