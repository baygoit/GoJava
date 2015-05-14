package UserInterface;

import java.io.IOException;
import java.util.ArrayList;

public class ConsoleOut implements Output {

	@Override
	public void print(ArrayList<String> page) {
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
