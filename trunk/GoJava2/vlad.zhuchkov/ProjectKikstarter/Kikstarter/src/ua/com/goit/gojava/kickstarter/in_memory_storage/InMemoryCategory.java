package ua.com.goit.gojava.kickstarter.in_memory_storage;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.Project;
import ua.com.goit.gojava.kickstarter.exceptions.IlligalInputException;

public class InMemoryCategory implements Category {

	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}

	private String name;
	private List<Project> catalog = new ArrayList<>();

	public InMemoryCategory(String name) {
		this.name = name;

	}

	public void addProject(Project project) {
		catalog.add(project);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<String> getProjectCatalog() {
		List<String> list = new ArrayList<>();
		for (Project p : catalog)
			list.add(p.getName());
		return list;
	}

	@Override
	public Project getProject(int id) {
		if (id >= catalog.size() || id < 0)
			throw new IlligalInputException();
		return catalog.get(id);
	}

	@Override
	public int size() {
		return catalog.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		InMemoryCategory other = (InMemoryCategory) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
