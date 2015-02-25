package ua.com.sas.model;

import java.util.ArrayList;

public interface Projects {

	void addProject(Project project);

	void chooseProjects(Category category);

	ArrayList<String> writeProjects();

	String writeProject(Project project);

	ArrayList<String> giveAllInfo(Project project);

	String readProject(int index);

	Project readObject(int index);

	int getLenth();

}