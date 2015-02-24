package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.ArrayList;

public interface Projects {

	void writeAllProjects();

	void updateProject(String[] value, int i);

	String showProjectFull(int numberProject);

	String showProjectInShort(int projectID);

	void setDonation(int chosenProject, int amount);

	void addFAQ(int projectID, String question);

	ArrayList<String> getFaq(int projectID);

	ArrayList<Project> getListProject();

	void setListProject(ArrayList<Project> listProject);

	int getCounterProject();

	void setCounterProject(int counterProject);

}