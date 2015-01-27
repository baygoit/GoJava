package ua.com.scread.kickstarter;

import java.util.ArrayList;

public class Model {
	private Categories categories;
	private Projects projects;
	
	public Model() {
		categories = new Categories();
		projects = new Projects();
	}
	
	public void init() {
		Category category1 = new Category("Sport");
		Category category2 = new Category("Science");
		Category category3 = new Category("Virtual reality");
		
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
        
        Project project1 = new Project("Name", "Description", 1000, 10);
        Project project2 = new Project("Oculus rift", "Virtual reality glasses", 1000, 10);
        
        project1.setCategory(category3);
        project2.setCategory(category3);

        projects.add(project1);
        projects.add(project2);
	}

	public String[] getStringCatigories() {
		return categories.getStringCategories();
	}
	
	public Categories getCategories() {
		return categories;
	}
	
	public ArrayList<Project> getProjects(Category category) {
		return projects.getProjects(category);
	}
	
}
