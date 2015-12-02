package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.MemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.User;

public class ProjectMemoryDao extends MemoryDao<Project> implements ProjectStorage{

	public ProjectMemoryDao(List<Project> data) {
		super(data);
	}

	@Override
	public Project getByNumber(int number) {
		int index = number;
		return get(index);
	}

	@Override
	public void updatePledged(Project project, int amount) {
		project.updatePledged(amount);
	}

	@Override
	public double getPledged(String projectName) {
		for (Project project : data) {
		if(project.getProjectName() == projectName){
			return project.getPledged();
		}
		}
		throw new NoSuchElementException();
	}

	@Override
	public List<Project> getByCategory(String categoryName) {
		return this.getAll().stream().filter(project -> project.getCategoryName().equals(categoryName))
				.collect(Collectors.toList());
	}

	@Override
	public void userContributeToProject(User user, Double valueOf, String projectName) {
		boolean success = false;
		for (Project project : data) {
			if(project.getProjectName() == projectName){
				project.setPledged((project.getPledged()+valueOf));
				success = true;
			}
		}
		if(!success){
			throw new NoSuchElementException();
		}

	}

	@Override
	public void addProject(Project project) {
		super.add(project);
	}


}
