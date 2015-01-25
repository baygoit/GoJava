package mainkick;
import java.io.FileNotFoundException;


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
	public static int counterProject;
	
	public void showProject(int selectProjectID) throws FileNotFoundException{
		stringConvertToProject(selectProjectID);

		System.out.println("projectID = " + projectID);
		System.out.println("projectName: " + projectName);
		System.out.println("shortDescription: " + shortDescription);
		System.out.println("fullDescription: " + fullDescription);
		System.out.println("foto: " + foto);
		System.out.println("link: " + link);
		System.out.println("howMuchNeeded = " + howMuchNeeded);
		System.out.println("howMuchCollected = " + howMuchCollected);
		System.out.println("howMuchRemaining = " + howMuchRemaining);
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
		ReaderBD reader = new ReaderBD();
		String[] linesAsArray = reader.read("Projects.properties", "Project");
		String[] string = linesAsArray[projectID-1].split("\\[\\]");
		return string;
	}
	
	public void showAllProject() throws FileNotFoundException{
		stringConvertToProject(1);
		for (int i = 1; i <= counterProject; i++){
			stringConvertToProject(i);
			System.out.println(projectID + ", " + projectName + ", " + shortDescription + ", " + howMuchNeeded + ", " + howMuchRemaining);
		}
	}
	
	public void showAllProjectInCategory(int[] projectsThatContain) throws FileNotFoundException{
		for (int i = 0; i < projectsThatContain.length; i++){
			stringConvertToProject(projectsThatContain[i]);
			System.out.println(projectID + ", " + projectName + ", " + shortDescription + ", " + howMuchNeeded + ", " + howMuchRemaining);
		}
	}
	
	
	public void addProject(){
		//TODO
		//EntriesInTheDB.record()
		counterProject++;
	}
	
	public void deleteProject(){
		//TODO
		//EntriesInTheDB.record()
		counterProject--;
	}
}
