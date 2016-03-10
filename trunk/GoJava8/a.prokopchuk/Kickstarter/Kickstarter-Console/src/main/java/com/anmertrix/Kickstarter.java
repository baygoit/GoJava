package com.anmertrix;

import java.util.List;



public class Kickstarter {
	
	private IO io;
	public Kickstarter(IO io) {
		this.io = io;
	}
	
    public static void main( String[] args ) {
    	Kickstarter run = new Kickstarter(new ConsoleIO());
    	run.start();
        
    }
    
    private void start() {
    	QuoteSource quoteSourse = new QuoteSource();
    	CategorySource categorySource = new CategorySource();
    	ProjectSource projectSource = new ProjectSource(categorySource);
    	
    	io.println(quoteSourse.getRandomQuote());
    	
    	while(true){
	    	io.println(categorySource.getCategoriesMenu());
	    	
	    	int numberCategory = 0;
	    	numberCategory = getParseInputNumber(io.readConsole());
	    	if (numberCategory == -1) {
	    		break;
    		} else {
    			try {
    				io.print("You select: ");
    				io.println(categorySource.getNameSelectedCategory(numberCategory));
				} catch (Exception e) {
					System.out.println("There is no such category!");
					continue;
				}
    		}
	    	
	    	while( true ) {
	    		io.println(projectSource.getProjectList(numberCategory));
	    		
	    		int numberProject = 0;
	    		numberProject = getParseInputNumber(io.readConsole());
	    		if (numberProject == -1) {
	    			break;
	    		} else {
	    			io.print("You select: ");
	    			io.println(projectSource.getInfoSelectedProject(numberCategory, numberProject));
	    			io.println("______________________________");
	    			io.print(projectSource.getProjectMenu());
	    			int numberMenuItem = 0;
	    			numberMenuItem = getParseInputNumber(io.readConsole());
	    			
	    			Category category = categorySource.getCategory(numberCategory);
	    			List<Project> projects = category.getProjects();
	    			Project project = projects.get(numberProject);
		    		if (numberMenuItem == -1) {
		    			break;
		    		} else if (numberMenuItem == 0) {
		    			io.print("Enter your guestion: ");
		    			String guestion = io.readConsole();
		    			project.setQuestion(guestion);
		    			continue;
		    			
		    		} else if (numberMenuItem == 1) {
		    			io.println("Select one or enter 0 - to exit:  ");
		    			io.println("1 - 1$     2 - 10$     3 - 40$ ");
		    			int numberCount = 0;
		    			numberCount = getParseInputNumber(io.readConsole());
		    			if (numberCount == -1) {
			    			break;
			    		} else if (numberCount == 0 ) {
			    			project.setGatheredBudget(1);
			    		} else if (numberCount == 1 ) {
			    			project.setGatheredBudget(10);
			    		} else if (numberCount == 2 ) {
			    			project.setGatheredBudget(40);
			    		}
		    			continue;
		    			
		    		} else if (numberMenuItem == 2) {
		    			continue;
		    		}
	    			
	    			
	    		}
	    		
	    		io.println("Enter 0 to see all projects.");
				int number = getParseInputNumber(io.readConsole());
				if (number == 0) {
					continue;
				}
	    	}
    	}
    }
    
    public int getParseInputNumber(String text) {
    	int result = 0;
    	
    	try {
    		result = (Integer.parseInt(text));
		} catch (NumberFormatException e) {
			io.println("You can enter only numbers. \"" + text + "\" is not a number.\n ");
		}
    	
    	return result - 1;
    }
}
