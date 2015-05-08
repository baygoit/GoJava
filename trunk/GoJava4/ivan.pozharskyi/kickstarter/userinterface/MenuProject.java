package com.ivanpozharskyi.kickstarter.userinterface;

import com.ivanpozharskyi.kickstarter.datastorage.Project;

public class MenuProject implements Menu{
	private Project project;
	
	public void setProject(Project project){
		this.project = project;
	}
	public void show(){
		System.out.println(project.getDetailDescription());
	}
	@Override
	public void setChoise(Object choise) {
		project = (Project) choise;
		
	}
}
