package ua.com.goit.belskii.artem;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		while (repeat) {
			Input consoleIn = new Input();
			consoleIn.setString();
			consoleIn.getInput();
			Division division = new Division(consoleIn.getInput());
			division.calculate();
			System.out.println("Try another? Press enter and put new value! If you want close app, pleas put \"q\", and press enter");
			if (input.nextLine().equals("q")){
				repeat=false;
			}
		}
	}

}
