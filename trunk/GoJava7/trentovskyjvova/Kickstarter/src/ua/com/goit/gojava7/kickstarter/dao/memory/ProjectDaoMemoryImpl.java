package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectDaoMemoryImpl implements ProjectDao {
	List<Project> projects = new ArrayList<>();
	
	@Override
	public List<Project> getProjects(int categoryId) {	
		projects = new ArrayList<>();
		
		Project progect1 = new Project("Super project", 1);
		progect1.setCategoryId(1);
		progect1.setDaysToGo(14);
		progect1.setGoal(100);
		progect1.setOwner("owner");
		progect1.setDescription("descr");
		progect1.setLinkVideo("link");
		
		if (progect1.getCategoryId() == categoryId){
			projects.add(progect1);
		}
		
		Project progect2 = new Project("Second project", 2);
		progect2.setCategoryId(1);
		
		if (progect1.getCategoryId() == categoryId){
			projects.add(progect2);
		}
		return projects;
	}

	@Override
	public Project getProject(int id) {
		Project result = null;
		for (Project project : projects) {
			if(project.getId() == id){
				result = project;
				break;
			}
		}
		return result;
	}

	@Override
	public int size() {
		return projects.size();
	}

}
