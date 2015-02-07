package mainkick;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Projects {
	private ArrayList<Project> listProject = new ArrayList<Project>();
	private int counterProject;
	
	public String writeAllProjects() throws FileNotFoundException{
		String s = "";
		ReaderBD reader = new ReaderBD();
		ArrayList<String[]> projectBD = reader.read("Projects.properties");
		int i = 0;
		Project project = new Project();
		for (String[] value : projectBD) {
			getListProject().add(new Project());
			s += project.readProject(getListProject(), value, i);
		    i++;
		}
		setCounterProject(getListProject().size());
		return s;
	}

	public ArrayList<Project> getListProject() {
		return listProject;
	}

	public void setListProject(ArrayList<Project> listProject) {
		this.listProject = listProject;
	}

	public int getCounterProject() {
		return counterProject;
	}

	public void setCounterProject(int counterProject) {
		this.counterProject = counterProject;
	}
	
}
