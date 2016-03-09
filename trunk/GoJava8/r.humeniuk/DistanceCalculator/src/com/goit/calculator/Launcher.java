package com.goit.calculator;
import java.util.ArrayList;

public class Launcher {

	public static void main(String[] args) {
		ArrayList<Integer> inputArray = new ArrayList<>();
		ArrayGenerator generator = new ArrayGenerator(10, 10);
		inputArray = generator.getArray();
		System.out.println("input array:");
		System.out.println(inputArray);
		System.out.println("distanse betven elements:");
		Calculator c = new Calculator(inputArray);
		System.out.println(c.getDistance());
	}

}
