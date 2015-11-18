package ua.com.goit.gojava7.kickstarter.domain;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.storage.Storage;

public class Category extends Storage<Project> {

	private String name;
	//private List<String> pathFiles = new ArrayList<String>();
	
	public Category() {		
	}
	
	public Category(String name) {
		this.name = name;
	}

	//public List<String> getPathFiles() {
	//	return pathFiles;
	//}

	//public void setPathFile(List<String> pathFiles) {
	//	this.pathFiles = pathFiles;
	//}
	
	//public void addPathFile(String pathFile) {
	//	this.pathFiles.add(pathFile);
	//}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}