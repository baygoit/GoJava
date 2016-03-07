package ua.kutsenko.KickstarterGoIt;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String name;
	private String decription;
	private int requiredBudget;
	private int gatheredBudget;
	private int daysLeft;
	private String historyProject;
	private String urlToVideo;
	private String qA;
	private List<Project> projectList = new ArrayList<Project>();

	public Project(String name, String description, int requiredBudget, int gatheredBudget
			, int daysLeft,String history , String url , String qA) {
		this.name = name;
		this.decription = description;
		this.requiredBudget = requiredBudget;
		this.gatheredBudget = gatheredBudget;
		this.daysLeft = daysLeft;
		this.historyProject = history;
		this.urlToVideo = url;
		this.qA = qA;
	}

	public Project() {

	}

	public List<Project> getItProjectList() {
		List<Project> projectList = new ArrayList<Project>();
		projectList.add(new Project("Super Computer", "best computer", 45000, 34567, 32 , "Long history" , "No link" ,"qA" ));
		projectList.add(new Project("Mega phone", "best phone", 45632, 22137, 41, "Long history" , "No link" ,"qA"));
		return projectList;
	}

	public List<Project> getMusicProjectList() {
		List<Project> projectList = new ArrayList<Project>();
		projectList.add(new Project("Super music", "best deep house", 45000, 34567, 32, "Long history" , "No link" ,"qA"));
		projectList.add(new Project("Mega music", "best music", 45632, 22137, 41, "Long history" , "No link" ,"qA"));
		return projectList;
	}

	public List<Project> getFilmsProjectList() {
		List<Project> projectList = new ArrayList<Project>();
		projectList.add(new Project("Super Film", "best comedy", 45000, 34567, 32, "Long history" , "No link" ,"qA"));
		projectList.add(new Project("Mega Film", "best horror", 45632, 22137, 41, "Long history" , "No link" ,"qA"));
		return projectList;
	}

	public void printProjets(Category category) {
		for (int i = 0; i < category.getProjectList().size(); i++) {
			Project project = projectList.get(i);
			System.out.print(i + 1 + " - ");
			printProject(project);
		}

	}

	

	

	public String getUrlToVideo() {
		return urlToVideo;
	}

	

	public String getqA() {
		return qA;
	}

	
	private void printProject(Project project) {
		System.out.println("Name project - " + project.getName());
		System.out.println("Description project - " + project.getDecription());
		System.out.println("Required budget - " + project.getRequiredBudget() + "$");
		System.out.println("Gathered budget - " + project.getGatheredBudget() + "$");
		System.out.println("days to go project - " + project.getDaysLeft());
		System.out.println("--------------------");
		
	}

	public String getName() {
		return name;
	}

	public String getDecription() {
		return decription;
	}

	public int getRequiredBudget() {
		return requiredBudget;
	}

	public int getGatheredBudget() {
		return gatheredBudget;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public String getHistoryProject() {
		// TODO Auto-generated method stub
		return historyProject;
	}
}
