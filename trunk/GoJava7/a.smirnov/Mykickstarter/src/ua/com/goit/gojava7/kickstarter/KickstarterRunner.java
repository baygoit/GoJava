package ua.com.goit.gojava7.kickstarter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ua.com.goit.gojava7.kickstarter.controller.AbstractKickstarter;
import ua.com.goit.gojava7.kickstarter.controller.KickstarterDatabase;
import ua.com.goit.gojava7.kickstarter.controller.KickstarterFile;
import ua.com.goit.gojava7.kickstarter.controller.KickstarterMemory;

public class KickstarterRunner {	
	
	public static void main(String[] args) {
		new KickstarterRunner().selectProgramMode();
	}
	
	private void selectProgramMode() {
		int userChoiseMode = 0;
	
		String startMenu = "Please select program mode (by default memory) : \n"
							+ "1 : memory \n"
							+ "2 : files \n"
							+ "3 : database";
		System.out.println(startMenu);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			try {
				userChoiseMode = Integer.parseInt(in.readLine());
			} catch (NumberFormatException e1) {
				System.out.println("You entered forbidden symbol. Please try again : ");
			} catch (IOException e2) {
				System.out.println("Problems with the stream...");
			}
			
		} while (userChoiseMode == 0);
		
		switch (userChoiseMode) {
			case 1 : {
				System.out.println("Program using memory storage");
				AbstractKickstarter kickstarter = new KickstarterMemory();
				kickstarter.start();
				break;
			}
			case 2 : {
				System.out.println("Program using files storage");
				AbstractKickstarter kickstarter = new KickstarterFile();
				kickstarter.start();
				break;
			}
			case 3 : {
				System.out.println("Program using database storage");
				AbstractKickstarter kickstarter = new KickstarterDatabase();
				kickstarter.start();
				break;
			}
			default:
				System.out.println("Program using memory storage");
				AbstractKickstarter kickstarter = new KickstarterMemory();
				kickstarter.start();
				break;
		}
	}
}
