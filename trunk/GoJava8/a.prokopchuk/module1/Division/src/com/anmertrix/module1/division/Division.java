package com.anmertrix.module1.division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Division {

	private static final int RESULT_ACCURACY = 11;
	private static final String VERTICAL_SEPARATOR = "|";
	private static final String HORIZONTAL_SEPARATOR = "---";

	public static void main(String[] args) throws IOException {
		String line = readUserNumbers();
		String[] lineParts = line.split("/");
		int[] numberList = new int[2];
		for (int i = 0; i < lineParts.length; i++) {
			try {
				numberList[i] = Integer.parseInt(lineParts[i]);
			} catch (Exception e) {
				System.out.println("You can enter only numbers.");
				return;
			}
		}
		int partible = numberList[0];
		int divider = numberList[1];
		printDivision(partible, divider);

	}

	private static String readUserNumbers() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String numbersLine = reader.readLine();
		reader.close();

		return numbersLine;
	}

	public static void printDivision(int divident, int divisor) {

		StringBuilder wholeProcessDivision = new StringBuilder();
		StringBuilder indent = new StringBuilder();
		StringBuilder wholeNumber = new StringBuilder();
		StringBuilder firstCurrentMinus = new StringBuilder();
		StringBuilder fractionNumber = new StringBuilder();
		List<Integer> remains = new LinkedList<Integer>();
		StringBuilder processDivision = new StringBuilder();

		if (divident > 0) {
			wholeProcessDivision.append("  " + divident + " "
					+ VERTICAL_SEPARATOR + divisor + "\n");
		} else {
			wholeProcessDivision.append(" " + divident + " "
					+ VERTICAL_SEPARATOR + divisor + "\n");
		}

		if (divident < 0 || divisor < 0) {
			divident = Math.abs(divident);
			divisor = Math.abs(divisor);
			wholeNumber.append("-");
		}

		for (int i = 0; i <= RESULT_ACCURACY; i++) {
			int result = divident / divisor;
			int remainder = divident % divisor;
			int currentMinus = divisor * result;
			if (i == 0) {
				firstCurrentMinus.append("  -").append(currentMinus);
				processDivision.append(indent).append(" ")
						.append(HORIZONTAL_SEPARATOR).append("\n");
			} else {
				processDivision.append(indent).append(" ").append(divident)
						.append("\n");
				processDivision.append(indent).append("-").append(currentMinus)
						.append("\n");
				processDivision.append(indent).append(" ")
						.append(HORIZONTAL_SEPARATOR).append("\n");
			}
			indent.append(" ");

			if (i == 0) {
				wholeNumber.append(result);
			} else {
				fractionNumber.append(result);
			}

			if (remainder == 0) {
				break;
			} else if (remains.contains(remainder)) {
				fractionNumber.insert(remains.indexOf(remainder), "(");
				fractionNumber.append(")");
				processDivision.append(indent).append(" ").append(remainder)
						.append("\n");
				break;
			}

			divident = remainder * 10;
			remains.add(remainder);
		}

		if (fractionNumber.length() > 0) {
			fractionNumber.insert(0, ".");
		}

		wholeProcessDivision.append(firstCurrentMinus).append("|")
				.append(wholeNumber).append(fractionNumber).append("\n")
				.append(processDivision);
		System.out.println(wholeProcessDivision);

	}

}
