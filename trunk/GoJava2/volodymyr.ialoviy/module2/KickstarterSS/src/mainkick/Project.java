package mainkick;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Project{
	private int projectID;
	private String projectName;
	private String shortDescription;
	private String fullDescription;
	private String foto;
	private String link;
	private int howMuchNeeded;
	private int howMuchCollected;
	private int howMuchRemaining;
	
	public String readProject(ArrayList<Project> listProject, String[] value, int i) throws FileNotFoundException{
		listProject.get(i).projectID = Integer.valueOf(value[0]);
		listProject.get(i).projectName = value[1];
		listProject.get(i).shortDescription = value[2];
		listProject.get(i).fullDescription = value[3];
		listProject.get(i).foto = value[4];
		listProject.get(i).link = value[5];
		listProject.get(i).howMuchNeeded = Integer.valueOf(value[6]);
		listProject.get(i).howMuchCollected = Integer.valueOf(value[7]);
		listProject.get(i).howMuchRemaining = Integer.valueOf(value[8]);

		return projectID + " " + projectName +  " " + shortDescription + " " + fullDescription + " " + foto + " " + link + " " + howMuchNeeded + " " +  howMuchCollected + " " + howMuchRemaining + "\n";
	}
	
	public String showProjectInShort(int i) throws FileNotFoundException{
		i -= 1;
		String s = Projects.listProject.get(i).projectID
				+ ", " + Projects.listProject.get(i).projectName
				+ ", " + Projects.listProject.get(i).shortDescription
				+ ", " + Projects.listProject.get(i).howMuchNeeded
				+ ", " + Projects.listProject.get(i).howMuchRemaining;
		return s;		
	}
	
	public String showProjectFull(int i) throws FileNotFoundException{
		String s = "projectID = " + Projects.listProject.get(i).projectID
					+ "\n projectName: " + Projects.listProject.get(i).projectName
					+ "\n shortDescription: " + Projects.listProject.get(i).shortDescription
					+ "\n fullDescription: " + Projects.listProject.get(i).fullDescription
					+ "\n foto: " + Projects.listProject.get(i).foto
					+ "\n link: " + Projects.listProject.get(i).link
					+ "\n howMuchNeeded = " + Projects.listProject.get(i).howMuchNeeded
					+ "\n howMuchCollected = " + Projects.listProject.get(i).howMuchCollected
					+ "\n howMuchRemaining = " + Projects.listProject.get(i).howMuchRemaining;
		return s;
	}
	
}
