import java.util.ArrayList;
import java.util.Random;

public class Category {
	private String name;
	private ArrayList<Project> projectCatalog = new ArrayList<>();

	public Category(String name) {
		StringBuffer sb = new StringBuffer(name);
		// имя проекта - это имя католога в единственном числе + №. Временно.
		sb.deleteCharAt(name.length() - 1);
		this.name = sb.toString();
		Random rand = new Random();
		for (int i = 0; i < rand.nextInt(10) + 1; i++) {
			Project project = new Project(this.name + " " + (i + 1), i + 1);
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
		Reader reader = new Reader();
		boolean inputRight = true;
		do {
			if (i > projectCatalog.size()||i<0) {
				System.out.println("Illigal category number. Try again");
				i = reader.readInt()-1;
				inputRight = false;
			}else{
				inputRight = true;
			}
		} while (!inputRight);
		return projectCatalog.get(i);
	}

}
