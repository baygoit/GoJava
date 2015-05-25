package com.go_java4.alex_mirn.data_containers;

import java.util.ArrayList;
import java.util.List;

import com.go_java4.alex_mirn.data.Project;

public class ProjectsContainer extends EntityContainer<Project>{
//	public List<Project> data;

	public ProjectsContainer() {
		data = new ArrayList<Project>();
	}
	
//	public Project get(int index) {
//		return (Project)data.get(index);
//	}


//	public int size() {
//		return data.size();
//	}
//
//	public void add(Project project) {
//		data.add(project);
//	}
//
//	public List<Project> getProjects() {
//		return data;
//	}
}
