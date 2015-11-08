package goit.nz.kickstartermvc.input;

import java.util.Scanner;

public class Input {
	
	private ConsoleInputListener listener;

	public void registerListener(ConsoleInputListener listener) {
		this.listener = listener;
	}
	
	public void listenInput() {
		Scanner scanner  = new Scanner(System.in);
		while (scanner.hasNext()) {
			if (listener.onInput(scanner.nextLine()) < 0) {
				break;
			}
		}
		scanner.close();
	}
}
