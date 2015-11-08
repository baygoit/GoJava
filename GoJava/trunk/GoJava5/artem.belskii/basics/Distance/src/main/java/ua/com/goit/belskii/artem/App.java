package ua.com.goit.belskii.artem;


public class App {
	public static void main(String[] args) {
		Input consoleIn = new Input();
		consoleIn.read();
		Distance distance = new Distance();
		System.out.println(distance.findDistance(consoleIn.write()));
	}
}
