package ua.com.goit.gojava.myshko;

import java.util.Scanner;

class Menu {
	
	private void processCommand(String command) {
	
		if (command.contentEquals("-show")) {
			
			ProjectPNL manager = new ProjectPNL();
			manager.show();
			
		} else if (command.contentEquals("-update")) {
	
			ProjectPNL manager = new ProjectPNL();
			manager.update();
		
		} else if (!command.isEmpty()) {
		
			System.out.println("Unknown command");
			
		}
		
	}
	
	public void show() {

		System.out.println("Welcome to 'Project Office Management System'!");
		System.out.println("Type '-show' for view data, '-update' for update data or press Enter for exit:");
		
		Scanner sc = new Scanner(System.in);
		String command = ""; 
		
		if(sc.hasNextLine()) {
			command = sc.nextLine();
			processCommand(command);
		}
		
		sc.close();
		
	}
	
}
