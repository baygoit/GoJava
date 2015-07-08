package goit.nz.kickstarter.util;

import goit.nz.kickstarter.controller.Navigator;

public class ConsoleListener {
	private Console console;
	private Navigator navigator;

	public ConsoleListener(Navigator navigator) {
		console = new Console();
		this.navigator = navigator;
	}

	public void listen(int inputRange) {
		int start = 0;
		String prompt = "";
		if (inputRange > 0) {
			prompt = "Input your choice (" + String.valueOf(start + 1) + " - "
					+ String.valueOf(inputRange) + " , 0 - exit):";
			console.write(prompt);
		}
		int result = console.readInt();
		while (result < start || result > inputRange) {
			console.write("Invalid selection!");
			console.write(prompt);
			result = console.readInt();
		}
		navigator.update(result);
	}
}
