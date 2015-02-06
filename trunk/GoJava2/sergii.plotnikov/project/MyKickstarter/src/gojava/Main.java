package gojava;

public class Main {
	
	public static void main(String[] args) {
		Categories categories = new Categories();
		ConsoleIO io = new ConsoleIO();
		InputCheck check = new InputCheck(io);
		categories.fillCategories();
		
		Kickstarter kickstarter = new Kickstarter(categories, io, check);
		
		kickstarter.run();
	}

}
