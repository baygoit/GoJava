package com.ivanpozharskyi.kickstarter.datastorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ivanpozharskyi.kickstarter.main.Kickstarter;

public class ProjectStorage {
	private Kickstarter kickstarter;
	private ReaderFromFile readerFromFile;
	private List<Project> projects = new ArrayList<Project>();
	private CategoryStorage categoryStorage;
	
	public ProjectStorage(Kickstarter kickstarter) {
		this.kickstarter = kickstarter;
	}
	public ProjectStorage() {
	
	}
	public void addProjectsFromFile(String fileName) throws IOException{
		readerFromFile = new ReaderFromFile(fileName);
		List<String> projectsNames = readerFromFile.read();
		for(String projectsFullName: projectsNames){
			String[] nameParameter = projectsFullName.split(",");
			Category category = kickstarter.getCategoryStorage().getCategory(Integer.parseInt(nameParameter[4]));
			Project project = new Project(nameParameter[0],Integer.parseInt(nameParameter[1]),
					Integer.parseInt(nameParameter[2]),Integer.parseInt(nameParameter[3]),category
					);
			projects.add(project);
		}
	}
	public void addProject(Project project) {
		projects.add(project);
	}

	public ProjectStorage getProjectsInCategory(Category category) {
		ProjectStorage result = new ProjectStorage();
		for(Project project: projects){
			if(project.getCaegory().equals(category)){
				result.addProject(project);
			}
		}
			

		return result;
	}
	public void addQuestionAndAnswersInProject(Project project,QuestionStorage questionStorage){
		for(Project currentProject: projects){
			if(currentProject.equals(project)){
				currentProject.addQuestionAndAnswers(questionStorage);
			}
		}
	}

	public Project getProject(int id) {
		 	return projects.get(id-1);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Project project: projects){
			result.append(project+"\n");
		}

		return result.toString();
	}

}
