package ua.lslayer.hackit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class GameConsole {
	private List<String> commands = new LinkedList<String>();
	private Action currentAction = new Action();

	private String readCommandFromSystemConsole() throws IOException {
		BufferedReader console = new BufferedReader( new InputStreamReader(System.in));
		String returnValue = console.readLine();
		return returnValue;
	}

	public void runNextCommand() {
		String currentCommand = "";
		try {
			currentCommand = readCommandFromSystemConsole();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		commands.add(currentCommand);
		currentAction.execute(currentCommand);
	}
}
