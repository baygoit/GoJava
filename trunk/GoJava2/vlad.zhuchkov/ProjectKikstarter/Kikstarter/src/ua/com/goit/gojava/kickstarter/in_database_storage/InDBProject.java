package ua.com.goit.gojava.kickstarter.in_database_storage;

import ua.com.goit.gojava.kickstarter.in_memory_storage.Project;
import ua.com.goit.gojava.kickstarter.in_memory_storage.ProjectParameters;

public class InDBProject implements Project {
	private String name;
	private String description;
	private ProjectParameters projectParameters;

	public InDBProject(String name, String description,
			ProjectParameters projectParameters) {
		this.name = name;
		this.description = description;
		this.projectParameters = projectParameters;
	}

	@Override
	public ProjectParameters getParameters() {
		
		return projectParameters;
	}

	@Override
	public void increaseAmount(int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
