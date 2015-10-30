package ua.goit7.vovat;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  The DivisionAlgorithm class provides static method for division an
 *  integer on integer.
 *  
 *  @author Trentovskyj
 */
public class Division {

	private static final int BASE_MULTIPLIER = 10;
	private static final int DECIMAL_PLACES = 100;

	public static void main(String[] args) {

		String operation = "";

		if (args.length != 0) {
			operation = args[0];
		} else {
			operation = scanUserInput();
		}
		checkInput(operation);

		String strArray[] = operation.split("/");

		ArrayList<String> log = makeDivision(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1]));

		log.stream().forEach(n -> System.out.println(n));
	}

	private static ArrayList<String> makeDivision(int dividend, int divisor) {

		ArrayList<String> result = new ArrayList<String>();
		result.add(" " + dividend + " |" + divisor);

		QuotientBuilder quotientBuilder = new QuotientBuilder();

		division(dividend, divisor, "", quotientBuilder, result);

		result.set(1, "----------");
		result.set(2, result.get(2) + "| " + quotientBuilder.get());

		return result;
	}

	private static void checkInput(String operation) {

		Pattern pattern = Pattern.compile("\\d+/\\d+");
		Matcher matcher = pattern.matcher(operation);

		if (!matcher.find()) {
			System.out.println("Invalid input");
			System.exit(0);
		}
	}

	/**
	 * Division dividend on divisor and return result.
	 * 
	 * @param dividend an integer           
	 * @param divisor an integer         
	 * @return a String
	 */
	public static String division(int dividend, int divisor) {
		ArrayList<String> result = new ArrayList<String>();

		QuotientBuilder quotientBuilder = new QuotientBuilder();

		division(dividend, divisor, "", quotientBuilder, result);

		return quotientBuilder.get();
	}

	private static void division(int dividend, int divisor, String leftMargin, QuotientBuilder quotientBuilder,
			ArrayList<String> result) {

		int curentDividend = getCurentDividend(Integer.toString(dividend), Integer.toString(divisor), quotientBuilder);

		result.add(leftMargin + " " + curentDividend);

		int product = divide(curentDividend, divisor, quotientBuilder);

		result.add(leftMargin + "-" + product);
		result.add(leftMargin + " ----");
		leftMargin += " ";

		if (checkEnd(dividend, quotientBuilder, curentDividend, product)) {

			int difference = (int) Math.pow(BASE_MULTIPLIER,
					Math.max(length(dividend) - Math.min(length(curentDividend), length(product)), 0));
			if (dividend == (product * difference)) {
				quotientBuilder.multiply(difference);
			} else {
				
				int nextStepDividend = findNextStepDividend(dividend, divisor, quotientBuilder, curentDividend, product,
						difference);

				division(nextStepDividend, divisor, leftMargin, quotientBuilder, result);
			}
		}

	}

	private static boolean checkEnd(int dividend, QuotientBuilder quotientBuilder, int curentDividend, int product) {
		return (product % dividend != 0 || curentDividend % product != 0)
				&& quotientBuilder.get().length() < DECIMAL_PLACES;
	}

	private static int findNextStepDividend(int dividend, int divisor, QuotientBuilder quotientBuilder,
			int curentDividend, int product, int difference) {
		
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

	private static int divide(int curentDividend, int divisor, QuotientBuilder quotientBuilder) {
		int c = curentDividend / divisor;
		quotientBuilder.add(c);
		int product = c * divisor;
		return product;
	}

	private static Integer length(int in) {
		return Integer.toString(in).length();
	}

	private static Integer getCurentDividend(String dividend, String divisor, QuotientBuilder quotientBuilder) {

		int a = Integer.parseInt(dividend.substring(0, Math.min(dividend.length(), divisor.length())));

		String newA = dividend;
		while (a < Integer.parseInt(divisor)) {
			if (dividend.length() > divisor.length()) {
				newA = dividend.substring(0, divisor.length() + 1);
			} else {
				newA += "0";
				if (quotientBuilder.get() == "") {
					quotientBuilder.add("0.");
				} else if (!quotientBuilder.get().contains(".")) {
					quotientBuilder.add(".");
				} else if (dividend.length() + 1 < newA.length()) {
					quotientBuilder.add("0");
				}
			}
			a = Integer.parseInt(newA);
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

	public void multiply(int toMultiply) {
		quotient = Integer.toString(Integer.parseInt(quotient) * toMultiply);
	}
}
