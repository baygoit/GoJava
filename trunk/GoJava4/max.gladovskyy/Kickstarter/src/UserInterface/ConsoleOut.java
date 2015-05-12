package UserInterface;

import java.io.IOException;

public class ConsoleOut implements Output {

	@Override
	public void print(String[] page) {
		clearConsole();
		for (String string : page) {
			System.out.println(string);
		}

	}

	private void clearConsole() {
		try {
			Runtime.getRuntime().exec("cls");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
