package com.tyomsky;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Division {
	
	public static final String DELIMITER = "/";
	public static final int ACCURACY = 100;
	public static final String VERTICAL_SEPARATOR = "|";
	public static final String HORIZONTAL_SEPARATOR = "---";
	
	public static BufferedReader consoleReader;
	
	public static void main(String[] args) throws IOException{
		consoleReader = new BufferedReader(new InputStreamReader(System.in));
		boolean isFinished = false;
		while (!isFinished) {
			int[] operands = getOperandsFromConsole();
			if (operands != null) {
				String output = calculateDivisionWithOutput(operands[0], operands[1]);
				System.out.println(output);
			}
			System.out.println("Try again? (y/n)");
			if (!consoleReader.readLine().equals("y")) {
				isFinished = true;
			}
		}
	}

	private static String calculateDivisionWithOutput(int divident, int divisor) {
		int result;
		int remaining;
		int currentMinus;
		HashMap<Integer, Integer> operandsMap = new HashMap<>();
		String completeResultString = "";
		String resultString = "";
		String commentString = "";

		completeResultString += +divident + VERTICAL_SEPARATOR + divisor + "\n";

		for (int index = 0; index <= ACCURACY; index++) {
			result = divident / divisor;
			remaining = divident % divisor;
			currentMinus = result * divisor;
			resultString = addToResult(resultString, result);
			commentString = addToComments(commentString, divident, currentMinus, index);
			if (remaining == 0) {
				break;
			}
			divident = remaining * 10;

			if (operandsMap.get(divident) != null) {
				resultString = formatResultForPeriod(resultString, operandsMap.get(divident));
				break;
			}
			operandsMap.put(divident, index);
		}
		completeResultString += formatCompleteResult(completeResultString, resultString, commentString);

		return completeResultString;
	}

	private static String formatCompleteResult(String completeResultString, String resultString, String commentString) {
		
		String result = "";
		String firstCommentString = commentString.substring(0, commentString.indexOf("\n"));
		String commentTail = commentString.substring(commentString.indexOf("\n") + "\n".length());
		
		result += firstCommentString + VERTICAL_SEPARATOR + resultString + "\n" + commentTail;

		return result;
	}

	private static int[] getOperandsFromConsole() {
		int[] result = null;
		try {
			System.out.println("Enter your expression in format \"x/y\"");
			String[] input = consoleReader.readLine().split(DELIMITER);

			result = new int[2];

			if (input.length == 2) {
				result[0] = Integer.parseInt(input[0]);
				result[1] = Integer.parseInt(input[1]);
				if (result[1] == 0) {
					System.out.println("Bad idea!");
					result = null;
				}
			} else {
				System.out.println("2 numbers are needed!");
				result = null;
			}

		} catch (IOException e) {
			System.out.println(e.getStackTrace());
			result = null;
		} catch (NumberFormatException e) {
			System.out.println("Cant read values. Try integers (x/y)");
			result = null;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			result = null;
		}

		return result;
	}

	private static String addToResult(String resultString, int divisionResult) {
		if (!resultString.isEmpty() && resultString.indexOf(".") < 0) {
			resultString += "." + divisionResult;
		} else {
			resultString += divisionResult;
		}
		return resultString;
	}

	private static String addToComments(String comments, int operand1, int operand2, int operationIndex) {
		boolean firstCommentString = comments.isEmpty();
		String firstRow = "";
		String secondRow = "";
		String separator = HORIZONTAL_SEPARATOR;

		StringBuilder sbSpace = new StringBuilder();
		for (int i = 0; i <= operationIndex; i++) {
			sbSpace.append(" ");
		}

		String prefix = sbSpace.toString();
		String prefixWithMinus = sbSpace.deleteCharAt(operationIndex).append("-").toString();

		firstRow = String.valueOf(operand1);
		secondRow = String.valueOf(operand2);
		if (firstCommentString) {
			comments += prefixWithMinus + secondRow + "\n" // prefix - minus
					+ prefix + separator + "\n";
		} else {
			comments += prefix + firstRow + "\n" + prefixWithMinus + secondRow + "\n" + prefix + separator + "\n";
		}
		return comments;

	}

	private static String formatResultForPeriod(String resultString, int index) {
		resultString = resultString.substring(0, index + 2) + "(" + resultString.substring(index + 2) + ")";
		return resultString;
	}

}