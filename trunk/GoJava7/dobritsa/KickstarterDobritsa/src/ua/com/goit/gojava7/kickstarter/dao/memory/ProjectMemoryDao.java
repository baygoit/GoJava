package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.MemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectMemoryDao extends MemoryDao<Project> implements ProjectStorage {

	public ProjectMemoryDao(List<Project> data) {
		super(data);
	}

}
