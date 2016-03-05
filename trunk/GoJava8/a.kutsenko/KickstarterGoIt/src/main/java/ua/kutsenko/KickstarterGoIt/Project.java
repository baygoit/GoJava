package ua.kutsenko.KickstarterGoIt;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String name;
	private String decription;
	private int requiredBudget;
	private int gatheredBudget;
	private int daysLeft;
	private List<Project> projectList = new ArrayList<Project>();

	public Project(String name, String description, int requiredBudget, int gatheredBudget, int daysLeft) {
		this.name = name;
		this.decription = description;
		this.requiredBudget = requiredBudget;
		this.gatheredBudget = gatheredBudget;
		this.daysLeft = daysLeft;
	}

	


	
	public List<Project> getItProjectList(){
		projectList.add(new Project("Super Computer", "best computer", 45000, 34567,32));
		projectList.add(new Project("Mega phone", "best phone" , 45632, 22137, 41));
		return this.projectList;
	}
	public List<Project> getMusicProjectList(){
		projectList.add(new Project("Super music", "best deep house", 45000, 34567,32));
		projectList.add(new Project("Mega music", "best music" , 45632, 22137, 41));
		return this.projectList;
	}
	public List<Project> getFilmsProjectList(){
		projectList.add(new Project("Super Film", "best comedy", 45000, 34567,32));
		projectList.add(new Project("Mega Film", "best horror" , 45632, 22137, 41));
		return this.projectList;
	}
	public void showInfo(){
		for(int i = 0 ; i < projectList.size(); i++){
			System.out.print(projectList.toString());
			System.out.println();
		}
		
	}
}
