package org.dens.kikstarter.data;

public class Category {

	private String name;
	private String description;
	private Project[] projects = new Project[10];

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + "]";
	}

	public void addProject(Project project) {
		int length = projects.length;
		for(int index = 0; index < length; index++){
			if(projects[index]==null){
				projects[index] = project;
				return;
			}
		}		
		//if array is overflow
		Project[] projectsTemp = new Project[length+10];
		System.arraycopy(projects, 0, projectsTemp, 0, length);
		projects = projectsTemp;
		projects[length] = project;
	}

	public Project[] getProjets() {
		return projects;
	}
	
	

}
