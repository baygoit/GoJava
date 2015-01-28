package ua.com.goit.gojava.POM.persistence;

import java.util.List;

import ua.com.goit.gojava.POM.dataModel.*;

public class ProjectDAO implements GenericDAO<Project> {
	
	private static final String CLASS_NAME = "Project";
	DataManager dataManager;
	
	public ProjectDAO(DataManager dataManager) {

		this.dataManager = dataManager;
	
	}

	@Override
	public Project create() {

		Project newProject = new Project();
		dataManager.saveObject(newProject, CLASS_NAME);
		return newProject;

	}

	@Override
	public Project getByName(String name) {

		Project findedProject = null;
		List<Project> list = getList();
		for(Project project : list) {
			if(project.getName().equals(name)){
				findedProject = project;
			}
		}

		return findedProject;
	}

	@Override
	public void update(Project obj) {

		dataManager.saveObject(obj, CLASS_NAME);
	
	}

	@Override
	public void delete(Project obj) {

		dataManager.deleteObject(obj, CLASS_NAME);
			
	}

	@Override
	public List<Project> getList() {

		List<DataObject> objectList = dataManager.getObjectList(CLASS_NAME);
		@SuppressWarnings("unchecked")
		List<Project> result =  (List<Project>)(List<?>) objectList;
		
		return result;
	} 

}
