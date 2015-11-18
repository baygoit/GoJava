package ua.com.goit.gojava7.kickstarter.control;

public class KickstarterRunner {

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("Starting program using files storages");
//			KickstarterForFiles kickstarterForFiles = new KickstarterForFiles();
//			kickstarterForFiles.start();
//			kickstarterForFiles.stop();

		} else {
			System.out.println("Starting program using memory storages");
			KickstarterForMemory kickstarterForMemory = new KickstarterForMemory();
			kickstarterForMemory.start();
			kickstarterForMemory.stop();
		}
	}
}
