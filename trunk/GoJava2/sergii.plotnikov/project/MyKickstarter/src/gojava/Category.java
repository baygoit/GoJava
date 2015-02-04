package gojava;
import java.util.ArrayList;


public class Category {
	private ArrayList<Project> projectsList = new ArrayList<Project>();
	private String title;
	
	public Category(String title){ this.title=title;}
	
	public String getTitle(){ return title;}

	public String showProjects() {
		if(projectsList.size()==0){
			return "Empty!\n0 - Go back";
		}
		
		String result ="You have chosen Category "+
							getTitle()+"\nChoose a project:\n";
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
