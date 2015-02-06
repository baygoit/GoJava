package mainkick;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Projects {
	static ArrayList<Project> listProject = new ArrayList<Project>();
	
	public String writeAllProjects() throws FileNotFoundException{
		String s = "";
		ReaderBD reader = new ReaderBD();
		ArrayList<String[]> projectBD = reader.read("Projects.properties");
		int i = 0;
		Project project = new Project();
		for (String[] value : projectBD) {
			listProject.add(new Project());
			
			s += project.readProject(listProject, value, i);
			
		    i++;
		}
		return s;
	}
	
}
