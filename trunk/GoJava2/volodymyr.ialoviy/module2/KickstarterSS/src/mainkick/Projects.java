package mainkick;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Projects {
	private ArrayList<Project> listProject = new ArrayList<Project>();
	
	public void writeAllCatecories() throws FileNotFoundException{
		ReaderBD reader = new ReaderBD();
		ArrayList<String[]> projectBD = reader.read("Projects.properties");
		int i = 0;
		for (String[] value : projectBD) {
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
	
	public String showProjectInShort(int i) throws FileNotFoundException{
		i -= 1;
		String s = listProject.get(i).projectID
				+ ", " + listProject.get(i).projectName
				+ ", " + listProject.get(i).shortDescription
				+ ", " + listProject.get(i).howMuchNeeded
				+ ", " + listProject.get(i).howMuchRemaining;
		return s;		
	}
	
	public String showProjectFull(int i) throws FileNotFoundException{
		String s = "projectID = " + listProject.get(i).projectID
					+ "\n projectName: " + listProject.get(i).projectName
					+ "\n shortDescription: " + listProject.get(i).shortDescription
					+ "\n fullDescription: " + listProject.get(i).fullDescription
					+ "\n foto: " + listProject.get(i).foto
					+ "\n link: " + listProject.get(i).link
					+ "\n howMuchNeeded = " + listProject.get(i).howMuchNeeded
					+ "\n howMuchCollected = " + listProject.get(i).howMuchCollected
					+ "\n howMuchRemaining = " + listProject.get(i).howMuchRemaining;
		return s;
	}
}
