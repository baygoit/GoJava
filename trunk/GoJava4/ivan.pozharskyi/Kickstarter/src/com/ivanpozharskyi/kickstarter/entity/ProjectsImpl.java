package com.ivanpozharskyi.kickstarter.entity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ivanpozharskyi.kickstarter.main.Kickstarter;

public class ProjectsImpl implements Projects{
	private Kickstarter kickstarter;
	private ReaderFromFile readerFromFile;
	private List<Project> projects = new ArrayList<Project>();
	private CategoriesImpl categories;
	
	public ProjectsImpl(Kickstarter kickstarter) {
		this.kickstarter = kickstarter;
	}
	public ProjectsImpl() {
	
	}
	@Override
	public int getSize(){
		return projects.size();
	}
	public void addProjectsFromFile(String fileName) throws IOException, SQLException{
		readerFromFile = new ReaderFromFile(fileName);
		List<String> projectsNames = readerFromFile.read();
		for(String projectsFullName: projectsNames){
			String[] nameParameter = projectsFullName.split(",");


			int categoryId = Integer.parseInt(nameParameter[4]);
			Category category = kickstarter.getCategoies().getCategory(categoryId);
			Project project = new Project(nameParameter[0],Integer.parseInt(nameParameter[1]),
					Integer.parseInt(nameParameter[2]),Integer.parseInt(nameParameter[3]),category
					);
			projects.add(project);
		}
	}
	@Override
	public void addProject(String name, int moneyGot, int moneyNeed
			, int daysLeft, int categoryId) {
		Project project = new Project(name, moneyGot, moneyNeed
				, daysLeft, categories.getCategory(categoryId) );
		projects.add(project);
	}
	@Override
	public List<Project> getProjectsInCategory(Category category) {
		List<Project> projects = new ArrayList<Project>();
		
		for(Project project: projects){
			if(project.getCaegory().equals(category)){
				projects.add(project);
			}
		}
			

		return projects;
	}
	public void addQuestionAndAnswersInProject(Project project,QuestionStorage questionStorage){
		for(Project currentProject: projects){
			if(currentProject.equals(project)){
				currentProject.addQuestionAndAnswers(questionStorage);
			}
		}
	}
	@Override
	public Project getProject(int id) {
		 	return projects.get(id);
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
