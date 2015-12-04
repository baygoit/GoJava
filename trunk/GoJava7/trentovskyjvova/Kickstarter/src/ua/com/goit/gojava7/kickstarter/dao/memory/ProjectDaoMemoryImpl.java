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
		
		if (progect2.getCategoryId() == categoryId){
			projects.add(progect2);
		}
		
		Project progect3 = new Project("Good project", 3);
		progect3.setCategoryId(2);
		
		if (progect3.getCategoryId() == categoryId){
			projects.add(progect3);
		}
		
		return projects;
	}

	@Override
	public Project getProject(int userChoise, int categoryId) {
		if(userChoise == 0){
			return null;
		} else {
			List<Project> projects = getProjects(categoryId);
			return projects.get(userChoise - 1);
		}
	}

	@Override
	public int size(int categoryId) {
		List<Project> projects = getProjects(categoryId);
		return projects.size();
	}

	@Override
	public Project getProject(int projectId) {
		if(projectId == 0){
			return null;
		} else {
			List<Project> projects = getProjects(0);
			for (Project project : projects) {
				if(project.getId() == projectId) {
					return project;
				}
			} 		
			return null;
		}
	}

}
