package com.goit.kickstarter.service;

import java.sql.Connection;
import java.util.List;

import com.goit.kickstarter.dao.CategoryDAO;
import com.goit.kickstarter.dao.ProjectDAO;
import com.goit.kickstarter.model.Category;
import com.goit.kickstarter.model.Project;
import com.goit.kickstarter.view.ConsoleIO;

public class ProjectService {
	private Connection connection;
	private ProjectDAO projDao = new ProjectDAO();
	private CategoryDAO catDao = new CategoryDAO(connection);
	private ConsoleIO io = new ConsoleIO();
	
	public ProjectService(Connection c){
		connection=c;
	}
	
	public void showProject(String project){
		Project p = projDao.getProject(project);
		io.out(project(p));
	}
	
	public void showCategories(){
		io.out(categories());
	}

	public void showProjects(int id) {
		io.out(projects(id));
	}
	
	public String project(Project p){
		String result="";
		result +=p.getTitle()+"\n"
		+p.getDescription()+"\n"
		+"Price: "+p.getProjectPrice();
		return result;
	}
	
	public String categories(){
		String result="";
		for(int i = 1; i<=catDao .getLength(); i++){
			Category c = catDao.getCategory(i);
			result+=i+ " - " +c.getTitle() + "\n";
		}
		result+="0 - Go back\n";
		return result;
	}

	public String projects(int id) {
		String result="";
		int size = projDao.getLength(id);
		int num =1;
		List<Project> list = projDao.getProjects(new Category(id));
		for(int i = 0; i<size; i++){
			result+=num+ " - " +project(list.get(i)) + "\n";
			num++;
		}
		result+="0 - Go back\n";
		return result;
	}
}
