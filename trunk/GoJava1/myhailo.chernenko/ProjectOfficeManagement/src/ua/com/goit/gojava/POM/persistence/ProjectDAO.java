package ua.com.goit.gojava.POM.persistence;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.POM.dataModel.*;

public class ProjectDAO implements GenericDAO<Project> {
	
	DataManager dataManager;
	
	public ProjectDAO(DataManager dataManager) {

		this.dataManager = dataManager;
	
	}

	@Override
	public Project create() {

		Project newProject = new Project();
		dataManager.saveObject(newProject, "Project");
		return newProject;

	}

	@Override
	public Project getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Project obj) {

		dataManager.saveObject(obj, "Project");
	
	}

	@Override
	public void delete(Project obj) {

		dataManager.deleteObject(obj, "Project");
			
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getList() {

		ArrayList<Project> result = new ArrayList<Project>();
		Object objectList = dataManager.getObjectList("Project");
		if (objectList instanceof ArrayList<?> ) {
			
			result = (ArrayList<Project>) objectList;
					
		}
		
		return result;
	} 

}
