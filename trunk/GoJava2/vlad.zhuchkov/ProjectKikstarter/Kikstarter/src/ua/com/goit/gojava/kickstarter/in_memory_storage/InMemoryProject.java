package ua.com.goit.gojava.kickstarter.in_memory_storage;


import java.io.Serializable;
import java.util.Random;

public class InMemoryProject implements Serializable, Project {
	private final int MAX_PROJECT_COST = 1_000_000;
	private String name;
	private String description;
	private ProjectParameters param;

	public InMemoryProject(String name, int num) {
		param = new ProjectParameters();
		Random rand = new Random();
		this.name = name;
		description = "Decription of project " + num;
		param.setCost(rand.nextInt(MAX_PROJECT_COST));
		param.setAlreadyCollected(rand.nextInt(param.getCost()));
		param.setDays(rand.nextInt(365));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InMemoryProject other = (InMemoryProject) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public ProjectParameters getParameters() {
		return param;
	}
	@Override
	public void increaseAmount(int amount){
		param.addAlreadyCollected(amount);
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
