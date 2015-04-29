<<<<<<< .mine
package go_java_4.vadya_zakusylo.java_basics;

import java.util.Scanner;

public class LongDivision {

	public static void main(String[] args) {
		int firstValue = input("first");
		int secondValue = input("second");
		divide(firstValue, secondValue);
	}

	private static int input(String arg) {
		Scanner inputValue = new Scanner(System.in);
		System.out.println("Input " + arg + " value.");
		int value = inputValue.nextInt();
		return value;
	}

	private static void divide(int firstValue, int secondValue) {
		double result = (double) firstValue / secondValue;
		int modulo = (int) countModulo(firstValue, secondValue);
		int wholeValue = (int) countWholeValue(firstValue, secondValue);
		System.out.println("Long division:");
		System.out.println("\t" + firstValue + "\t|\t" + secondValue);
		System.out.println("-\t" + wholeValue + "\t|\t" + result);
		printLongDivision(secondValue, modulo);
	}

	private static void printLongDivision(int secondValue, int modulo) {
		String indentation = " " + "\t";
		for (int iteration = 0; iteration < 10; iteration++) {
			int printModulo = countOfModulo(modulo, secondValue);
			System.out.println(indentation + printModulo);
			if (printModulo == 0) {
				break;
			}
			int printWholeValue = countOfWholeValue(printModulo, secondValue);
			System.out.println("-" + indentation + printWholeValue);
			modulo = printModulo - printWholeValue;
			indentation = indentation + "  ";
		}
	}

	private static int countOfModulo(int modulo, int secondValue) {
		if ((double) modulo / secondValue > 0.1) {
			modulo *= 10;
		} else {
			modulo *= 100;
		}
		return modulo;
	}

	private static int countOfWholeValue(int printModulo, int secondValue) {
		int wholeValue = (int) countWholeValue(printModulo, secondValue);
		return wholeValue;

	}

	private static double countModulo(int firstValue, int secondValue) {
		double modulo = (double) firstValue / secondValue;
		if (modulo > 1) {
			modulo = firstValue % secondValue;
		} else if (modulo > 1) {
			modulo = firstValue % secondValue;
		} else if (modulo < 0.1) {
			modulo = 100 * firstValue % secondValue;
		} else {
			modulo = 10 * firstValue % secondValue;
		}
		return modulo;
	}

	private static double countWholeValue(int firstValue, int secondValue) {
		double resultOfDivision = (double) firstValue / secondValue;
		if (resultOfDivision > 1) {
			resultOfDivision = firstValue / secondValue * secondValue;
		} else if (resultOfDivision < 0.1) {
			resultOfDivision = 100 * firstValue / secondValue;
		} else {
			resultOfDivision = 10 * firstValue / secondValue;
		}
		return resultOfDivision;
	}
}
=======
package go_java_4.vadya_zakusylo.java_basics;

import java.util.Scanner;

public class LongDivision {

	public static void main(String[] args) {
		int firstValue = input("first");
		int secondValue = input("second");
		divide(firstValue, secondValue);
	}

	private static int input(String arg) {
		Scanner inputValue = new Scanner(System.in);
		System.out.println("Input " + arg + " value.");
		int value = inputValue.nextInt();
		return value;
	}

	private static void divide(int firstValue, int secondValue) {
		double result = (double) firstValue / secondValue;
		int modulo = (int) countModulo(firstValue, secondValue);
		int wholeValue = (int) countWholeValue(firstValue, secondValue);
		System.out.println("Long division:");
		System.out.println("\t" + firstValue + "\t|\t" + secondValue);
		System.out.println("-\t" + wholeValue + "\t|\t" + result);
		printLongDivision(secondValue, modulo);
	}

	private static void printLongDivision(int secondValue, int modulo) {
		String indentation = " " + "\t";
		for (int iteration = 0; iteration < 10; iteration++) {
			int printModulo = countOfModulo(modulo, secondValue);
			System.out.println(indentation + printModulo);
			if (printModulo == 0) {
				break;
			}
			int printWholeValue = countOfWholeValue(printModulo, secondValue);
			System.out.println("-" + indentation + printWholeValue);
			modulo = printModulo - printWholeValue;
			indentation = indentation + "  ";
		}
	}

	private static int countOfModulo(int modulo, int secondValue) {
		if ((double) modulo / secondValue > 0.1) {
			modulo *= 10;
		} else {
			modulo *= 100;
		}
		return modulo;
	}

	private static int countOfWholeValue(int printModulo, int secondValue) {
		int wholeValue = (int) countWholeValue(printModulo, secondValue);
		return wholeValue;

	}

	private static double countModulo(int firstValue, int secondValue) {
		double modulo = (double) firstValue / secondValue;
		if (modulo > 1) {
			modulo = firstValue % secondValue;
		} else if (modulo < 0.1) {
			modulo = 100 * firstValue % secondValue;
		} else {
			modulo = 10 * firstValue % secondValue;
		}
		return modulo;
	}

	private static double countWholeValue(int firstValue, int secondValue) {
		double resultOfDivision = (double) firstValue / secondValue;
		if (resultOfDivision > 1) {
			resultOfDivision = firstValue / secondValue * secondValue;
		} else if (resultOfDivision < 0.1) {
			resultOfDivision = 100 * firstValue / secondValue;
		} else {
			resultOfDivision = 10 * firstValue / secondValue;
		}
		return resultOfDivision;
	}
}>>>>>>> .r3623
