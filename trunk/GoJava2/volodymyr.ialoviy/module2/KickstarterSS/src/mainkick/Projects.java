package mainkick;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


public class Projects {
	public static Map<Integer, String[]> projectBD;
	{
	    try {
	    	ReaderBD reader = new ReaderBD();
	    	projectBD = reader.read("Projects.properties");
	    }
	    catch (IOException e) {
	       throw new RuntimeException(e);
	    }
	}
	public static ArrayList<Project> listProject = new ArrayList<Project>();
	
	public void writeAllCatecories() throws FileNotFoundException{
		int i = 0;
		for (String[] value : projectBD.values()) {
			listProject.add(new Project());
			listProject.get(i).projectID = Integer.valueOf(value[0]);
			listProject.get(i).projectName = value[1];
			listProject.get(i).shortDescription = value[2];
			listProject.get(i).fullDescription = value[3];
			listProject.get(i).foto = value[4];
			listProject.get(i).link = value[5];
			listProject.get(i).howMuchNeeded = Integer.valueOf(value[6]);
			listProject.get(i).howMuchCollected = Integer.valueOf(value[7]);
			listProject.get(i).howMuchRemaining = Integer.valueOf(value[8]);
		    i++;
		}
	}
}
