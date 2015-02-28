package ua.com.goit.gojava.kickstarter.data;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
	private int id;
	private String name;
	private String description;
	private Status status;
	private Parameters parameters;

	public Project(int id, String name, String description, int cost,
			int collected, Date date, String history, String demo, String faq) {
		this.id = id;
		this.name = name;
		this.description = description;
		parameters = new Parameters(history, demo, faq);
		status = new Status(cost, collected, date);
	}

	public Status getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Parameters getParameters() {
		return parameters;
	}

	@Override
	public int hashCode() {
		return id;
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
		if (id != other.id)
			return false;
		return true;
	}

}
