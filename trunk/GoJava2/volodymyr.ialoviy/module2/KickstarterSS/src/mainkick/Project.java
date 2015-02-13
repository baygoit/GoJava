package mainkick;

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
	private ArrayList<String> faq = new ArrayList<String>();

	public void setFAQ(){
		InputsConsole question = new InputsConsole();
		faq.add(question.enter());
	}
	
	public String readProject(ArrayList<Project> listProject, String[] value, int i){
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
	
//	public String showProjectInShort(int i, Projects projects){
//		i -= 1;
//		String s = projects.getListProject().get(i).projectID
//				+ ", " + projects.getListProject().get(i).projectName
//				+ ", " + projects.getListProject().get(i).shortDescription
//				+ ", " + projects.getListProject().get(i).howMuchNeeded
//				+ ", " + projects.getListProject().get(i).howMuchCollected;
//		return s;		
//	}
//	
//	public String showProjectFull(int i, ArrayList<Project> listProject){
//		String s = "projectID = " + listProject.get(i).projectID
//					+ "\n projectName: " + listProject.get(i).projectName
//					+ "\n shortDescription: " + listProject.get(i).shortDescription
//					+ "\n fullDescription: " + listProject.get(i).fullDescription
//					+ "\n foto: " + listProject.get(i).foto
//					+ "\n link: " + listProject.get(i).link
//					+ "\n howMuchNeeded = " + listProject.get(i).howMuchNeeded
//					+ "\n howMuchCollected = " + listProject.get(i).howMuchCollected
//					+ "\n howMuchRemaining = " + listProject.get(i).howMuchRemaining;
//		return s;
//	}
	
	public void setDonation(ArrayList<Project> listProject, int amount, int chosenProject){//TODO убрать листПроджект
		listProject.get(chosenProject).howMuchCollected += amount;
		listProject.get(chosenProject).howMuchRemaining -= amount;
	}

	public ArrayList<String> getFaq() {
		return faq;
	}

	public void setFaq(ArrayList<String> faq) {
		this.faq = faq;
	}
	
}
