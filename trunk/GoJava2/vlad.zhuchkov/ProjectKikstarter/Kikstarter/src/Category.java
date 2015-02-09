import java.util.ArrayList;
import java.util.Random;

public class Category {
	private String name;
	private ArrayList<Project> projectCatalog = new ArrayList<>();

	public Category(String name) {
		this.name=name;
		StringBuffer sb = new StringBuffer(name);
		sb.deleteCharAt(name.length() - 1);
		Random rand = new Random();
		for (int i = 0; i < rand.nextInt(10) + 1; i++) {
			Project project = new Project(sb.toString() + " " + (i + 1), i + 1);
			projectCatalog.add(project);
		}

	}

	public String getName() {
		return name;
	}


	public ArrayList<Project> getProjectCatalog() {
		return projectCatalog;
	}

	public Project getProject(int i) {
		return projectCatalog.get(i);
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
		Category other = (Category) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
