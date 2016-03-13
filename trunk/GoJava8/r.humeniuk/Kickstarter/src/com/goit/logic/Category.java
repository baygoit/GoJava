package com.goit.logic;

import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<String> listProjects = new ArrayList<String>();

	public void addProject(String projectName) {
		listProjects.add(projectName);
	}

	public ArrayList<String> getListProjects() {
		return listProjects;
	}

	public void setName(String name) {
		String[] s = name.split("\\.");
		this.name = s[0];
	}

	public String getName() {
		return name;
	}
	
	public String getProject(int index){
		return listProjects.get(index);
	}

}
