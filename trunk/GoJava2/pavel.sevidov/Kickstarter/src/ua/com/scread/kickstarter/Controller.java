package ua.com.scread.kickstarter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Controller {
	private Model model;
    private IO io;

    public Controller(Model model, IO io) {
        this.model = model;
        this.io = io;
    }
    
    public void start() {
        model.init();
        greed();
        
        Categories categories = model.getCategories();
        
        boolean exitApp = false;
        while(!exitApp) {
        	showCategoies(categories);	
        	int numberOfCategory = io.read();
        	if ((numberOfCategory == 0) || (numberOfCategory > categories.getCategories().size()))
        		break;
        	Category category = categories.getCategory(numberOfCategory-1);
        	boolean exitCategories = false;
        	while (!exitCategories) {
        		showCategory(category);
        		ArrayList<Project> projects = model.getProjects(category);
        		showProjects(projects);
        		int answer = io.read();
        		if ((answer == 0) || (answer > projects.size()))
        			break;
        		Project project = projects.get(answer-1);
        		boolean exitProjects = false;
        		while (!exitProjects) {
        			showFullProject(project); 
        			int projectOption = io.read();
        			if (projectOption != 0) {
        				System.out.println("Selected option: ");
        			} else
        				System.out.println("Exiting from project");
        			exitProjects = true;
        		}
        		if (answer == 0) 
        			break;
        	if (numberOfCategory == 0)
        		break;
        	}  
        }
    }
    
    private void println() {
    	io.print("\n");
	}
    
	public void println(String message) {
		io.print(message + "\n");
	}
	
	public void greed() {
		QuoteGenerator quote = new QuoteGenerator(new Random());
		println(quote.getQuote());
	}

	public void showCategoies(Categories categories) {
		println("\nChoose category: ");
		println(Arrays.toString(categories.getStringCategories()));
		showExit();
	}

	public void showCategory(Category category) {
		println("You choosed: " + category.getName());
	}
	
	public void showProjects(ArrayList<Project> projects) {
		
        for (Project project : projects) {
        	showProject(project);  
        	showLine();
        }
        println("\nChoose project: ");
        for (int i = 0; i < projects.size(); i++) {
        	io.print(String.valueOf(i+1) + " - " + projects.get(i).getName() + "; ");
        }
        showExit();
        println();
	}
	
	private void showLine() {
		println("--------------------------------------");
	}

	private void showProject(Project project) {
		println(project.getName());
        println(project.getDescription()); 
        println("Already collected " + project.getCollected() + " UAH for " + project.getDays() + " days"); 
        println("Need collect " + project.getAmount() + " UAH");	
	}

	private void showExit() {
		println("or [0 - back]");
	}
	
	public void showFullProject(Project project) {
		showLine();
		showProject(project);
		Details details = project.getDetails();
		FAQ faq = details.getFAQ();
		println("History: " + details.getHistory());
		println("Video link: " + details.getVideo());
		println("\nFrequently Asked Questions: ");
		println(faq.getQuestion());
		println("\n" + faq.getAnswer());
		showLine();
		showExit();
	}

}
