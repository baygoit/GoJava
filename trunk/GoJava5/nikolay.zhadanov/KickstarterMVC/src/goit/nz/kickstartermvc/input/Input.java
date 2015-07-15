package goit.nz.kickstartermvc.input;

import java.util.Scanner;

public class Input {
	
	private InputListener listener;

	public void registerListener(InputListener listener) {
		this.listener = listener;
	}
	
	public void listenInput() {
		Scanner scanner  = new Scanner(System.in);
		while (scanner.hasNext()) {
			if (listener.onInput(scanner.next()) < 0) {
				break;
			}
		}
		scanner.close();
	}
}
