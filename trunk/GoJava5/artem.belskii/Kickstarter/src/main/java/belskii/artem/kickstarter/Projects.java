package belskii.artem.kickstarter;

import java.util.ArrayList;
import java.util.HashMap;

public class Projects {
	public class ProjectInfo extends HashMap<String, String> {

		public static final String CATEGORY = "Category";
		public static final String TITLE = "Title";
		public static final String DETAILS = "Details";

		public ProjectInfo(String category, String title, String details) {
			super();
			super.put(CATEGORY, category);
			super.put(TITLE, title);
			super.put(DETAILS, details);
		}
	}

	private ArrayList<ProjectInfo> projectList = new ArrayList<ProjectInfo>();

	public void addProject(String category, String title, String details) {
		projectList.add(new ProjectInfo(category, title, details));
	}

	public ProjectInfo getProjectDetails(int id) {
		return projectList.get(id);
	}

	public ArrayList<ProjectInfo> getProjectList() {
		return projectList;
	}

}
