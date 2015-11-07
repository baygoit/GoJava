package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;

public class Kickstarter {
	private static final boolean LOGS_ENABLED = true;
	
	private ArrayList<String> logs = new ArrayList<>();
	private ArrayList<Project> projects = new ArrayList<Project>();
	public static void main(String[] args) {
		Project goit = new Project("GoIT Java 7", "Movie about our GoIT Java 7 Group", Category.Movie, 1446847200);
		User user1 = new User();
		User userFirst = new User();
		userFirst.setSettings(new UserSettings(Category.Movie));
		
		
		goit.addBacker(user1, Double.valueOf(100501));
		Kickstarter.getInstance().addProject(goit);
		
		
		
		
		
		Body.getInstance().generateAll();
		
	}
	
	public boolean loginUser(User u){
		
		return false;
		
	}
	
	public void addProject(Project pr){
		projects.add(pr);
		
		addLog("Project " + pr.getProjectName() + " added.");
	}
	protected void addLog(String s){
		if(LOGS_ENABLED)
		logs.add(s);
	}
	
	private static Kickstarter instance;

	private Kickstarter() {
	}

	public static Kickstarter getInstance() {
		if (null == instance) {
			instance = new Kickstarter();
		}
		return instance;
	}
	public Project getProjectById(int id){
		return projects.get(id);
	}
	
}
