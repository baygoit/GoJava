package com.anmertrix;



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
	    	
	    	while(true){
	    		io.println(projectSource.getProjectsMenu(numberCategory));
	    		
	    		int numberProject = 0;
	    		numberProject = getParseInputNumber(io.readConsole());
	    		if (numberProject == -1) {
	    			break;
	    		} else {
	    			io.print("You select: ");
	    			io.println(projectSource.getNameSelectedProject(numberCategory, numberProject));
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
