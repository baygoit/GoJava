package goit.nz.kickstarter;

public class Bootstrap {
	private static Kickstarter app;
	
	public static void main(String[] args) {
		app = new Kickstarter();
		app.run();
	}
}
