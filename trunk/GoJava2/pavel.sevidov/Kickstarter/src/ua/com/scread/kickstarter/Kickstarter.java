package ua.com.scread.kickstarter;

public class Kickstarter {
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		KickstarterRunner mvc = new KickstarterRunner(new Model(), new ConsoleIO());
	}
}
