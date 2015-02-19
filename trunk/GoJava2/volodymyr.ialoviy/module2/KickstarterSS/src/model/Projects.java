package model;

import java.util.ArrayList;

public interface Projects {

	public abstract void writeAllProjects();

	public abstract void updateProject(String[] value, int i);

	public abstract String showProjectFull(int numberProject);

	public abstract String showProjectInShort(int projectID);

	public abstract void setDonation(int chosenProject, int amount);

	public abstract void addFAQ(int projectID, String question);

	public abstract ArrayList<String> getFaq();

	public abstract ArrayList<Project> getListProject();

	public abstract void setListProject(ArrayList<Project> listProject);

	public abstract int getCounterProject();

	public abstract void setCounterProject(int counterProject);

}