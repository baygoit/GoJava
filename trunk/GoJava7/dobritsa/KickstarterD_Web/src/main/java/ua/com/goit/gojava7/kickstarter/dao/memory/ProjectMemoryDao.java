package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.MemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.models.Project;

public class ProjectMemoryDao extends MemoryDao<Project> implements ProjectDao {

	public ProjectMemoryDao(List<Project> data) {
		super(data);
	}

	@Override
	public Project getByNumber(int number) {
		int index = number - 1;
		return get(index);
	}

	@Override
	public void updatePledged(Project project, int amount) {
		project.updatePledged(amount);
	}

	@Override
	public List<Project> getByCategory(int categoryId) {
		 return this.getAll().stream()
	                .filter(project -> project.getCategoryId() == categoryId)
	                .collect(Collectors.toList());
	}
}
