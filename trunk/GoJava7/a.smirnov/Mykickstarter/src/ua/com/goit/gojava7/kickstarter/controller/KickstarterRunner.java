package ua.com.goit.gojava7.kickstarter.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KickstarterRunner {	
	
	public static void main(String[] args) {
		new KickstarterRunner().selectProgramMode();
	}
	
	private void selectProgramMode() {
		int userChoiseMode = 0;
	
		String startMenu = "Please select starting program mode (by default memory storage) : \n"
							+ "1 : memory storage \n"
							+ "2 : files storage \n"
							+ "3 : database storage";
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
				AbstractKickstarter kickstarter = new KickstarterMemoryStorage();
				kickstarter.start();
				break;
			}
			case 2 : {
				System.out.println("Program using files storage");
				AbstractKickstarter kickstarter = new KickstarterFilesStorage();
				kickstarter.start();
				break;
			}
			case 3 : {
				System.out.println("Program using database storage");
				AbstractKickstarter kickstarter = new KickstarterDatabaseStorage();
				kickstarter.start();
				break;
			}
			default:
				System.out.println("Program using memory storage");
				AbstractKickstarter kickstarter = new KickstarterMemoryStorage();
				kickstarter.start();
				break;
		}
	}
}
