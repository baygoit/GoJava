package ua.nenya.main;


import ua.nenya.util.ConsoleIOImpl;
import ua.nenya.util.IO;

public class KickstarterMain {

	private static final String ENTERING_MODE_ENV_NAME = "ENTERING_MODE";

	public static void main(String[] args) {
		IO io = new ConsoleIOImpl();
		String switcher = System.getenv(ENTERING_MODE_ENV_NAME);
		System.err.println(ENTERING_MODE_ENV_NAME + ": " + switcher);
		KickstarterInitilizer initilizer = new KickstarterInitilizer();
		initilizer.initKickstarter(switcher);
		new Kickstarter(initilizer, io).run();
	}

}
