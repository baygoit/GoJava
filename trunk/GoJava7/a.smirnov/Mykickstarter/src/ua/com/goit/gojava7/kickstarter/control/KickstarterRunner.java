package ua.com.goit.gojava7.kickstarter.control;

public class KickstarterRunner {
	private static final String SEPARATOR = "**********************************************************************";

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println(SEPARATOR);
			System.out.println("Starting program using files storages");
			AbstractKickstarter kickstarter = new KickstarterFilesStorage();
			kickstarter.start();
			kickstarter.stop();

		} else {
			System.out.println(SEPARATOR);
			System.out.println("Starting program using memory storages");
			AbstractKickstarter kickstarter = new KickstarterMemoryStorage();
			kickstarter.start();
			kickstarter.stop();
		}
	}
}
