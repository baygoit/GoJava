package ua.goit7.vovat;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Division {

	private static String result = "";
	private static String leftMargin = "";
	private static ArrayList<String> log = new ArrayList<String>();

	public static void main(String[] args) {

		String operation = "";

		if (args.length != 0) {
			operation = args[0];
		} else {
			operation = scanUserInput();
		}
		checkInput(operation);

		String strArray[] = operation.split("/");

		System.out.println(" " + strArray[0] + " |" + strArray[1]);

		// recursion count
		division(strArray[0], strArray[1]);

		log.set(0, "----------");
		log.set(1, log.get(1) + "| " + result);
		for (String strLog : log) {
			System.out.println(strLog);
		}

	}

	private static void checkInput(String operation) {
		
		Pattern p = Pattern.compile("\\d+/\\d+");
		Matcher matcher = p.matcher(operation);

		if (!matcher.find()) {
			System.out.println("Invalid input");
			System.exit(0);
		}
	}

	private static void division(String first, String second) {
		int lengthA = first.length();
		int lengthB = second.length();

		int a = Integer.parseInt(first.substring(0, Math.min(lengthA, lengthB)));
		int b = Integer.parseInt(second);

		String newA = first;
		while (a < b) {
			if (lengthA > lengthB) {
				newA = first.substring(0, lengthB + 1);
				a = Integer.parseInt(newA);
			} else {
				newA += "0";
				a *= 10;
				if (result == "") {
					result = "0.";
				} else if (!result.contains(".")) {
					result += ".";
				} else if (first.length() + 1 < newA.length()) {
					result += "0";
				}
			}
		}

		log.add(leftMargin + " " + a);

		int quotient = a / b;
		result += quotient;
		int product = quotient * b;

		log.add(leftMargin + "-" + product);

		log.add(leftMargin + " ----");
		leftMargin += " ";

		int firstA = Integer.parseInt(first);
		if ((product % firstA != 0 || a % product != 0) && result.length() < 30) {
			int difference = (int) Math.pow(10,
					Math.max(lengthA - Math.min(newA.length(), Integer.toString(product).length()), 0));
			if (firstA == (product * difference)) {
				result = Integer.toString(Integer.parseInt(result) * difference);
			} else {
				int nextStepInt = 0;
				int minus = product * difference;
				if (a < minus) {
					if (firstA > minus) {
						nextStepInt = firstA - minus;
						if (nextStepInt < b) {
							result = Integer.toString(Integer.parseInt(result) * difference);
						} else {
							int zero = Integer.toString(minus).length() - Integer.toString(nextStepInt).length()
									- Integer.toString(product).length();
							if (zero > 0) {
								result = Integer.toString(Integer.parseInt(result) * (int) Math.pow(10, zero));
							}
						}
					} else {
						nextStepInt = firstA - product;
						if (!result.contains(".")) {
							result += ".";
						}
					}
				} else {
					nextStepInt = a - (product * difference);
				}

				division(Integer.toString(Math.abs(nextStepInt)), second);
			}
		}
	}

	private static String scanUserInput() {
		
		System.out.println("Enter the command like 24/48");
		Scanner s = new Scanner(System.in);

		String str = "";
		if (s.hasNextLine()) {
			str = s.nextLine();
		}
		s.close();
		
		return str;
	}

}
