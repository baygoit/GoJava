import java.util.ArrayList;


public class MyCategory {
	private ArrayList<Project> projectsList = new ArrayList<Project>();
	private String title;
	
	public MyCategory(String title){ this.title=title;}
	
	public String getTitle(){ return title;}

	public void showList() {
		if(projectsList.size()==0){
			System.out.println("Empty!");
		}
		int num = 1;
		for(int i = 0; i<projectsList.size(); i++){
			System.out.println(num + " - " + getProject(i).getTitle());
			System.out.println(getProject(i).getShortDescr());
			System.out.println("Money needed: " + getProject(i).getProjectValue() + 
								"; Money collected: " + getProject(i).getRecievedMoney());
			System.out.println("Days left: " + getProject(i).getDaysLeft());
			num++;
		}
		System.out.println("0 - Go back");
	}
	
	public Project getProject(int i){
		return projectsList.get(i);
	}
	
	public void addProject(Project p) {
		projectsList.add(p);
	}
}
