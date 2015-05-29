package com.sergiisavin;

import java.util.Scanner;

import com.sergiisavin.candy.Candy;
import com.sergiisavin.candy.sweet.ChocolateCandy;
import com.sergiisavin.candy.sweet.HoneyCandy;
import com.sergiisavin.candy.sweet.JellyCandy;

public class Problem {

	private static final String CHOOSE_BY_TYPE = "Chose the type of the candy ([H]oney / [J]elly / [C]hocolate): ";
	private static final String CHOOSE_BY_COLOR = "Chose the color of the candy ([R]ed / [G]reen / [B]lue): ";

	
	public static void main(String[] args) {

		String input = "";
		System.out
				.print(CHOOSE_BY_TYPE);

		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();

		Candy candy = null;

		switch (input) {
		case "H":
			candy = new HoneyCandy();
			break;
		case "J":
			candy = new JellyCandy();
			break;
		case "C":
			candy = new ChocolateCandy();
			break;
		default:
			System.out.println("Wrong choice");
			System.exit(0);
		}

		candy.printDescription();

		createOneMoreCandy(input);
		createYetAnotherCandy(input);
	}

	private static void createYetAnotherCandy(String input) {
		Candy candy = null;

		switch (input) {
		case "H":
			candy = new HoneyCandy();
			break;
		case "J":
			candy = new JellyCandy();
			break;
		case "C":
			candy = new ChocolateCandy();
			break;
		default:
			System.out.println("Wrong choice");
			System.exit(0);
		}

		System.out.println("Creating yet another candy...");

		candy.printDescription();
		
	}

	private static void createOneMoreCandy(String input) {
		Candy candy = null;

		switch (input) {
		case "H":
			candy = new HoneyCandy();
			break;
		case "J":
			candy = new JellyCandy();
			break;
		case "C":
			candy = new ChocolateCandy();
			break;
		default:
			System.out.println("Wrong choice");
			System.exit(0);
		}

		System.out.println("Creating one more candy...");

		candy.printDescription();

	}

}