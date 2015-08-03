package belskii.artem.kickstarter.dao.project;

import java.util.ArrayList;
import java.util.HashMap;

public class ProjectDaoImplHardCoding implements ProjectDao {
	private ArrayList<Project> projects;
	
	public ProjectDaoImplHardCoding(){
		projects = new ArrayList<Project>();
		HashMap<Long, String> paymentVariants = new HashMap<Long, String>();
		paymentVariants.put(new Long(10), "some bonus");
		paymentVariants.put(new Long(30), "other bonus");
		paymentVariants.put(new Long(50), "extra bonus");
		
		this.addProject(new Project("My test project from Art category",new Long(1), new Long(1),"28.07.2015","30.07.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 1, "Project details", paymentVariants));
		this.addProject(new Project("My test project1 from Comics category",new Long(2), new Long(2),"29.07.2015","31.07.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 2,"Project details", paymentVariants));
		this.addProject(new Project("My test project2 from Crafts category",new Long(3), new Long(3),"30.07.2015","01.08.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 3, "Project details", paymentVariants));
		
	} 

	public void addProject(Project projectDetails) {
		projects.add(projectDetails);
	}

	public ArrayList<Project> getProjectList() {
		return projects;
	}

	public Project getProjectDetails(int id) {
		return projects.get(id);
		
	}

	public ArrayList<Project> getProjectFromCategory(int id) {
		ArrayList<Project> answer = new ArrayList<Project>();
		ArrayList<Project> projectList = this.getProjectList(); 
		for ( int i=0; i<projectList.size();i++){
			if (projectList.get(i).getcategoryId() == id){
				answer.add(projectList.get(i));
			}
		}
		return answer;
	}
	
	
}
