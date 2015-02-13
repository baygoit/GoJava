package mainkick;

import java.util.ArrayList;

public class Projects {
	private ArrayList<Project> listProject = new ArrayList<Project>();
	private int counterProject;
	
	Project project = new Project();
	ReaderBD reader = new ReaderBD();
	ArrayList<String[]> projectBD;
	
	
	public String writeAllProjects(){
		String s = "";
		int i = 0;
		projectBD = reader.read("Projects.properties");
		for (String[] value : projectBD) {
			getListProject().add(project);
			s += project.readProject(getListProject(), value, i);
		    i++;
		}
		setCounterProject(getListProject().size());
		return s;
	}

	public String showProjectFull(int numberProject){
		String s = "projectID = " + projectBD.get(numberProject)[0]
					+ "\n projectName: " + projectBD.get(numberProject)[1]
					+ "\n shortDescription: " + projectBD.get(numberProject)[2]
					+ "\n fullDescription: " + projectBD.get(numberProject)[3]
					+ "\n foto: " + projectBD.get(numberProject)[4]
					+ "\n link: " + projectBD.get(numberProject)[5]
					+ "\n howMuchNeeded = " + projectBD.get(numberProject)[6]
					+ "\n howMuchCollected = " + projectBD.get(numberProject)[7]
					+ "\n howMuchRemaining = " + projectBD.get(numberProject)[8];
		return s;
	}
	
	public String showProjectInShort(int i){
		i -= 1;
		String s = projectBD.get(i)[0]
				+ ", " + projectBD.get(i)[1]
				+ ", " + projectBD.get(i)[2]
				+ ", " + projectBD.get(i)[6]
				+ ", " + projectBD.get(i)[7];
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
