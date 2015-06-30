package ua.com.goit.belskii.artem;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Input consoleIn = new Input();
		consoleIn.setString();
		Distance distance = new Distance();
		System.out.println(distance.findDistance(consoleIn.getInput()));
	}
}
