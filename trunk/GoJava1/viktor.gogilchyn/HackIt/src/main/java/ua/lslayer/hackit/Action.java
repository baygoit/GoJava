package ua.lslayer.hackit;

import java.util.Arrays;
import java.util.List;

public class Action {
	private static final List<String> ACTIONS = Arrays.asList("help","exit","list");
	public void execute(String action) {
		if (ACTIONS.contains(action)) {
			switch (action) {
			case "help" :
				System.out.println("help - writes this message");
				System.out.println("exit - quits game");
				System.out.println("list - shows some info");
				break;
			case "exit" : 
				System.exit(0);
				break; //No sense, yeah? 
			case "list" :
				System.out.println("list - shows some info");
				break;
			default : 
				System.out.println("Invalid command, type help to see all avalable commands");
			}
		}
	}
	
	
}
