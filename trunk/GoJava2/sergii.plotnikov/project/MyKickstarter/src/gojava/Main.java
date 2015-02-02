package gojava;

public class Main {
	
	public static void main(String[] args) {
		Categories categories = new Categories();
		Output output = new Output();
		Input input = new Input();
		
		Kickstarter kickstarter = new Kickstarter(categories, output, input);
		kickstarter.run();
	}

}
