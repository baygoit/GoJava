package ua.com.goit.gojava.kickstarter;


import java.io.Serializable;
import java.util.Random;

public class Project implements Serializable {
	private final int MAX_PROJECT_COST = 1_000_000;
	private String name;
	private String description;
	private ProjectParameters param;

	public Project(String name, int num) {
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
		Project other = (Project) obj;
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

	public ProjectParameters getParameters() {
		return param;
	}
	public void increaseAmount(int amount){
		param.addAlreadyCollected(amount);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
