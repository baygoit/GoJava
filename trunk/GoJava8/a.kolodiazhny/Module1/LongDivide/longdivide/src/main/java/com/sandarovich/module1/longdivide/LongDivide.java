package com.sandarovich.module1.longdivide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Olexander Kolodiazhny
 * 
 *         Module #1. Task #4 Column Divide algorithm with text output.
 *
 */

public class LongDivide {
	private static final String COLUMN_DIVIDER = "|";
	private static final String OPERATION_DIVIDER = "---";
	private static final String OPERATION_MINUS = "-";
	private static final String SPACE = " ";
	private static final String BRACKET_LEFT = "(";
	private static final String BRACKET_RIGHT = ")";
	private static final int DIVIDE_DEPTH = 6;
	private static final int GUESS_LIMIT = 10;
	private static final int MULTIPLYER = 10;
	private static final String TAB = "  ";
	private int dividen;
	private int divider;
	private double result = 0;
	private int remain = -1;
	private int diff;
	private int firstDiff;
	private int depth = 0;
	List<String> resultStr;

	public void readNumbers() {
		while (!parseInput(readFromKeyboard())) {
			System.out.println("\nWARNING!. Input is incorrect. Please try again.\n");
		}
	}

	private String readFromKeyboard() {
		System.out.println("Please enter input. Example \"12/42\"");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String inputString = null;
		try {
			inputString = bufferedReader.readLine();
		} catch (IOException e) {
			inputString = "-1";
		}
		return inputString;
	}

	private boolean parseInput(String inputString) {
		if (inputString.equals(null) || inputString.equals("-1")) {
			return false;
		} else {
			String[] numbers = inputString.split("/");
			try {
				dividen = Integer.parseInt(numbers[0]);
				divider = Integer.parseInt(numbers[1]);
			} catch (Exception e) {
				return false;
			}
			System.out.println(">> Input parsed Successfully<<");
			return true;
		}
	}

	public void showResult() {
		
		resultStr = new ArrayList<String>();
		resultStr.add(OPERATION_MINUS + dividen + " " + COLUMN_DIVIDER + divider);
		calcRemain(dividen, divider);
		resultStr.add(1, TAB + this.firstDiff + COLUMN_DIVIDER + formatResult(this.result));
		resultStr.add(StringUtils.repeat(TAB, depth) + OPERATION_DIVIDER);
		resultStr.add(StringUtils.repeat(TAB, depth) + String.valueOf(this.remain));

		System.out.println("Results: ");
		for (String line : resultStr) {
			System.out.println(line);
		}
	}
	
	private String formatResult(double result) {
		String format = "%." + String.valueOf(DIVIDE_DEPTH) + "f";
		if (remain != 0 && depth == DIVIDE_DEPTH ) {
			return BRACKET_LEFT + String.format(format, result) + BRACKET_RIGHT;
		} 
		return String.format(format, result);
		
	}
	
	private double calcRemain(double dividen, double divider) {
		
		boolean ignoreOperation = false;
		if (remain == 0 || depth >= DIVIDE_DEPTH) {
			return remain;
		} else {
			if (dividen <= divider) {
				dividen = dividen * MULTIPLYER;
				depth++;
			} else {
				firstDiff = (int) divider * findGuessCoef(dividen, divider);
			}
			int multipl = findGuessCoef(dividen, divider);
			result += multipl / (Math.pow(MULTIPLYER, depth));
			this.diff = (int) (divider * multipl);
			if (depth == 1 && firstDiff == 0) {
				this.firstDiff = diff;
				ignoreOperation = true;
			}
			remain = (int) (dividen - divider * multipl);
			this.dividen = remain;
			
			if (!ignoreOperation) {
				resultStr.add(StringUtils.repeat(TAB, depth) + OPERATION_DIVIDER);
				resultStr.add(StringUtils.repeat(TAB, depth) + SPACE + (int) dividen);
				resultStr.add(StringUtils.repeat(TAB, depth) + OPERATION_MINUS + diff);
			} 
			ignoreOperation = false;

			return calcRemain(this.dividen, this.divider);
		}
	}

	private int findGuessCoef(double dividen, double divider) {
		int guessCoef = 0;

		for (int i = GUESS_LIMIT; i >= 1; i--) {
			if (divider * i <= dividen) {
				guessCoef = i;
				break;

			}
		}
		return guessCoef;
	}

}
