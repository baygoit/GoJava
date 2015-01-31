package mainkick;
import java.io.FileNotFoundException;
import java.util.Map;


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
	private int counterProject;
	
	public void showProject(int selectProjectID) throws FileNotFoundException{
		stringConvertToProject(selectProjectID);
		Output out = new OutputConsole();
		out.print("projectID = " + projectID);
		out.print("projectName: " + projectName);
		out.print("shortDescription: " + shortDescription);
		out.print("fullDescription: " + fullDescription);
		out.print("foto: " + foto);
		out.print("link: " + link);
		out.print("howMuchNeeded = " + howMuchNeeded);
		out.print("howMuchCollected = " + howMuchCollected);
		out.print("howMuchRemaining = " + howMuchRemaining);
	}
	
	private void stringConvertToProject(int selectProjectID) throws FileNotFoundException{
		String[] projectInString = recordingProjectsFromBD(selectProjectID);

		projectID = Integer.valueOf(projectInString[0]);
		projectName = projectInString[1];
		shortDescription = projectInString[2];
		fullDescription = projectInString[3];
		foto = projectInString[4];
		link = projectInString[5];
		howMuchNeeded = Integer.valueOf(projectInString[6]);
		howMuchCollected = Integer.valueOf(projectInString[7]);
		howMuchRemaining = Integer.valueOf(projectInString[8]);
	}
	
	private String[] recordingProjectsFromBD(int projectID) throws FileNotFoundException{
		Map<Integer, String> linesAsArray = BD.projectBD;
		String[] string = linesAsArray.get(projectID-1).split("\\[\\]");
		counterProject = linesAsArray.size();
		return string;
	}
	
	public void showAllProject() throws FileNotFoundException{
		stringConvertToProject(1);
		for (int i = 1; i <= counterProject; i++){
			stringConvertToProject(i);
			Output out = new OutputConsole();
			out.print(projectID + ", " + projectName + ", " + shortDescription + ", " + howMuchNeeded + ", " + howMuchRemaining);
		}
	}
	
	public void showAllProjectInCategory(int[] projectsThatContain) throws FileNotFoundException{
		for (int i = 0; i < projectsThatContain.length; i++){
			stringConvertToProject(projectsThatContain[i]);
			Output out = new OutputConsole();
			out.print(projectID + ", " + projectName + ", " + shortDescription + ", " + howMuchNeeded + ", " + howMuchRemaining);
		}
	}
	
	
	public void addProject(){
		//TODO
		//EntriesInTheDB.record()
		//counterProject++;
	}
	
	public void deleteProject(){
		//TODO
		//EntriesInTheDB.record()
		//counterProject--;
	}
}
