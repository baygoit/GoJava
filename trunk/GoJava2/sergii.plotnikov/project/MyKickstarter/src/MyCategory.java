import java.util.ArrayList;


public class MyCategory {
	private ArrayList<Project> projectsList = new ArrayList<Project>();
	private String title;
	
	public MyCategory(String title){ this.title=title;}
	
	public String getTitle(){ return title;}

	public void showList() {
		int num = 1;
		for(int i = 0; i<projectsList.size(); i++){
			System.out.println(num + " - " + getProject(i).getTitle());
			num++;
		}
	}
	
	public Project getProject(int i){
		return projectsList.get(i);
	}
	
	public void addProject(Project p) {
		projectsList.add(p);
	}
}
