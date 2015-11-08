package com.sergiisavin;

import java.util.Scanner;

import com.sergiisavin.candy.Candy;
import com.sergiisavin.factory.CandyFactory;
import com.sergiisavin.factory.colored.ColoredCandyFactory;
import com.sergiisavin.factory.sweet.SweetCandyFactory;

public class SimpleFactoryMethod {

	private static final String CHOOSE_BY_TYPE = "Chose the type of the candy ([H]oney / [J]elly / [C]hocolate): ";
	private static final String CHOOSE_BY_COLOR = "Chose the color of the candy ([R]ed / [G]reen / [B]lue): ";

	public static void main(String[] args) {

		Candy candy = null;
		CandyFactory factory = new SweetCandyFactory();
	//	CandyFactory factory = new ColoredCandyFactory();
		
		String input = "";
		System.out
				.print(CHOOSE_BY_TYPE);

		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();

		candy = factory.createCandy(input);

		candy.printDescription();

		createOneMoreCandy(input, factory);
		createYetAnotherCandy(input, factory);
	}

	private static void createOneMoreCandy(String type, CandyFactory factory) {

		System.out.println("Creating one more candy...");

		Candy candy = factory.createCandy(type);
		candy.printDescription();


	}

	private static void createYetAnotherCandy(String type, CandyFactory factory) {
		System.out.println("Creating yet another candy...");

		Candy candy = factory.createCandy(type);
		candy.printDescription();
	}

}
