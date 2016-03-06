package com.anmertrix;

/**
 * Hello world!
 *
 */
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
    	
    	io.println(quoteSourse.getRandomQuote());
    	
    	while(true){
	    	io.println(categorySource.getCategoriesMenu());
	    	
	    	String text = io.readConsole();
	    	if (text.equals("0")) {
	    		return;
	    	}
	    	int numberCategory = 0;
	    	try {
	    		
	    		numberCategory = (Integer.parseInt(text));
	    		io.print("You select: ");
	    		
			} catch (NumberFormatException e) {
				io.println("You can enter only numbers. \"" + text + "\" is not a number.\n ");
			}
    	}
    }
}
