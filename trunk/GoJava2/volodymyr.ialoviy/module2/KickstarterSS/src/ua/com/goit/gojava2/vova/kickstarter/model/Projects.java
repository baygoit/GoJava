package ua.com.goit.gojava2.vova.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public interface Projects {

	List<Project> getProjects();
	
	String showProjectInShort(int projectID);

	void setDonation(int chosenProject, int amount);

	void addFAQ(int projectID, String question);

	ArrayList<String> getFaq(int projectID);

	void setProjects();

}