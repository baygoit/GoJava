package com.anmertrix;

import java.util.List;

public class ProjectSource {

	CategorySource categorySource;

	public ProjectSource(CategorySource categorySource) {
		this.categorySource = categorySource;
		categorySource.getCategories().get(0).setProject(new Project("test1"));
		categorySource.getCategories().get(0).setProject(new Project("test2"));
		categorySource.getCategories().get(1).setProject(new Project("test3"));
		categorySource.getCategories().get(1).setProject(new Project("test4"));
		categorySource.getCategories().get(2).setProject(new Project("test5"));
		categorySource.getCategories().get(2).setProject(new Project("test6"));
		categorySource.getCategories().get(3).setProject(new Project("test7"));
		categorySource.getCategories().get(3).setProject(new Project("test8"));
		categorySource.getCategories().get(4).setProject(new Project("test9"));
		categorySource.getCategories().get(4).setProject(new Project("test10"));
		categorySource.getCategories().get(5).setProject(new Project("test11"));
		categorySource.getCategories().get(5).setProject(new Project("test11"));
	}
	
	public String getProjectsMenu(int idCategory) {
		StringBuffer result = new StringBuffer();
		result.append("Please, select project or enter 0 - to exit: \n");
		Category category = categorySource.getCategory(idCategory);
		List<Project> projects = category.getProjects();
		
		for (int i = 0; i < projects.size(); i++) {
			result.append(i + 1).append(" - ").append(projects.get(i).getName()).append("    ");
		}
		
		return result.toString().trim();
	}
	
	public String getNameSelectedProject(int idCategory, int idProject) {
		Category category = categorySource.getCategory(idCategory);
		List<Project> projects = category.getProjects();
		
		return projects.get(idProject).getName();
	}
	
}
