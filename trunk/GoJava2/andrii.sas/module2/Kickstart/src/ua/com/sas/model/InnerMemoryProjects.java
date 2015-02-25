package ua.com.sas.model;

import java.util.ArrayList;
import java.util.List;

public class InnerMemoryProjects implements Projects {
	private List<Project> projects = new ArrayList<>();
	private List<Project> categoryProjects = new ArrayList<>();
	private List<String> projectData = new ArrayList<>();
	private List<String> projectAllInfo = new ArrayList<>();
	
	/* (non-Javadoc)
	 * @see myRealization.Projectsq#addProject(myRealization.Project)
	 */
	@Override
	public void addProject(Project project) {
		projects.add(project);
	}
	
	/* (non-Javadoc)
	 * @see myRealization.Projectsq#chooseProjects(myRealization.Category)
	 */
	@Override
	public void chooseProjects(Category category) {
		categoryProjects.clear();
		for (Project project : projects) {
			if (project.getCategory().equals(category) ) {
				categoryProjects.add(project);
			}
		}
	} 
	
	/* (non-Javadoc)
	 * @see myRealization.Projectsq#writeProjects()
	 */
	@Override
	public ArrayList<String> writeProjects(){
		projectData.clear();
		for (Project project : categoryProjects){
			projectData.add(writeProject(project));
		}
		return (ArrayList<String>) projectData;
	}
	
	/* (non-Javadoc)
	 * @see myRealization.Projectsq#writeProject(myRealization.Project)
	 */
	@Override
	public String writeProject(Project project) {
		return " Name - " + project.getProjectName() + ", Description - "
				+ project.getDescription() + ", Money we need - "
				+ project.getMoneyNeed() + ", Money we have - "
				+ project.getMoneyHas() + ", Days left - "
				+ project.getDaysLeft();
	}
	
	/* (non-Javadoc)
	 * @see myRealization.Projectsq#giveAllInfo(myRealization.Project)
	 */
	@Override
	public ArrayList<String> giveAllInfo(Project project){
		projectAllInfo.clear();
		projectAllInfo.add(project.getHistory());
		projectAllInfo.add(project.getVideoLink());
		projectAllInfo.add(project.getQuestion());	
		
		return (ArrayList<String>) projectAllInfo;
 	}
	
	/* (non-Javadoc)
	 * @see myRealization.Projectsq#readProject(int)
	 */
	@Override
	public String readProject(int index){
		return projectData.get(index);
	}
	
	/* (non-Javadoc)
	 * @see myRealization.Projectsq#readObject(int)
	 */
	@Override
	public Project readObject(int index){
		return categoryProjects.get(index);
	}
	
	/* (non-Javadoc)
	 * @see myRealization.Projectsq#getLenth()
	 */
	@Override
	public int getLenth(){
		return categoryProjects.size();
	}
}
