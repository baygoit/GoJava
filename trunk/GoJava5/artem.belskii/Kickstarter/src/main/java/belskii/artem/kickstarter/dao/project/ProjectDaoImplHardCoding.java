package belskii.artem.kickstarter.dao.project;

import java.util.HashMap;

public class ProjectDaoImplHardCoding implements ProjectDao {
	private HashMap<Long, Project> projects;

	public ProjectDaoImplHardCoding(){
		projects = new HashMap<Long, Project>();
		HashMap<Long, String> paymentVariants = new HashMap<Long, String>();
		paymentVariants.put(new Long(10), "some bonus");
		paymentVariants.put(new Long(30), "other bonus");
		paymentVariants.put(new Long(50), "extra bonus");
		
		this.addProject(new Project("My test project from Art category",new Long(1), new Long(1),"28.07.2015","30.07.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 1, "Project details"));
		this.addProject(new Project("My test project1 from Comics category",new Long(2), new Long(2),"29.07.2015","31.07.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 2,"Project details"));
		this.addProject(new Project("My test project2 from Crafts category",new Long(3), new Long(3),"30.07.2015","01.08.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8", 3, "Project details"));
		
	} 

	public void addProject(Project projectDetails) {
		Long index = new Long(this.projects.size());
		projects.put(index, projectDetails);
	}

	public HashMap<Long, Project> getProjectList() {
		return projects;
	}

	public Project getProjectDetails(int id) {
		return projects.get(new Long(id));
		
	}

	public HashMap<Long, Project> getProjectFromCategory(int id) {
		HashMap<Long, Project> answer = new HashMap<Long, Project>();
		HashMap<Long, Project> projectList = this.getProjectList();
		for ( long i=0; i<projectList.size();i++){
			if (projectList.get(i).getcategoryId() == id){
				answer.put(i, projectList.get(i));
			}
		}
		return answer;
	}
	
	
}
