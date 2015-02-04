package ua.com.scread.kickstarter;

import java.util.Arrays;
import java.util.List;

public class Controller {
	private Model model;
    private IO io;
    private QuoteGenerator quote;

    public Controller(Model model, IO io, QuoteGenerator quote) {
        this.model = model;
        this.io = io;
        this.quote = quote;
    }    
    
    public void start() {
        greed(quote);      
        Categories categories = model.getCategories();
       	handlingCategories(categories);
        io.print("Thanks for using my program!");
    }
    
    private void handlingCategories(Categories categories) {
        while (true) {
            showCategoies(categories);  
            int answer = io.read();
            if (checkCategoriesNumber(categories, answer))
                break;
            Category category = categories.getCategory(answer-1);
            showCategory(category);
            handlingProjects(category);
        }
    }
    
    private void handlingProjects(Category category) {
        while (true) {
            List<Project> projects = model.getProjects(category);
            showProjects(projects);
            int answer = io.read();
            if(checkProjectsNumber(projects, answer))
                break;
            handlingFullProject(projects.get(answer-1));
        }
    }

    private void handlingFullProject(Project project) {
        while (true) {
          showFullProject(project); 
          int projectOption = io.read();
          if (projectOption != 0) {
              println("Selected option: ");
          } else
              println("Exiting from project");
          if (isZero(projectOption))
              break;
      }
        
    }

    private boolean checkCategoriesNumber(Categories categories, int answer) {
        return (isZero(answer) || (answer > categories.size()) || (answer < 0));
    }
    
    private boolean checkProjectsNumber(List<Project> projects, int answer) {
        return (isZero(answer) || (answer > projects.size()) || (answer < 0));
    }

    private boolean isZero(int answer) {
        return answer == 0;
    }
    
    private void println() {
    	io.print("\n");
	}
    
	public void println(String message) {
		io.print(message + "\n");
	}
	
	public void greed(QuoteGenerator quote) {
		println(quote.getQuote());
	}

	public void showCategoies(Categories categories) {
		io.print("\nChoose category: ");
		io.print(Arrays.toString(categories.getStringCategories()));
		showExit();
	}

	public void showCategory(Category category) {
		println("You choosed: " + category.getName());
	}
	
	public void showProjects(List<Project> projects) {
		
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
		println(" or [0 - back]");
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
