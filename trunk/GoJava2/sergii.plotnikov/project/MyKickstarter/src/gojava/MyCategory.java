package gojava;
import java.util.ArrayList;


public class MyCategory {
	private ArrayList<Project> projectsList = new ArrayList<Project>();
	private String title;
	
	public MyCategory(String title){ this.title=title;}
	
	public String getTitle(){ return title;}

	public String showList() {
		if(projectsList.size()==0){
			return "Empty!\n0 - Go back";
		}
		
		String result ="";
		int num = 1;
		for(int i = 0; i<projectsList.size(); i++){
			result+=num + " - " + getProject(i).shortProjectDescr();
			num++;
		}
		result+="0 - Go back\n";
		
		return result;
	}
	
	public Project getProject(int i){
		return projectsList.get(i);
	}
	
	public int getLength(){
		return projectsList.size();
	}
	
	public void addProject(Project p) {
		projectsList.add(p);
	}
}
