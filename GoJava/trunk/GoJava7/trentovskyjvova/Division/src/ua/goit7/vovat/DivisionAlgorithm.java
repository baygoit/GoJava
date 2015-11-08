// OLEG not perfect package name. We are goit.com.ua. It can be OK if have this naming in our code conventions. Did you create it? :)
package ua.goit7.vovat;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DivisionAlgorithm {

	private static final int BASE_MULTIPLIER = 10;
	private static final int DECIMAL_PLACES = 100;

	// OLEG what about period? :)
	// OLEG why it stops after these numbers for 234/54645? what is criteria?
	public static void main(String[] args) {

		String operation = "";

		// OLEG nice, really. But how I know about this? Any documentation?
		if (args.length != 0) {
			operation = args[0];
		} else {
			operation = scanUserInput();
		}
		checkInput(operation);

		// OLEG what is we will have another method to parse user input and return dividend and divisor?
		// OLEG Simple we have checkInput to check it, but parsing is not clear
		// OLEG We have to assume that [0] is dividend and [1] is divisor in strArray
		// OLEG and strArray is not good enough name here
		// OLEG introduction a method with fix this I think
		String strArray[] = operation.split("/");

		// OLEG I think, we can move all previous lines into separated methods. So main will be clearer

		// OLEG we can use just List, not ArrayList here. Or this ArrayList is meaningful?
		// OLEG It's not clear for my, why makeDivision build List. And then we just print log.
		// OLEG it's clear that makeDivision format lines in log
		// OLEG so it's "makeDivisionAndReturnLogReadyForPrinting" :)
		ArrayList<String> log = makeDivision(
				// OLEG nice, are you sure our chechInput good enough that we never will get NumberFormatException?
				// OLEG may be we can use Integer.parseInt to validate input instead of regexp? or both?
				// OLEG currently application will work incorrect for 1253452342342/235345456434534534534534
				// OLEG and by the way, remember, that 234_234 is correct integer for java 8
				Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1]));

		log.stream().forEach(n -> System.out.println(n));
	}

	// OLEG do not use ArrayList as return parameters. Use just List. Try to use the class from the top of hierarchy
	private static ArrayList<String> makeDivision(int dividend, int divisor) {

		ArrayList<String> result = new ArrayList<String>();

		result.add(" " + dividend + " |" + divisor);

		QuotientBuilder quotientBuilder = new QuotientBuilder();

		division(dividend, divisor, "", quotientBuilder, result);

		// OLEG It's not clear. May be move for a spesial method?
		// OLEG or even split representation and division steps data?
		result.set(1, "----------");
		result.set(2, result.get(2) + "| " + quotientBuilder.get());

		return result;
	}

	private static void checkInput(String operation) {

		Pattern pattern = Pattern.compile("\\d+/\\d+");
		Matcher matcher = pattern.matcher(operation);

		if (!matcher.find()) {
			System.out.println("Invalid input");
			// OLEG should be used with case. See http://www.javapractices.com/topic/TopicAction.do?Id=86
			// OLEG try to avoid this.
			System.exit(0);
		}
	}

	// OLEG am I used?
	public static String division(int dividend, int divisor) {
		ArrayList<String> result = new ArrayList<String>();
		QuotientBuilder quotientBuilder = new QuotientBuilder();

		division(dividend, divisor, "", quotientBuilder, result);

		return quotientBuilder.get();
	}

	// OLEG division is not related with verb. May be it should be divide?
	// OLEG What is left margin? Margin for what?
	// OLEG ArrayList => List
	private static void division(int dividend, int divisor, String leftMargin, QuotientBuilder quotientBuilder, ArrayList<String> result) {

		// OLEG Why we convert them to String?
		// OLEG curent => current
		// OLEG what is current dividend?
		// OLEG OK, after debugging it's clear that getCurrent
		int curentDividend = getCurentDividend(Integer.toString(dividend), Integer.toString(divisor), quotientBuilder);

		result.add(leftMargin + " " + curentDividend);

		// OLEG product? May be quotient?
		int product = divide(curentDividend, divisor, quotientBuilder);

		result.add(leftMargin + "-" + product);
		result.add(leftMargin + " ----");
		// OLEG it is for formatting yes? SRL?
		leftMargin += " ";

		if (checkEnd(dividend, quotientBuilder, curentDividend, product)) {

			// OLEG I am not sure I understand this. length method doesn't help with understanding
			int degree = Math.max(length(dividend) - Math.min(length(curentDividend), length(product)), 0);
			// OLEG difference of what?
			int difference = (int) Math.pow(BASE_MULTIPLIER, degree);

			// OLEG what we check here?
			if (dividend == (product * difference)) {
				quotientBuilder.multiply(difference);
			} else {
				int nextStepDividend = findNextStepDividend(dividend, divisor, quotientBuilder, curentDividend, product, difference);

				division(nextStepDividend, divisor, leftMargin, quotientBuilder, result);
			}
		}

	}

	// OLEG is is better to start the name of method returns boolean with is,has etc.
	// OLEG why the end depends on number of numbers after dot, not on period?
	private static boolean checkEnd(int dividend, QuotientBuilder quotientBuilder, int curentDividend, int product) {

		return (product % dividend != 0 || curentDividend % product != 0) && (quotientBuilder.get().length() < DECIMAL_PLACES);
	}

	// OLEG a lot of logic :( I am tired to go further
	private static int findNextStepDividend(int dividend, int divisor, QuotientBuilder quotientBuilder, int curentDividend, int product, int difference) {

		int nextStepDividend = 0;
		int minus = product * difference;

		if (curentDividend < minus) {
			if (dividend > minus) {
				nextStepDividend = dividend - minus;
				if (nextStepDividend < divisor) {
					quotientBuilder.multiply(difference);
				} else {
					int zerosToAdd = length(minus) - length(nextStepDividend) - length(product);
					if (zerosToAdd > 0) {
						quotientBuilder.multiply((int) Math.pow(BASE_MULTIPLIER, zerosToAdd));
					}
				}
			} else {
				nextStepDividend = dividend - product;
				if (!quotientBuilder.get().contains(".")) {
					quotientBuilder.add(".");
				}
			}
		} else {
			nextStepDividend = curentDividend - minus;
		}
		return nextStepDividend;
	}

	// OLEG OK, i am divide and return what?
	private static int divide(int curentDividend, int divisor, QuotientBuilder quotientBuilder) {

		int c = curentDividend / divisor;

		quotientBuilder.add(c);

		return c * divisor;
	}

	private static Integer length(int i) {
		return Integer.toString(i).length();
	}

	private static Integer getCurentDividend(String dividend, String divisor, QuotientBuilder quotientBuilder) {
		// OLEG and now convert them back
		// OLEG what is substring?
		// OLEG it will be more readable if we introduce new variable with min() value with nice name
		// OLEG substring of type int. Perversion.
		int substring = Integer.parseInt(dividend.substring(0, Math.min(dividend.length(), divisor.length())));
		// OLEG what is newA for? Bad name
		String newA = dividend;

		while (substring < Integer.parseInt(divisor)) {
			if (dividend.length() > divisor.length()) {
				newA = dividend.substring(0, divisor.length() + 1);
			} else {
				// OLEG it looks like substring*10
				newA += "0";
				if (quotientBuilder.get() == "") {
					quotientBuilder.add("0.");
				} else if (!quotientBuilder.get().contains(".")) {
					quotientBuilder.add(".");
				} else if (dividend.length() + 1 < newA.length()) {
					quotientBuilder.add("0");
				}
			}
			substring = Integer.parseInt(newA);
		}
		return Integer.parseInt(newA);
	}

	private static String scanUserInput() {
		System.out.println("Enter the command like 24/48");

		Scanner scanner = new Scanner(System.in);
		String input = "";

		if (scanner.hasNextLine()) {
			input = scanner.nextLine();
		}
		scanner.close();

		return input;
	}

}

// OLEG This class is not clear for me. What is it for? Why it is package private?
// OLEG Why we use String+String instead of StringBuilder?
class QuotientBuilder {
	private String quotient = "";

	public String get() {
		return quotient;
	}

	public void add(String toAdd) {
		quotient += toAdd;
	}

	public void add(int toAdd) {
		quotient += toAdd;
	}

	// OLEG bad variable name. toMultiply => multiplier?
	public void multiply(int toMultiply) {
		// OLEG why we are doing this converting from string to int and back?
		quotient = Integer.toString(Integer.parseInt(quotient) * toMultiply);
	}
}
