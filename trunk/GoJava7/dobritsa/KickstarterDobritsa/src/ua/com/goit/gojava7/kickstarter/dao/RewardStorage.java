package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.domain.Reward;

public interface RewardStorage extends Storage<Reward>{

	public default List<Reward> getByProject(String projectName) {
		
	return this.getAll().stream().filter(project -> project.getProjectName().equals(projectName))
			.collect(Collectors.toList());
}
	
}
