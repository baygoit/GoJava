package ua.com.goit.gojava.kickstarter.in_memory_storage;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava.kickstarter.Category;
import ua.com.goit.gojava.kickstarter.exceptions.IlligalInputException;

public class InMemoryCategory implements Category {
	
	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}

	private String name;
	private List<InMemoryProject> projectCatalog = new ArrayList<>();

	public InMemoryCategory(String name) {
		this.name=name;
		StringBuffer sb = new StringBuffer(name);
		sb.deleteCharAt(name.length() - 1);
		Random rand = new Random();
		for (int i = 0; i < rand.nextInt(10) + 1; i++) {
			InMemoryProject project = new InMemoryProject(sb.toString() + " " + (i + 1), i + 1);
			projectCatalog.add(project);
		}

	}

	@Override
	public String getName() {
		return name;
	}


	@Override
	public List<String> getProjectCatalog() {
				List<String> list = new ArrayList<>();
				for(Project p:projectCatalog)
					list.add(p.getName());
		return list;
	}

	@Override
	public Project getProject(int i) {
		if (i>=projectCatalog.size()||i<0)
			throw new IlligalInputException();
		return projectCatalog.get(i);
	}
	@Override
	public int size() {
		return projectCatalog.size();
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
	
	public static void main(String[] args) {
		Category category = new InMemoryCategory("games");
		List<String> temp = category.getProjectCatalog();
		for(String t : temp)
			System.out.println(t);
	}

	
}
