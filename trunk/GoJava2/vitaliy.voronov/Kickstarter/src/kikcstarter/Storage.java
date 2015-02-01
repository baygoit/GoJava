package kikcstarter;

import java.util.ArrayList;

public class Storage {
	ArrayList<Project> projectsEducation = new ArrayList<>();
	ArrayList<Project> projectsAccountant = new ArrayList<>();
	ArrayList<Project> projects = new ArrayList<>();

	public ArrayList<Project> getProjectsEducation() {
		return projectsEducation;
	}
	
	public ArrayList<Project> getProjectsByCategory(Category category) {
		ArrayList<Project> projectsByCategory = new ArrayList<Project>();
		
		for(Project project: projects)
		{
			if(project.getCategory() == category)
			{
				projectsByCategory.add(project);
			}
		}
		return projectsByCategory;
	}

	public ArrayList<Project> getProjectsAccountant() {
		return projectsAccountant;
	}

	
	public Storage() {
		initProjects();
	}

	private void initProjects() {
		Project englishTeacher = new Project("English teacher", "Virtual english teacher",Category.EDUCATION, 10000, 300, 120);
		projects.add(englishTeacher);
		
		Project mathTeacher = new Project("Mathematics teacher","Virtual mathematics teacher",Category.EDUCATION,15000,5000,60);
		projects.add(mathTeacher);
		
		Project homeAccountant = new Project("Home accountent","Virtual accountant",Category.FINANCE,20000,2000,253);
		projects.add(homeAccountant);
		
		Project companyAccountant = new Project("Company accountant","Virtual company accountent",Category.FINANCE,50000,20000,126);
		projects.add(companyAccountant);
		

	}

}
