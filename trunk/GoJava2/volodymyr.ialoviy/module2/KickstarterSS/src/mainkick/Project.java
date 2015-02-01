package mainkick;
import java.io.FileNotFoundException;

public class Project{
	public int projectID;
	public String projectName;
	public String shortDescription;
	public String fullDescription;
	public String foto;
	public String link;
	public int howMuchNeeded;
	public int howMuchCollected;
	public int howMuchRemaining;
	public int counterProject;
	Output out = new OutputConsole();
	
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
