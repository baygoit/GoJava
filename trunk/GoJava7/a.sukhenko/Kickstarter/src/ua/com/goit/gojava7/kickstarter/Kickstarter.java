package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.Calendar;

import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	
	public Kickstarter() {
		initQuotes();
	}
	private static final boolean LOGS_ENABLED = true;
	private ArrayList<String> logs = new ArrayList<>();
	private ArrayList<Project> projects = new ArrayList<Project>();
	private QuoteStorage quoteStorage = new QuoteStorage();
	private Body body = new Body(this);
	
	public void initQuotes(){
		quoteStorage.addQuote(new Quote("Carry out a random act of kindness, with no expectation of reward, safe in the knowledge that one day someone might do the same for you.", "Princess Diana"));
		quoteStorage.addQuote(new Quote("I actually think that the most efficacious way of making a difference is to lead by example, and doing random acts of kindness is setting a very good example of how to behave in the world.","Misha Collins"));
	}
	
	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		Project project = new Project("GoIT Java 7", "Movie about our GoIT Java 7 Group", Category.Movie, Calendar.getInstance());
		User backerOne = new User();
		project.addBacker(backerOne, Double.valueOf(100501));
		kickstarter.addProject(project);
		kickstarter.getBody().generateMainPage();

		
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
	

	public Project getProjectById(int id){
		return projects.get(id);
	}

	public QuoteStorage getQuoteStorage() {
		return quoteStorage;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}
	
}
