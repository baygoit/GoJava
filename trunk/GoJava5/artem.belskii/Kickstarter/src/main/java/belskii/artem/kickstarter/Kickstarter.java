package belskii.artem.kickstarter;

public class Kickstarter {
	
	public static void main(String[] args) {
		run();
	}

	private static void run() {
		DispatcherController dispatcher = new DispatcherController();
		dispatcher.start();
	}
	

}
