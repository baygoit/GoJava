package project;

import java.util.ArrayList;
import java.util.List;


public class BaseOfProjects {
	public List<Project> projects = new ArrayList<>();
	
	
	public List<Project> selectCategory(String type){
		List<Project> categoryProjects = new ArrayList<>();
		for(Project project:projects){
			if(type.equals(project.getCategory())){
				categoryProjects.add(project);
			}
		}
		return categoryProjects;
	}
	public List<String> findProfile(int id){
		List<String> result = new ArrayList<>();
		for(Project p:projects){
			if(id==p.getId()){
				result = p.openProfile(id);
			}
		}
		return result;
	}
	void show(){ //delete all of them
		for(Project p:projects){
			System.out.println(p.showShortInformation());
		}
	}
	void showComments(){
		for(Project p:projects){
			System.out.println(p.getComments());
		}
	}
	
}
