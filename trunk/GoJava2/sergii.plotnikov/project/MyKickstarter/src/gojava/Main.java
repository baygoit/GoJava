package gojava;

public class Main {
	
	public static void main(String[] args) {
		Categories categories = new Categories();
		ConsoleIO io = new ConsoleIO();
		categories.fillCategories();
		
		Kickstarter kickstarter = new Kickstarter(categories, io, new Menu());
		
		kickstarter.run();
	}

}
