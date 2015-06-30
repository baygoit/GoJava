package ua.com.goit.belskii.artem;

public class App {
	public static void main(String[] args) {

		Input consoleIn = new Input();
		consoleIn.setString();
		consoleIn.getInput();
		Division division = new Division(consoleIn.getInput());
		division.calculate();
	}

}
